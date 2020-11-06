package com.dzagaduroska.great_circle_distance;

import com.dzagaduroska.great_circle_distance.geo.GeoCoordinate;
import com.dzagaduroska.great_circle_distance.geo.Latitude;
import com.dzagaduroska.great_circle_distance.geo.Longitude;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DublinOfficeDistanceSolutionTest {

    @Test
    void shouldGetSortedCustomersWithinGivenDistanceFromDublinOffice() {
        DublinOfficeDistanceSolution.setDublinOfficeAsStartingPoint();

        ArrayList<Customer> customerArrayList = getArrayOfCustomers();
        double maxDistance = 100.0;

        List<Customer> matchingCustomers = DublinOfficeDistanceSolution
                .getSortedCustomersWithinGivenDistanceFromDublinOffice(customerArrayList, maxDistance);
        Assertions.assertNotNull(matchingCustomers);
    }

    public ArrayList<Customer> getArrayOfCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Christina McArdle",
                new GeoCoordinate(new Latitude(52.986375), new Longitude(-6.043701))));
        customers.add(new Customer(2, "Alice Cahill",
                new GeoCoordinate(new Latitude(51.92893), new Longitude(-10.27699))));
        customers.add(new Customer(3, "Ian McArdle",
                new GeoCoordinate(new Latitude(51.8856167), new Longitude(-10.4240951))));
        return customers;
    }
}
