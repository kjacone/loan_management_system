package com.credable.app.lms_service.controller;

import com.credable.app.lms_service.service.LoanService;
import com.credable.app.shared.exception.BadRequestException;
import com.credable.app.shared.model.LoanRequest;
import com.credable.app.shared.model.LoanResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

@RestController
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/subscription")
    public ResponseEntity<LoanResponse> subscribeCustomer(@RequestBody Map<String, String> request) {
        String customerNumber = request.get("customerNumber");
        if (customerNumber == null) {
            return ResponseEntity.badRequest().body(LoanResponse.builder().message("Customer number is required").status("error").build());
        }

        try {
            loanService.subscribeCustomer(customerNumber);
            return ResponseEntity.ok(LoanResponse.builder().status("success").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(LoanResponse.builder().message(e.getMessage() != null ? e.getMessage() : "Failed to subscribe customer").status("error").build());
        }
    }

    @PostMapping("/request")
    public ResponseEntity<LoanResponse> requestLoan(@RequestBody LoanRequest loanRequest) {
        try {
            LoanResponse result = loanService.requestLoan(loanRequest);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(LoanResponse.builder().message(e.getMessage() != null ? e.getMessage() : "Failed to process loan request").status("error").build());
        }
    }

    @GetMapping("/status")
    public ResponseEntity<?> getLoanStatus(@RequestParam String customerNumber, @RequestParam String loanId) {
        try {
            Object status = loanService.getLoanStatus(customerNumber, loanId);
            return ResponseEntity.ok(status);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BadRequestException(
                    e.getMessage() != null ? e.getMessage() : "Failed to retrieve loan status"));
        }
    }
}