package com.credable.app.shared.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final Pattern EMAIL_PATTERN = Pattern
            .compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{10,15}$");

    private ValidationUtil() {
        // Private constructor to prevent instantiation
    }

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && PHONE_PATTERN.matcher(phoneNumber).matches();
    }

    public static void validateCustomerNumber(String customerNumber) {
        if (customerNumber == null || customerNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer number cannot be empty");
        }

        if (!customerNumber.matches("^[0-9]{10}$")) {
            throw new IllegalArgumentException("Customer number must be a 10-digit number");
        }
    }
}