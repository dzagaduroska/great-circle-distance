package com.dzagaduroska.great_circle_distance.geo.exception;

/**
 * Exception thrown when the longitude value is out of range.
 */
public class OutOfRangeLongitudeException extends RuntimeException {

    public OutOfRangeLongitudeException(String message) {
        super(message);
    }
}
