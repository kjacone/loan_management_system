package com.credable.app.lms_service.client;


import com.credable.app.lms_service.generated.CustomerRequest;
import com.credable.app.lms_service.generated.CustomerResponse;
import com.credable.app.shared.exception.ExternalServiceException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerKycClient {
    @Autowired
    private final WebServiceTemplate kycWebServiceTemplate;

    /**
     * Gets the customer KYC data from the KYC service.
     * @param customerNumber the customer number
     * @return the customer KYC data
     * @throws ExternalServiceException if there is an error calling the KYC service
     */
    public CustomerResponse getCustomerKyc(String customerNumber) {
        try {
            CustomerRequest request = new CustomerRequest();
            request.setCustomerNumber(customerNumber);

            CustomerResponse response = (CustomerResponse) kycWebServiceTemplate
                    .marshalSendAndReceive(request);

            if (response == null || response.getCustomer() == null) {
                throw new ExternalServiceException("No customer returned from KYC service");
            }

            // Return the response
            return response;

        } catch (Exception e) {
            log.error("Error calling KYC service", e);
            throw new ExternalServiceException("Error calling KYC service: " + e.getMessage());
        }
    }
}
