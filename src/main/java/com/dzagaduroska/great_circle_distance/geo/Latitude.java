package com.dzagaduroska.great_circle_distance.geo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Latitude.
 */
@Getter
@Setter
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
