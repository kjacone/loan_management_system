package com.credable.app.lms_service.service;

import com.credable.app.lms_service.client.CustomerKycClient;
import com.credable.app.lms_service.client.ScoringClient;
import com.credable.app.lms_service.entity.CustomerEntity;
import com.credable.app.lms_service.entity.LoanEntity;
import com.credable.app.lms_service.model.*;
import com.credable.app.lms_service.repository.CustomerRepository;
import com.credable.app.lms_service.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final ScoringClient scoringClient;
    private final CustomerRepository customerRepository;
    private final LoanRepository loanRepository;
    private final CustomerKycClient customerKycClient;

    @Value("${scoring.score-threshold}")
    private int scoreThreshold;

    /**
     * Subscribe a customer to our service using their customer number.
     *
     * @param customerNumber the customer number
     * @return a ServiceResponse containing the result of the subscription process
     */
    public void subscribeCustomer(String customerNumber) {
        // Check if customer exists in DB
        Optional<CustomerEntity> customer = customerRepository.findByCustomerNumber(customerNumber);
        if (customer.isPresent()) {
            // Respond with customer info if exists
            return;
        }

        // Send request to CBS to get customer KYC data
        var customerKyc = customerKycClient.getCustomerKyc(customerNumber).getCustomer();

        // Save data to customer repository
        var new_customer = CustomerEntity.builder()
                .customerNumber(customerNumber)
                .email(customerKyc.getEmail())
                .firstName(customerKyc.getFirstName())
                .lastName(customerKyc.getLastName())
                .nationalId(customerKyc.getIdNumber())
                .phoneNumber(customerKyc.getCustomerNumber())
                // add other fields if needed
                .build();
        var saved_customer = customerRepository.save(new_customer);

    }



    /**
     * Gets the status of a loan.
     *
     * @param loanId the ID of the loan to get the status of
     * @return a LoanResponse containing the status of the loan
     */
    public LoanResponse getLoanStatus(String loanId) {
        // check status of the loan in DB
        Optional<LoanEntity> loan = loanRepository.findById(loanId);
        if (loan.isPresent()) {
            LoanStatus status = loan.get().getStatus();
            return switch (status) {
                case APPROVED ->
                        // if status is approved return success response
                        LoanResponse.builder()
                                .status("success")
                                .message("Your loan has been approved")
                                .loanId(loanId)
                                .loanStatus(status.name())
                                .build();
                case REJECTED ->
                        // if status is rejected return success response
                        LoanResponse.builder()
                                .status("success")
                                .message("Your loan has been rejected")
                                .loanId(loanId)
                                .loanStatus(status.name())
                                .build();
                default ->
                        // if status is ongoing send request to sourcing service to get the status
                        requestScore(loanId);
            };
        }

        // if loan not found return error response
        return LoanResponse.builder()
                .status("error")
                .message("Loan not found")
                .build();
    }


    /**
     * Requests a score from the Scoring service for a given token.
     * If the score is above the threshold, the loan status is set to 'approved' in the database.
     * Otherwise, the loan status is set to 'rejected'.
     * @param token the token to request the score for
     * @return a LoanResponse containing the result of the loan request
     */
    private LoanResponse requestScore(String token) {
        // Get the score from the Scoring service
        var scoreResponse = scoringClient.getScore(token);
        var score = scoreResponse.getScore();
        var loanStatus = score >= scoreThreshold ? LoanStatus.APPROVED : LoanStatus.REJECTED;

        // Update loan status in the database
        loanRepository.findById(token).ifPresent(loan -> loan.setStatus(loanStatus));

        // Return response with updated loan status
        return LoanResponse.builder()
                .status("success")
                .message("Loan request is being processed")
                .loanId(token)
                .loanStatus(loanStatus.name())
                .build();
    }

    /**
     * Process a loan request.
     * <p>
     * This method checks if a loan with status 'ongoing' already exists in the database
     * for the given customer number. If so, it returns without doing anything.
     * Otherwise, it creates a new loan entity with status 'ongoing' in the database
     * and sends a request to the Scoring service to initiate scoring.
     *
     * @param loanRequest the loan request containing the customer number and loan details
     */
    public void requestLoan(LoanRequest loanRequest) {
        // Check if loan with status 'ongoing' already exists in the database
        Optional<LoanEntity> loan = loanRepository.findByCustomerNumberAndStatus(loanRequest.getCustomerNumber(), LoanStatus.ONGOING.name());
        // If so, respond to user "you have an ongoing loan" and return
        if (loan.isPresent()) {
            return;
        }

        // Save loan data to MongoDB with status 'ongoing'
        var loanEntity = LoanEntity.builder()
                .customerNumber(loanRequest.getCustomerNumber())
                .status(LoanStatus.ONGOING)
                .build();
        loanRepository.save(loanEntity);

        // Send scoring request to Scoring service
        scoringClient.initiateScoring(loanRequest.getCustomerNumber());

        // the other loan application logic...
    }
}
