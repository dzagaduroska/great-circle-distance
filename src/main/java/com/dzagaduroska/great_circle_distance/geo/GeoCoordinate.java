package com.dzagaduroska.great_circle_distance.geo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Geographical coordinate defined by the latitude and the longitude.
 */
@Getter
@Setter
@AllArgsConstructor
public class GeoCoordinate {
    Latitude latitude;
    Longitude longitude;
}
