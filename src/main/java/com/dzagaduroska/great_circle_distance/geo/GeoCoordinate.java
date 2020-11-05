package com.dzagaduroska.great_circle_distance.geo;

import lombok.Data;
import lombok.AllArgsConstructor;

/**
 * Geographical coordinate defined by the latitude and the longitude.
 */
@AllArgsConstructor
@Data
public class GeoCoordinate {
    Latitude latitude;
    Longitude longitude;
}
