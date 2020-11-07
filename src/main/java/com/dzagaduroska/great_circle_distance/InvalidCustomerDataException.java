package com.dzagaduroska.great_circle_distance;

public class InvalidCustomerDataException extends RuntimeException {

    public InvalidCustomerDataException(RuntimeException exception) {
        super.initCause(exception);
    }
}
