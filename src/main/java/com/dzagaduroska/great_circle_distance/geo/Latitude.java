package com.dzagaduroska.great_circle_distance.geo;

import lombok.Data;
import lombok.AllArgsConstructor;

/**
 * Latitude.
 */
@Data
@AllArgsConstructor
public class Latitude {
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
}
