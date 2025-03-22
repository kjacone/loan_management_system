package com.credable.app.shared.exception;

public class ExternalServiceException extends CustomException{
    public ExternalServiceException(String service) {
        super(String.format("Service %s is currently unavailable", service), "SERVICE_UNAVAILABLE");
    }
}
