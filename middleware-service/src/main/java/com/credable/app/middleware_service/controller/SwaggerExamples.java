package com.credable.app.middleware_service.config;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Centralized storage for all Swagger documentation examples.
 * Uses HashMap to organize examples by endpoint and response type.
 */
public class SwaggerExamples {

    /**
     * Transaction API example responses
     */
    public static class TransactionExamples {

        public static final String SUCCESSFUL_RETRIEVAL = """
                        {
                            "status": "success",
                            "message": "Transaction data successfully retrieved",
                            "customerNumber": "123456789",
                            "transactions": [
                                {
                                    "id": "tx789012",
                                    "date": "2025-03-20T14:30:45Z",
                                    "amount": 1250.00,
                                    "type": "DEPOSIT",
                                    "description": "Salary payment",
                                    "accountNumber": "SA7654321"
                                },
                                {
                                    "id": "tx789013",
                                    "date": "2025-03-18T09:15:22Z",
                                    "amount": -450.75,
                                    "type": "WITHDRAWAL",
                                    "description": "ATM withdrawal",
                                    "accountNumber": "SA7654321"
                                },
                                {
                                    "id": "tx789014",
                                    "date": "2025-03-15T12:05:33Z",
                                    "amount": -89.99,
                                    "type": "PAYMENT",
                                    "description": "Online purchase",
                                    "accountNumber": "SA7654321"
                                }
                            ]
                        }
                    """;


        public static final String EMPTY_TRANSACTIONS =  """
                        {
                            "status": "success",
                            "message": "Transaction data successfully retrieved",
                            "customerNumber": "123456789",
                            "transactions": []
                        }
                    """;

        public static final String MISSING_CUSTOMER_NUMBER = """
                        {
                            "status": "error",
                            "message": "Customer number is required",
                            "customerNumber": null,
                            "transactions": null
                        }
                    """;
        public static final String INVALID_CUSTOMER_NUMBER_FORMAT = """
                        {
                            "status": "error",
                            "message": "Invalid customer number format",
                            "customerNumber": "ABC123",
                            "transactions": null
                        }
                    """;

        public static final String CUSTOMER_NOT_FOUND = """
                        {
                            "status": "error",
                            "message": "Customer not found",
                            "customerNumber": "999999999",
                            "transactions": null
                        }
                    """;
        public  static final String CORE_SERVICE_UNAVAILABLE = """
                        {
                            "status": "error",
                            "message": "Failed to retrieve transactions - Core service unavailable",
                            "customerNumber": "123456789",
                            "transactions": null
                        }
                    """;
        public static final String DATABASE_CONNECTION_FAILURE =  """
                        {
                            "status": "error",
                            "message": "Internal server error - Database connection failure",
                            "customerNumber": "123456789",
                            "transactions": null
                        }
                    """;
        public static final String REQUEST_TIMEOUT = """
                        {
                            "status": "error",
                            "message": "Timeout occurred while processing request",
                            "customerNumber": "123456789",
                            "transactions": null
                        }
                    """;



    }
}