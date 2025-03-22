package com.credable.app.middleware_service.client;

import com.credable.app.shared.exception.ExternalServiceException;
import com.credable.app.shared.generated.transactions.TransactionData;
import com.credable.app.shared.generated.transactions.TransactionsRequest;
import com.credable.app.shared.generated.transactions.TransactionsResponse;
import com.credable.app.shared.model.Transaction;


import com.credable.app.shared.model.TransactionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionClient {

    private final WebServiceTemplate transactionWebServiceTemplate;

    public TransactionResponse getTransactions(String customerNumber) {
        try {
            TransactionsRequest request = new TransactionsRequest();
            request.setCustomerNumber(customerNumber);

            TransactionsResponse response = (TransactionsResponse) transactionWebServiceTemplate
                    .marshalSendAndReceive(request);

            if (response == null || response.getTransactions() == null) {
                throw new ExternalServiceException("No transactions returned from Transaction service");
            }

            var trs_list = response.getTransactions().stream()
                    .map(this::convertToTransaction)
                    .collect(Collectors.toList());

         return TransactionResponse.builder().transactions(trs_list).status("success").message("you request was successful").build();

        } catch (Exception e) {
            log.error("Error calling Transaction service", e);
            throw new ExternalServiceException("Error calling Transaction service: " + e.getMessage());
        }
//        return null;
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