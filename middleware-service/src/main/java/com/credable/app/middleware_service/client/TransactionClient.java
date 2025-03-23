package com.credable.app.middleware_service.client;


import com.credable.app.middleware_service.generated.TransactionData;
import com.credable.app.middleware_service.generated.TransactionsRequest;
import com.credable.app.middleware_service.generated.TransactionsResponse;
import com.credable.app.middleware_service.model.Transaction;
import com.credable.app.middleware_service.model.TransactionResponse;
import com.credable.app.shared.exception.ExternalServiceException;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionClient {

    private final WebServiceTemplate transactionWebServiceTemplate;

    /**
     * Get the transactions for a given customer number
     * @param customerNumber the customer number
     * @return a TransactionResponse containing the list of transactions
     * @throws ExternalServiceException if there is an error calling the Transaction service
     */
    public TransactionResponse getTransactions(String customerNumber) {
        try {
            // Create the request
            TransactionsRequest request = new TransactionsRequest();
            request.setCustomerNumber(customerNumber);

            // Send the request to the Transaction service and get the response
            TransactionsResponse response = (TransactionsResponse) transactionWebServiceTemplate
                    .marshalSendAndReceive(request);

            // Check if the response is valid
            if (response == null || response.getTransactions() == null) {
                throw new ExternalServiceException("No transactions returned from Transaction service");
            }

            // Convert the TransactionData to Transaction
            var transactions = response.getTransactions().stream()
                    .map(this::convertToTransaction)
                    .collect(Collectors.toList());

            // Build the response
            return TransactionResponse.builder()
                    .transactions(transactions)
                    .status("success")
                    .message("You request was successful")
                    .build();

        } catch (Exception e) {
            // Log the error and throw a custom exception
            log.error("Error calling Transaction service", e);
            throw new ExternalServiceException("Error calling Transaction service: " + e.getMessage());
        }
    }

    /**
     * Converts TransactionData to Transaction using direct property mapping
     * since the fields have matching names
     */
    private Transaction convertToTransaction(TransactionData data) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(data, transaction);
        return transaction;
    }
}