package com.dzagaduroska.great_circle_distance.mapper;

import com.dzagaduroska.great_circle_distance.Customer;
import com.dzagaduroska.great_circle_distance.geo.GeoCoordinate;
import com.dzagaduroska.great_circle_distance.geo.Latitude;
import com.dzagaduroska.great_circle_distance.geo.Longitude;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonNodeToCustomerMapper {

    private static final String userIdProperty = "user_id";
    private static final String nameProperty = "name";
    private static final String latitudeProperty = "latitude";
    private static final String longitudeProperty = "longitude";

    public static Customer map(JsonNode node) {
        Integer id = node.get(userIdProperty).intValue();
        String name = node.get(nameProperty).textValue();
        GeoCoordinate geoCoordinate = getGeoCoordinateFromNode(node);

        return new Customer(id, name, geoCoordinate);
    }

    private static GeoCoordinate getGeoCoordinateFromNode(JsonNode node) {
        double latitude = Double.parseDouble(node.get(latitudeProperty).textValue());
        double longitude = Double.parseDouble(node.get(longitudeProperty).textValue());
        return new GeoCoordinate(new Latitude(latitude), new Longitude(longitude));
    }
}
