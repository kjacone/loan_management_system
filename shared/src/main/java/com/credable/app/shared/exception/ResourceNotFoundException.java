package com.credable.app.shared.exception;

public class ResourceNotFoundException extends CustomException {
    public ResourceNotFoundException(String resource, String identifier) {
        super(String.format("%s not found with identifier: %s", resource, identifier), "RESOURCE_NOT_FOUND");
    }
}