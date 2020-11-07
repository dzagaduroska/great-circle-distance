package com.dzagaduroska.great_circle_distance.geo;

import com.dzagaduroska.great_circle_distance.geo.exception.OutOfRangeLatitudeException;
import com.dzagaduroska.great_circle_distance.geo.exception.OutOfRangeLongitudeException;
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

    public void validate() throws OutOfRangeLatitudeException, OutOfRangeLongitudeException {
        latitude.validate();
        longitude.validate();
    }
}
