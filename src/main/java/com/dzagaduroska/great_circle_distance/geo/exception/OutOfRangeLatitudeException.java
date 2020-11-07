package com.dzagaduroska.great_circle_distance.geo.exception;

/**
 * Exception thrown when the latitude value is out of range.
 */
public class OutOfRangeLatitudeException extends RuntimeException {

    public OutOfRangeLatitudeException(String message) {
        super(message);
    }

}
