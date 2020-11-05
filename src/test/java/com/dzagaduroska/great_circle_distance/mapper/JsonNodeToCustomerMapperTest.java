package com.dzagaduroska.great_circle_distance.mapper;

import com.dzagaduroska.great_circle_distance.Customer;
import com.dzagaduroska.great_circle_distance.geo.GeoCoordinate;
import com.dzagaduroska.great_circle_distance.geo.Latitude;
import com.dzagaduroska.great_circle_distance.geo.Longitude;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class JsonNodeToCustomerMapperTest {

    @Test
    public void shouldMapJsonNodeToCustomer() {
        JsonNode node = getJsonNodeWithCustomerProperties();

        Customer customer = JsonNodeToCustomerMapper.map(node);

        Assertions.assertEquals(getExpectedCustomer(), customer);
    }

    private JsonNode getJsonNodeWithCustomerProperties() {
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("user_id", 1);
        node.put("name", "John Smith");
        node.put("longitude", "22");
        node.put("latitude", "123");
        return node;
    }

    private Customer getExpectedCustomer() {
        return new Customer(1, "John Smith",
                new GeoCoordinate(new Latitude(123), new Longitude(22)));
    }
}
