package com.dzagaduroska.great_circle_distance;

import com.dzagaduroska.great_circle_distance.geo.GeoCoordinate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Customer {
    private Integer id;
    private String fullName;
    GeoCoordinate geoCoordinate;
}
