package com.dzagaduroska.great_circle_distance;

import com.dzagaduroska.great_circle_distance.geo.GeoCoordinate;

import com.dzagaduroska.great_circle_distance.geo.exception.OutOfRangeLatitudeException;
import com.dzagaduroska.great_circle_distance.geo.exception.OutOfRangeLongitudeException;
import lombok.Data;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Data
public class Customer {
    private Integer id;
    private String fullName;
    GeoCoordinate geoCoordinate;

    void validate() throws InvalidCustomerDataException {
        try {
            geoCoordinate.validate();
        } catch (OutOfRangeLatitudeException | OutOfRangeLongitudeException exception) {
            throw new InvalidCustomerDataException(exception);
        }

    }
}
