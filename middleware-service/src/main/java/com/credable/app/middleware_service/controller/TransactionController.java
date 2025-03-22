package com.credable.app.middleware_service.controller;

import com.credable.app.middleware_service.model.TransactionRequest;
import com.credable.app.middleware_service.model.TransactionResponse;
import com.credable.app.middleware_service.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/middleware")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions")
    public ResponseEntity<TransactionResponse> getTransactions(@RequestBody TransactionRequest request) {
        String customerNumber = request.getCustomerNumber();
        if (customerNumber == null) {
            return ResponseEntity.badRequest()
                    .body(TransactionResponse.builder().status("error").message("Customer number is required").build());

        }

        try {
            var transactions = transactionService.getTransactions(customerNumber);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(TransactionResponse.builder().status("error").message(e.getMessage() != null ? e.getMessage() : "Failed to retrieve transactions").build());

        }
    }
}