package com.credable.app.lms_service.controller;

import com.credable.app.lms_service.entity.CustomerEntity;
import com.credable.app.lms_service.model.ServiceResponse;
import com.credable.app.lms_service.model.SubscriptionRequest;
import com.credable.app.lms_service.service.LoanService;
import com.credable.app.lms_service.model.LoanRequest;
import com.credable.app.lms_service.model.LoanResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller responsible for handling loan-related operations such as
 * customer subscription, loan requests, and loan status inquiries.
 *
 * This controller exposes endpoints under the "/loan" base path.
 */
@RestController
@AllArgsConstructor
public class LoanController implements LoanControllerInterface{

    private final LoanService loanService;

    /**
     * Endpoint to subscribe a customer using their customer number.
     *
     * This endpoint initiates the subscription process for a customer in the loan management system.
     * The process is asynchronous, and the response only indicates that processing has begun.
     *
     * @param request the subscription request containing the customer number
     * @return a ResponseEntity containing the result of the subscription process
     * @throws IllegalArgumentException if the customer number is invalid or doesn't exist
     * @throws RuntimeException if the subscription process fails
     */
    @Override
    public ResponseEntity<ServiceResponse<CustomerEntity>> subscribeCustomer(
            @Parameter(description = "Subscription request containing the customer's unique identifier",
                    required = true)
            @RequestBody SubscriptionRequest request) {

        String customerNumber = request.getCustomerNumber();

        // Validate if customer number is provided
        if (customerNumber == null) {
            return ResponseEntity.badRequest().body(ServiceResponse.<CustomerEntity>builder()
                    .message("Customer number is required")
                    .status("error")
                    .build());
        }

        try {
            // Attempt to subscribe the customer
            loanService.subscribeCustomer(customerNumber);
            return ResponseEntity.ok(ServiceResponse.<CustomerEntity>builder()
                    .message("Customer subscription is being processed")
                    .status("success").build());
        } catch (Exception e) {
            // Handle any exceptions during subscription
            return ResponseEntity.badRequest().body(ServiceResponse.<CustomerEntity>builder()
                    .message(e.getMessage() != null ? e.getMessage() : "Failed to subscribe customer")
                    .status("error")
                    .build());
        }
    }

    /**
     * Endpoint to submit a loan request.
     *
     * This endpoint processes a new loan application through the loan service.
     * The process is asynchronous, and the response only indicates that processing has begun.
     * Clients should use the getLoanStatus endpoint to check the status of their loan request.
     *
     * @param loanRequest the loan request containing customer identification and loan details
     *                   (amount, term, purpose, etc.)
     * @return a ResponseEntity containing the result of the loan request submission
     * @throws IllegalArgumentException if the loan request contains invalid data
     * @throws RuntimeException if the loan request processing fails
     */
    @Override
    public ResponseEntity<ServiceResponse<LoanResponse>> requestLoan(
            @Parameter(description = "Loan application details including customer ID, loan amount, term, etc.",
                    required = true)
            @RequestBody LoanRequest loanRequest) {
        try {
            // Call the Loan Service to process the loan request
            loanService.requestLoan(loanRequest);
            // Return a success response with a message
            return ResponseEntity.ok(ServiceResponse.<LoanResponse>builder()
                    .message("Loan request is being processed")
                    .status("success")
                    .build());
        } catch (Exception e) {
            // Handle any exceptions during the loan request process
            return ResponseEntity.badRequest().body(ServiceResponse.<LoanResponse>builder()
                    .status("error")
                    .message(e.getMessage() != null ? e.getMessage() : "Failed to process loan request")
                    .build());
        }
    }

    /**
     * Endpoint to retrieve the current status of a submitted loan application.
     *
     * This endpoint allows clients to check the progress of a previously submitted loan request
     * by providing the unique loan identifier.
     *
     * @param loanId the unique identifier of the loan application to query
     * @return a ResponseEntity containing the loan status information including current state,
     *         approval status, disbursement details, etc.
     * @throws IllegalArgumentException if the loan ID is invalid or doesn't exist
     * @throws RuntimeException if the status retrieval process fails
     */
    @Override
    public ResponseEntity<ServiceResponse<LoanResponse>> getLoanStatus(
            @Parameter(description = "Unique identifier of the loan application to query",
                    required = true)
            @RequestParam String loanId) {
        try {
            // Call the Loan Service to retrieve the status of the loan
            LoanResponse status = loanService.getLoanStatus(loanId);
            // Return a success response with a message
            return ResponseEntity.ok(ServiceResponse.<LoanResponse>builder()
                    .message("Loan status retrieved successfully")
                    .status("success")
                    .data(status)
                    .build());
        } catch (Exception e) {
            // Handle any exceptions during the loan status retrieval process
            return ResponseEntity.badRequest().body(ServiceResponse.<LoanResponse>builder()
                    .status("error")
                    .message(e.getMessage() != null ? e.getMessage() : "Failed to retrieve loan status")
                    .build());
        }
    }
}