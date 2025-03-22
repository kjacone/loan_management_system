package com.credable.app.middleware_service.controller;

import com.credable.app.middleware_service.model.TransactionRequest;
import com.credable.app.middleware_service.model.TransactionResponse;
import com.credable.app.middleware_service.service.TransactionService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling transaction-related operations.
 * Implements the TransactionApi interface which contains Swagger documentation.
 */
@RestController
@AllArgsConstructor
public class TransactionController implements TransactionsControllerInterface {

    private final TransactionService transactionService;

    /**
     * Get the transactions for a given customer number.
     * @param request the request containing the customer number
     * @return a ResponseEntity containing the list of transactions
     */
    @Override
    public ResponseEntity<TransactionResponse> getTransactions(TransactionRequest request) {
        String customerNumber = request.getCustomerNumber();

        // Validate if customer number is provided
        if (customerNumber == null) {
            return ResponseEntity.badRequest()
                    .body(TransactionResponse.builder()
                            .status("error")
                            .message("Customer number is required")
                            .build());
        }

        try {
            // Call the Transaction Service to retrieve the transactions
            var transactions = transactionService.getTransactions(customerNumber);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            // Return a bad request response with a message
            return ResponseEntity.badRequest()
                    .body(TransactionResponse.builder()
                            .status("error")
                            .message(e.getMessage() != null ? e.getMessage() : "Failed to retrieve transactions")
                            .build());
        }
    }
}