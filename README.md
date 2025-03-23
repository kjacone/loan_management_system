# Loan Management System - Monorepo

A microservice-based solution for loan management with Docker support. This monorepo contains two Spring Boot microservices built with Java and Gradle (Kotlin DSL):

1. **LMS Service** - Core loan management service
2. **Middleware Service** - Interface for transaction data

## Project Structure

```
loan-management-system/
├── .github/                      # New directory for cicd code
│   └── workflows/                             # github workflows
│       ├── cicd.yaml  
├── build.gradle.kts
├── settings.gradle.kts
├── gradle/
├── docker/
├── buildspec.yml                        # For AWS CodeBuild
├── infrastructure/                      # New directory for infrastructure code
│   └── aws/                             # AWS-specific infrastructure
│       ├── main.yaml          # CloudFormation template
│       └── deploy.sh                    # Deployment script
├── lms-service/
│   ├── src/
│   ├── build.gradle.kts
│   └── Dockerfile
├── middleware-service/
│   ├── src/
│   ├── build.gradle.kts
│   └── Dockerfile
└── shared/
    ├── src/
    └── build.gradle.kts
```

## Technology Stack

- **Language**: Java
- **Build Tool**: Gradle (Kotlin DSL)
- **Framework**: Spring Boot 3.1.5
- **Database**: MongoDB
- **Containerization**: Docker
- **API Integration**: REST and SOAP clients
- **Resilience**: Resilience4j for retries

## Getting Started

### Prerequisites

- JDK 17 or later
- Gradle 7.5 or later
- Docker and Docker Compose
- MongoDB (for local development)

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/kjacone/loan_management_system
   cd loan-management-system
   ```

2. **Build the project**
   ```bash
   ./gradlew build
   ```

3. **Run individual services locally**
   ```bash
   # Run LMS service
   ./gradlew :lms-service:bootRun

   # Run Middleware service
   ./gradlew :middleware-service:bootRun
   ```

4. **Run with Docker Compose**
   ```bash
   cd docker
   docker-compose up -d
   ```

## Services

### LMS Service (port 8080)

Manages loan operations including:
- Customer subscription
- Loan requests
- Loan status tracking

#### API Endpoints

- **POST /loan/subscription** - Subscribe a customer for loan eligibility
- **POST /loan/request** - Submit a loan request
- **GET /loan/status** - Check loan application status

### Middleware Service (port 8081)

Handles transaction data processing and exposes APIs to the Scoring Engine.

#### API Endpoints

- **POST /middleware/transactions** - Retrieve customer transaction data




## Docker Support

The project includes Dockerfiles for both services and a docker-compose file to run the entire system. The Docker setup includes:

- MongoDB container
- LMS Service container
- Middleware Service container
- Shared network for inter-service communication

## Development Workflow

1. Make changes to the codebase
2. Run tests: `./gradlew test`
3. Build the project: `./gradlew build`
4. Build and run Docker containers: `docker-compose up --build`

## External Service Integration

This system integrates with several external services:

1. **KYC API** - For customer verification
2. **Scoring Engine** - For loan eligibility scoring
3. **Transaction API** - For retrieving customer transaction data

## Deployment

The Loan Management System uses GitHub Actions for continuous integration and deployment to AWS. The system automatically builds, tests, and deploys services when changes are pushed to the repository.

### CI/CD Pipeline

Our CI/CD pipeline includes the following stages:

1. **Test**: Runs all tests to ensure code quality
2. **Build**: Builds the services and Docker images
3. **Infrastructure**: Deploys or updates AWS infrastructure using CloudFormation
4. **Services**: Updates ECS services with new container images
5. **Notification**: Reports deployment status

### Prerequisites

Before deploying, you need to set up the following:

1. **AWS Credentials**: Add these secrets to your GitHub repository:
   - `AWS_ACCESS_KEY_ID`: Your AWS access key
   - `AWS_SECRET_ACCESS_KEY`: Your AWS secret key

2. **Optional - Slack Notifications**: To enable Slack notifications, add:
   - `SLACK_WEBHOOK_URL`: Your Slack webhook URL

### Environments

The system supports three environments:
- `dev`: Automatically deployed when pushing to any branch except `main`
- `staging`: Can be deployed manually via workflow dispatch
- `prod`: Automatically deployed when pushing to the `main` branch

### Manual Deployment

You can manually trigger a deployment to any environment:

1. Go to the "Actions" tab in your GitHub repository
2. Select the "Loan Management System CI/CD" workflow
3. Click "Run workflow"
4. Choose the branch and environment
5. Click "Run workflow"
### Infrastructure

The deployment creates the following AWS resources:

- ECS Fargate cluster for containerized services
- ECR repositories for Docker images
- Amazon Bedrock database
- Application Load Balancers
- Security groups and IAM roles
- CloudWatch logs for monitoring

### Monitoring

Monitor your deployments:

1. In GitHub: Check the "Actions" tab for workflow runs
2. In AWS Console:
   - ECS console for container status
   - CloudWatch for logs and metrics
   - Amazon Bedrock console for database monitoring

### Troubleshooting

Common issues:

1. **Failed Tests**: Check the test logs in the GitHub Actions run
2. **Deployment Failure**: Verify AWS credentials and permissions
3. **Service Unavailable**: Check ECS service status and logs

For additional help, refer to AWS documentation or contact the development team.

## Contributing

1. Create a feature branch (`git checkout -b feature/new-feature`)
2. Commit your changes (`git commit -m 'Add some new feature'`)
3. Push to the branch (`git push origin feature/new-feature`)
4. Open a Pull Request
