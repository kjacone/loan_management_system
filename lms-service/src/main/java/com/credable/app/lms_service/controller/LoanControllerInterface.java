package com.credable.app.lms_service.controller;

import com.credable.app.lms_service.entity.CustomerEntity;
import com.credable.app.lms_service.model.LoanRequest;
import com.credable.app.lms_service.model.LoanResponse;
import com.credable.app.lms_service.model.ServiceResponse;
import com.credable.app.lms_service.model.SubscriptionRequest;
import com.credable.app.lms_service.controller.SwaggerExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("/loan")
@Tag(name = "Loan Management", description = "APIs for loan application processing and customer subscription")
public interface LoanControllerInterface {
    @PostMapping("/subscription")
    @Operation(
            summary = "Subscribe a customer to the loan service",
            description = "Initiates the subscription process for a customer using their unique customer number. " +
                    "This is an asynchronous operation that returns immediately with a confirmation."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Customer subscription process initiated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "successful_subscription",
                                            summary = "Successful customer subscription",
                                            description = "Example of a successful customer subscription response",
                                            value = SwaggerExamples.SubscriptionExamples.SUCCESSFUL_SUBSCRIPTION
                                    )
                            })
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request - Customer number is missing or invalid",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "missing_customer_number",
                                            summary = "Missing customer number",
                                            description = "Example response when customer number is missing",
                                            value = SwaggerExamples.SubscriptionExamples.MISSING_CUSTOMER_NUMBER
                                    ),
                                    @ExampleObject(
                                            name = "invalid_customer_format",
                                            summary = "Invalid customer format",
                                            description = "Example response when customer number format is invalid",
                                            value = SwaggerExamples.SubscriptionExamples.INVALID_CUSTOMER_FORMAT
                                    )
                            })
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error during subscription process",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "core_service_unavailable",
                                            summary = "Core service unavailable",
                                            description = "Example response when core banking service is unavailable",
                                            value = SwaggerExamples.SubscriptionExamples.CORE_SERVICE_UNAVAILABLE
                                    ),
                                    @ExampleObject(
                                            name = "database_connection_failure",
                                            summary = "Database connection failure",
                                            description = "Example response when database connection fails",
                                            value = SwaggerExamples.SubscriptionExamples.DATABASE_CONNECTION_FAILURE
                                    )
                            })
            )
    })
    ResponseEntity<ServiceResponse<CustomerEntity>> subscribeCustomer(
            @Parameter(description = "Subscription request containing the customer's unique identifier",
                    required = true)
            @RequestBody SubscriptionRequest request);









    @PostMapping("/request")
    @Operation(
            summary = "Submit a new loan application",
            description = "Processes a new loan application with the specified details. " +
                    "This is an asynchronous operation. Use the status endpoint to check the progress of the application."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Loan application successfully submitted for processing",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "successful_loan_request",
                                            summary = "Successful loan request",
                                            description = "Example of a successful loan request response",
                                            value = SwaggerExamples.LoanExamples.SUCCESSFUL_LOAN_REQUEST
                                    )
                            })
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid loan request - Missing required fields or invalid data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "missing_loan_amount",
                                            summary = "Missing loan amount",
                                            description = "Example response when loan amount is missing",
                                            value = SwaggerExamples.LoanExamples.MISSING_LOAN_AMOUNT
                                    ),
                                    @ExampleObject(
                                            name = "invalid_loan_term",
                                            summary = "Invalid loan term",
                                            description = "Example response when loan term is invalid",
                                            value = SwaggerExamples.LoanExamples.INVALID_LOAN_TERM
                                    )
                            })
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error during loan request processing",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "core_service_unavailable",
                                            summary = "Core service unavailable",
                                            description = "Example response when core banking service is unavailable",
                                            value = SwaggerExamples.LoanExamples.CORE_SERVICE_UNAVAILABLE
                                    ),
                                    @ExampleObject(
                                            name = "credit_check_timeout",
                                            summary = "Credit check timeout",
                                            description = "Example response when credit check service times out",
                                            value = SwaggerExamples.LoanExamples.CREDIT_CHECK_TIMEOUT
                                    )
                            })
            )
    })
    ResponseEntity<ServiceResponse<LoanResponse>> requestLoan(
            @Parameter(description = "Loan application details including customer ID, loan amount, term, etc.",
                    required = true)
            @RequestBody LoanRequest loanRequest);










    @GetMapping("/status")
    @Operation(
            summary = "Retrieve the status of a loan application",
            description = "Gets the current status and details of a previously submitted loan application " +
                    "using its unique identifier."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Loan status successfully retrieved",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "approved_loan_status",
                                            summary = "Approved loan status",
                                            description = "Example of an approved loan status response",
                                            value = SwaggerExamples.LoanStatusExamples.APPROVED_LOAN
                                    ),
                                    @ExampleObject(
                                            name = "pending_loan_status",
                                            summary = "Pending loan status",
                                            description = "Example of a pending loan status response",
                                            value = SwaggerExamples.LoanStatusExamples.PENDING_LOAN
                                    ),
                                    @ExampleObject(
                                            name = "rejected_loan_status",
                                            summary = "Rejected loan status",
                                            description = "Example of a rejected loan status response",
                                            value = SwaggerExamples.LoanStatusExamples.REJECTED_LOAN
                                    )
                            })
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid loan ID or loan not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "loan_not_found",
                                            summary = "Loan not found",
                                            description = "Example response when loan ID doesn't exist",
                                            value = SwaggerExamples.LoanStatusExamples.LOAN_NOT_FOUND
                                    ),
                                    @ExampleObject(
                                            name = "invalid_loan_id_format",
                                            summary = "Invalid loan ID format",
                                            description = "Example response when loan ID format is invalid",
                                            value = SwaggerExamples.LoanStatusExamples.INVALID_LOAN_ID
                                    )
                            })
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error during status retrieval",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ServiceResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "database_connection_failure",
                                            summary = "Database connection failure",
                                            description = "Example response when database connection fails",
                                            value = SwaggerExamples.LoanStatusExamples.DATABASE_CONNECTION_FAILURE
                                    ),
                                    @ExampleObject(
                                            name = "request_timeout",
                                            summary = "Request timeout",
                                            description = "Example response when request processing times out",
                                            value = SwaggerExamples.LoanStatusExamples.REQUEST_TIMEOUT
                                    )
                            })
            )
    })
    ResponseEntity<ServiceResponse<LoanResponse>> getLoanStatus(
            @Parameter(description = "Unique identifier of the loan application to query",
                    required = true)
            @RequestParam String loanId);
}