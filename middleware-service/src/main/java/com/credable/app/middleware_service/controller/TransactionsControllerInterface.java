package com.credable.app.middleware_service.controller;



import com.credable.app.middleware_service.config.SwaggerExamples;
import com.credable.app.middleware_service.model.TransactionRequest;
import com.credable.app.middleware_service.model.TransactionResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping("/middleware")
@Tag(
        name = "Customer Transactions",
        description = "APIs for retrieving customer transaction data from core service"
)
public interface TransactionsControllerInterface {

    @PostMapping("/transactions")
    @Operation(
            summary = "Retrieve customer transactions",
            description = "Fetches transaction history for a customer based on their unique customer number. " +
                    "Returns transaction details, including dates, amounts, and transaction types."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Transaction data successfully retrieved",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TransactionResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "successful_retrieval",
                                            summary = "Successful transaction data retrieval",
                                            description = "Example of successful transaction data retrieval with multiple transactions",
                                            value = SwaggerExamples.TransactionExamples.SUCCESSFUL_RETRIEVAL
                                    ),
                                    @ExampleObject(
                                            name = "empty_transactions",
                                            summary = "No transactions found",
                                            description = "Example of successful response when no transactions are found",
                                            value = SwaggerExamples.TransactionExamples.EMPTY_TRANSACTIONS
                                    )
                            }

                               )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request - Customer number is missing or invalid",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TransactionResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "missing_customer_number",
                                            summary = "Missing customer number",
                                            description = "Example response when customer number is missing from request",
                                            value = SwaggerExamples.TransactionExamples.MISSING_CUSTOMER_NUMBER
                                    ),
                                    @ExampleObject(
                                            name = "invalid_customer_format",
                                            summary = "Invalid customer number format",
                                            description = "Example response when customer number format is invalid",
                                            value = SwaggerExamples.TransactionExamples.INVALID_CUSTOMER_NUMBER_FORMAT
                                    ),
                                    @ExampleObject(
                                            name = "customer_not_found",
                                            summary = "Customer not found",
                                            description = "Example response when customer does not exist in the system",
                                            value = SwaggerExamples.TransactionExamples.CUSTOMER_NOT_FOUND
                                    )
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error while retrieving transaction data",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TransactionResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "core_service_unavailable",
                                            summary = "Core service unavailable",
                                            description = "Example response when core banking service is unavailable",
                                            value = SwaggerExamples.TransactionExamples.CORE_SERVICE_UNAVAILABLE
                                    ),
                                    @ExampleObject(
                                            name = "database_connection_failure",
                                            summary = "Database connection failure",
                                            description = "Example response when database connection fails",
                                            value = SwaggerExamples.TransactionExamples.DATABASE_CONNECTION_FAILURE
                                    ),
                                    @ExampleObject(
                                            name = "request_timeout",
                                            summary = "Request timeout",
                                            description = "Example response when request processing times out",
                                            value = SwaggerExamples.TransactionExamples.REQUEST_TIMEOUT
                                    )
                            }
                    )
            )
    })
    ResponseEntity<TransactionResponse> getTransactions(
            @Parameter(
                    description = "Request containing the customer's unique identifier",
                    required = true
            )
            @RequestBody TransactionRequest request
    );

}

