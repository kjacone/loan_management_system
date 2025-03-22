package com.credable.app.lms_service.service;

import com.credable.app.lms_service.client.ScoringClient;
import com.credable.app.shared.model.LoanRequest;
import com.credable.app.shared.model.LoanResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanService {
    private final ScoringClient scoringClient;

    public void subscribeCustomer(String customerNumber) {
        // TODO: implement subscription logic
        // check if customer exist in DB if so respond with customerInfo
        // if not add data to customer_requests
        // send request to CBS to get customer kyc data
        // compare both dataset based on a score
        // if score meets the threshold save data to customers
    }

    public Object getLoanStatus(String customerNumber, String loanId) {
        // TODO: implement loan status retrieval logic
        // check status of the loan in DB
        // if status is ongoing send request to sourcing service to get the status
        // update DB
        return null;
    }

    public LoanResponse requestLoan(LoanRequest loanRequest) {
        // TODO: implement loan request logic
        // check if loan exists with status ongoing
        // if so break respond to user "you have an ongoing loan"
        // save loan data to mongo db with status ongoing
        // send scoring request to Scoring service
        // respond to user "your loan is being processed"



      var response =  scoringClient.initiateScoring(loanRequest.getCustomerNumber());
      return LoanResponse.builder().build();
    }
}
