package com.credable.app.middleware_service.service;

import com.credable.app.middleware_service.client.TransactionClient;
import com.credable.app.shared.model.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private final TransactionClient transactionClient;
    public TransactionResponse getTransactions(String customerNumber) {
        // TODO Auto-generated method stub
        // call wsdl transaction client to get transaction data
        // map data and respond.
        // edge-case: we might use topic to reduce calls to the transaction client
       return  transactionClient.getTransactions(customerNumber);
    }

}
