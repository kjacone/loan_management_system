#!/bin/bash
set -e

# Configuration
AWS_REGION="us-east-1"  # Change to your preferred region
STACK_NAME="loan-management-system"
ENVIRONMENT="dev"  # Options: dev, staging, prod

# Colors for output
GREEN="\033[0;32m"
YELLOW="\033[1;33m"
RED="\033[0;31m"
NC="\033[0m" # No Color

echo -e "${YELLOW}Starting deployment of Loan Management System to AWS...${NC}"

# Check if AWS CLI is installed
if ! command -v aws &> /dev/null; then
    echo -e "${RED}AWS CLI is not installed. Please install it first.${NC}"
    exit 1
fi

# Check if Docker is installed
if ! command -v docker &> /dev/null; then
    echo -e "${RED}Docker is not installed. Please install it first.${NC}"
    exit 1
fi

# Check if jq is installed
if ! command -v jq &> /dev/null; then
    echo -e "${RED}jq is not installed. Please install it first.${NC}"
    exit 1
fi

# 1. Build the services
echo -e "${YELLOW}Building services with Gradle...${NC}"
./gradlew clean build -x test

# 2. Create or update CloudFormation stack to create ECR repositories
echo -e "${YELLOW}Creating/updating CloudFormation stack for ECR repositories...${NC}"

# Get default VPC ID
VPC_ID=$(aws ec2 describe-vpcs --filters "Name=isDefault,Values=true" --query "Vpcs[0].VpcId" --output text --region $AWS_REGION)

# Get subnet IDs from default VPC
SUBNET_IDS=$(aws ec2 describe-subnets --filters "Name=vpc-id,Values=$VPC_ID" --query "Subnets[*].SubnetId" --output json --region $AWS_REGION)
SUBNET_LIST=$(echo $SUBNET_IDS | jq -r 'join(",")')

# Generate a temporary password for the database
DB_PASSWORD=$(openssl rand -base64 12)

# Deploy the CloudFormation stack
aws cloudformation deploy \
    --template-file main.yaml \
    --stack-name $STACK_NAME \
    --parameter-overrides \
        Environment=$ENVIRONMENT \
        ECRRepositoryName=$STACK_NAME \
        VpcId=$VPC_ID \
        "Subnets=$SUBNET_LIST" \
        DatabasePassword=$DB_PASSWORD \
    --capabilities CAPABILITY_IAM \
    --region $AWS_REGION

echo -e "${GREEN}CloudFormation stack deployment started. Waiting for completion...${NC}"

# Wait for the stack to be created/updated
aws cloudformation wait stack-create-complete --stack-name $STACK_NAME --region $AWS_REGION || \
aws cloudformation wait stack-update-complete --stack-name $STACK_NAME --region $AWS_REGION

# 3. Get repository URLs from stack outputs
echo -e "${YELLOW}Getting ECR repository URLs from stack outputs...${NC}"
LMS_REPO=$(aws cloudformation describe-stacks --stack-name $STACK_NAME --query "Stacks[0].Outputs[?OutputKey=='LMSECRRepository'].OutputValue" --output text --region $AWS_REGION)
MIDDLEWARE_REPO=$(aws cloudformation describe-stacks --stack-name $STACK_NAME --query "Stacks[0].Outputs[?OutputKey=='MiddlewareECRRepository'].OutputValue" --output text --region $AWS_REGION)

echo "LMS Repository: $LMS_REPO"
echo "Middleware Repository: $MIDDLEWARE_REPO"

# 4. Login to ECR
echo -e "${YELLOW}Logging in to Amazon ECR...${NC}"
aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin $(echo $LMS_REPO | cut -d/ -f1)

# 5. Build and push Docker images
echo -e "${YELLOW}Building and pushing LMS service Docker image...${NC}"
docker build -t $LMS_REPO:latest ./lms-service
docker push $LMS_REPO:latest

echo -e "${YELLOW}Building and pushing Middleware service Docker image...${NC}"
docker build -t $MIDDLEWARE_REPO:latest ./middleware-service
docker push $MIDDLEWARE_REPO:latest

# 6. Force new deployment of ECS services
echo -e "${YELLOW}Forcing new deployment of ECS services...${NC}"
aws ecs update-service --cluster "${ENVIRONMENT}-lms-cluster" --service "${ENVIRONMENT}-lms-service" --force-new-deployment --region $AWS_REGION
aws ecs update-service --cluster "${ENVIRONMENT}-lms-cluster" --service "${ENVIRONMENT}-middleware-service" --force-new-deployment --region $AWS_REGION

# 7. Get the service URLs
echo -e "${YELLOW}Getting service URLs...${NC}"
LMS_URL=$(aws cloudformation describe-stacks --stack-name $STACK_NAME --query "Stacks[0].Outputs[?OutputKey=='LMSLoadBalancerDNS'].OutputValue" --output text --region $AWS_REGION)
MIDDLEWARE_URL=$(aws cloudformation describe-stacks --stack-name $STACK_NAME --query "Stacks[0].Outputs[?OutputKey=='MiddlewareLoadBalancerDNS'].OutputValue" --output text --region $AWS_REGION)
DB_ENDPOINT=$(aws cloudformation describe-stacks --stack-name $STACK_NAME --query "Stacks[0].Outputs[?OutputKey=='DatabaseEndpoint'].OutputValue" --output text --region $AWS_REGION)

echo -e "${GREEN}Deployment completed successfully!${NC}"
echo -e "${GREEN}LMS Service URL: http://$LMS_URL${NC}"
echo -e "${GREEN}Middleware Service URL: http://$MIDDLEWARE_URL${NC}"
echo -e "${GREEN}Database Endpoint: $DB_ENDPOINT${NC}"
echo -e "${YELLOW}Database Password (save this securely): $DB_PASSWORD${NC}"
echo -e "${YELLOW}To monitor your services, use the AWS ECS console or run:${NC}"
echo "aws ecs describe-services --cluster ${ENVIRONMENT}-lms-cluster --services ${ENVIRONMENT}-lms-service ${ENVIRONMENT}-middleware-service --region $AWS_REGION"