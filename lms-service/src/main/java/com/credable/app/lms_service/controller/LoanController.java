package com.credable.app.lms_service.controller;

import com.credable.app.lms_service.entity.CustomerEntity;
import com.credable.app.lms_service.model.ServiceResponse;
import com.credable.app.lms_service.model.SubscriptionRequest;
import com.credable.app.lms_service.service.LoanService;
import com.credable.app.lms_service.model.LoanRequest;
import com.credable.app.lms_service.model.LoanResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
@AllArgsConstructor
public class LoanController {

    private final LoanService loanService;



    /**
     * Endpoint to subscribe a customer using their customer number.
     *
     * @param request the subscription request containing the customer number
     * @return a ResponseEntity containing the result of the subscription process
     */
    @PostMapping("/subscription")
    public ResponseEntity<ServiceResponse<CustomerEntity>> subscribeCustomer(@RequestBody SubscriptionRequest request) {
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
     * Endpoint to request a loan.
     * <p>
     * This endpoint will call the Loan Service to process the loan request.
     *
     * @param loanRequest the loan request containing the customer number and loan details
     * @return a ResponseEntity containing the result of the loan request process
     */
    @PostMapping("/request")
    public ResponseEntity<ServiceResponse<LoanResponse>> requestLoan(@RequestBody LoanRequest loanRequest) {
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
     * Endpoint to retrieve the status of a loan.
     *
     * @param loanId the unique identifier of the loan
     * @return a ResponseEntity containing the result of the loan status retrieval process
     */
    @GetMapping("/status")
    public ResponseEntity<ServiceResponse<LoanResponse>> getLoanStatus(@RequestParam String loanId) {
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