package com.family.families.exceptions;

public class InvalidCountryException extends RuntimeException {
    public InvalidCountryException(String countryCode) {
        super(String.format("Country code '{}, does not exist'!", countryCode));
    }
}
