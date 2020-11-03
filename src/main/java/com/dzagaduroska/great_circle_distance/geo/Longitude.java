package com.dzagaduroska.great_circle_distance.geo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Longitude.
 */
@Getter
@Setter
@AllArgsConstructor
public class Longitude {
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
}
