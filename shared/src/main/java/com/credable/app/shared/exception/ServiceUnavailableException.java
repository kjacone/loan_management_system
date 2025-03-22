package com.credable.app.shared.exception;

public class ServiceUnavailableException extends CustomException {
    public ServiceUnavailableException(String service) {
        super(String.format("Service %s is currently unavailable", service), "SERVICE_UNAVAILABLE");
    }
}
