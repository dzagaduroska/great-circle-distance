package com.dzagaduroska.great_circle_distance.geo;

import com.dzagaduroska.great_circle_distance.geo.exception.OutOfRangeLatitudeException;
import lombok.Data;
import lombok.AllArgsConstructor;

/**
 * Latitude.
 */
@Data
@AllArgsConstructor
public class Latitude {

    /** The maximum latitude value in degrees */
    public static final double maxLatitudeValue = 90;
    /** The minimum latitude value in degrees */
    public static final double minLatitudeValue = -90;

    /**
     * Latitude value in degrees.
     */
    private double value;

    /**
     * The latitude value converted in radians.
     * @return the latitude in radians
     */
    double toRadians() {
        return Math.toRadians(value);
    }

    void validate() throws OutOfRangeLatitudeException {
        boolean isLatitudeInRange = value <= maxLatitudeValue && value >= minLatitudeValue;
        if (isLatitudeInRange) {
            return;
        }
        String messageFormat = "Out of range latitude value. Latitude must have a value be between %s and %s.";
        throw new OutOfRangeLatitudeException(String.format(messageFormat, minLatitudeValue, maxLatitudeValue));
    }
}
