package com.credable.app.middleware_service.service;

import com.credable.app.middleware_service.client.TransactionClient;
import com.credable.app.middleware_service.model.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionClient transactionClient;
    /**
     * Retrieves a list of transactions for a given customer number.
     * <p>
     * This method calls the TransactionClient to get the transactions for the given customer number.
     * It then maps the response to a TransactionResponse and returns it.
     * <p>
     * Note: In the future, we might want to use a topic to reduce the number of calls made to the
     * TransactionClient.
     * @param customerNumber the customer number
     * @return a TransactionResponse containing the list of transactions
     */
    public TransactionResponse getTransactions(String customerNumber) {
        return transactionClient.getTransactions(customerNumber);
    }

}
