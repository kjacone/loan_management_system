package com.credable.app.lms_service.controller;


public class SwaggerExamples {

    public static class SubscriptionExamples {
        public static final String SUCCESSFUL_SUBSCRIPTION =
                "{\n" +
                        "  \"status\": \"SUCCESS\",\n" +
                        "  \"message\": \"Customer subscription initiated successfully\",\n" +
                        "  \"data\": {\n" +
                        "    \"customerId\": \"CUST123456\",\n" +
                        "    \"name\": \"John Doe\",\n" +
                        "    \"status\": \"ACTIVE\",\n" +
                        "    \"subscriptionDate\": \"2025-03-23T10:15:30Z\"\n" +
                        "  }\n" +
                        "}";

        public static final String MISSING_CUSTOMER_NUMBER =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Customer number is required\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"MISSING_CUSTOMER_NUMBER\"\n" +
                        "}";

        public static final String INVALID_CUSTOMER_FORMAT =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Invalid customer number format\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"INVALID_CUSTOMER_FORMAT\"\n" +
                        "}";

        public static final String CORE_SERVICE_UNAVAILABLE =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Unable to process subscription. Core banking service is unavailable\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"CORE_SERVICE_UNAVAILABLE\"\n" +
                        "}";

        public static final String DATABASE_CONNECTION_FAILURE =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Unable to store subscription. Database connection failed\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"DATABASE_CONNECTION_FAILURE\"\n" +
                        "}";
    }

    public static class LoanExamples {
        public static final String SUCCESSFUL_LOAN_REQUEST =
                "{\n" +
                        "  \"status\": \"SUCCESS\",\n" +
                        "  \"message\": \"Loan application submitted successfully\",\n" +
                        "  \"data\": {\n" +
                        "    \"loanId\": \"LOAN78901234\",\n" +
                        "    \"customerId\": \"CUST123456\",\n" +
                        "    \"amount\": 5000.00,\n" +
                        "    \"term\": 12,\n" +
                        "    \"status\": \"PENDING\",\n" +
                        "    \"applicationDate\": \"2025-03-23T14:30:45Z\"\n" +
                        "  }\n" +
                        "}";

        public static final String MISSING_LOAN_AMOUNT =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Loan amount is required\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"MISSING_LOAN_AMOUNT\"\n" +
                        "}";

        public static final String INVALID_LOAN_TERM =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Invalid loan term. Term must be between 3 and 60 months\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"INVALID_LOAN_TERM\"\n" +
                        "}";

        public static final String CORE_SERVICE_UNAVAILABLE =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Unable to process loan request. Core banking service is unavailable\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"CORE_SERVICE_UNAVAILABLE\"\n" +
                        "}";

        public static final String CREDIT_CHECK_TIMEOUT =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Unable to process loan request. Credit check service timed out\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"CREDIT_CHECK_TIMEOUT\"\n" +
                        "}";
    }

    public static class LoanStatusExamples {
        public static final String APPROVED_LOAN =
                "{\n" +
                        "  \"status\": \"SUCCESS\",\n" +
                        "  \"message\": \"Loan status retrieved successfully\",\n" +
                        "  \"data\": {\n" +
                        "    \"loanId\": \"LOAN78901234\",\n" +
                        "    \"customerId\": \"CUST123456\",\n" +
                        "    \"amount\": 5000.00,\n" +
                        "    \"term\": 12,\n" +
                        "    \"interestRate\": 12.5,\n" +
                        "    \"monthlyPayment\": 445.67,\n" +
                        "    \"status\": \"APPROVED\",\n" +
                        "    \"approvalDate\": \"2025-03-24T09:15:30Z\",\n" +
                        "    \"disbursementDate\": \"2025-03-25T14:30:00Z\"\n" +
                        "  }\n" +
                        "}";

        public static final String PENDING_LOAN =
                "{\n" +
                        "  \"status\": \"SUCCESS\",\n" +
                        "  \"message\": \"Loan status retrieved successfully\",\n" +
                        "  \"data\": {\n" +
                        "    \"loanId\": \"LOAN78901234\",\n" +
                        "    \"customerId\": \"CUST123456\",\n" +
                        "    \"amount\": 5000.00,\n" +
                        "    \"term\": 12,\n" +
                        "    \"status\": \"PENDING\",\n" +
                        "    \"applicationDate\": \"2025-03-23T14:30:45Z\",\n" +
                        "    \"expectedCompletionDate\": \"2025-03-25T14:30:45Z\"\n" +
                        "  }\n" +
                        "}";

        public static final String REJECTED_LOAN =
                "{\n" +
                        "  \"status\": \"SUCCESS\",\n" +
                        "  \"message\": \"Loan status retrieved successfully\",\n" +
                        "  \"data\": {\n" +
                        "    \"loanId\": \"LOAN78901234\",\n" +
                        "    \"customerId\": \"CUST123456\",\n" +
                        "    \"amount\": 5000.00,\n" +
                        "    \"term\": 12,\n" +
                        "    \"status\": \"REJECTED\",\n" +
                        "    \"applicationDate\": \"2025-03-23T14:30:45Z\",\n" +
                        "    \"rejectionDate\": \"2025-03-24T10:15:30Z\",\n" +
                        "    \"rejectionReason\": \"Insufficient credit score\"\n" +
                        "  }\n" +
                        "}";

        public static final String LOAN_NOT_FOUND =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Loan with ID 'LOAN12345678' not found\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"LOAN_NOT_FOUND\"\n" +
                        "}";

        public static final String INVALID_LOAN_ID =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Invalid loan ID format\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"INVALID_LOAN_ID_FORMAT\"\n" +
                        "}";

        public static final String DATABASE_CONNECTION_FAILURE =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Unable to retrieve loan status. Database connection failed\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"DATABASE_CONNECTION_FAILURE\"\n" +
                        "}";

        public static final String REQUEST_TIMEOUT =
                "{\n" +
                        "  \"status\": \"ERROR\",\n" +
                        "  \"message\": \"Request to retrieve loan status timed out\",\n" +
                        "  \"data\": null,\n" +
                        "  \"errorCode\": \"REQUEST_TIMEOUT\"\n" +
                        "}";
    }
}