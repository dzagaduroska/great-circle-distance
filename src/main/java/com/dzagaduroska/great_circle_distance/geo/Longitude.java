package com.dzagaduroska.great_circle_distance.geo;

import com.dzagaduroska.great_circle_distance.geo.exception.OutOfRangeLongitudeException;
import lombok.Data;
import lombok.AllArgsConstructor;

/**
 * Longitude.
 */
@Data
@AllArgsConstructor
public class Longitude {

    /** The maximum latitude value in degrees */
    public static final double maxLongitudeValue = 180;
    /** The minimum latitude value in degrees */
    public static final double minLongitudeValue = -180;

    /**
     * The longitude value in degrees.
     */
    private double value;

    /**
     * The longitude value converted in radians.
     * @return the longitude in radians
     */
    double toRadians() {
        return Math.toRadians(value);
    }

    void validate() throws OutOfRangeLongitudeException {
        boolean isLongitudeInRange = value <= maxLongitudeValue && value >= minLongitudeValue;
        if (isLongitudeInRange) {
            return;
        }
        String messageFormat = "Out of range longitude value. Longitude must have a value be between %s and %s.";
        throw new OutOfRangeLongitudeException(String.format(messageFormat, minLongitudeValue, maxLongitudeValue));
    }
}
