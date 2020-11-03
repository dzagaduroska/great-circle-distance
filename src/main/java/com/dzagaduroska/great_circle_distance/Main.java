package com.dzagaduroska.great_circle_distance;

import com.dzagaduroska.great_circle_distance.geo.GeoCoordinate;
import com.dzagaduroska.great_circle_distance.geo.Latitude;
import com.dzagaduroska.great_circle_distance.geo.Longitude;

import java.util.ArrayList;
import java.util.List;

import static com.dzagaduroska.great_circle_distance.Constants.maxDistanceFromTheDublinOffice;
import static com.dzagaduroska.great_circle_distance.Constants.customerPrintFormat;

public class Main {

    public static void main(String[] args) {

        ArrayList<Customer> customersExample = new ArrayList<>();
        customersExample.add(new Customer(1, "Christina McArdle", new GeoCoordinate(new Latitude(52.986375), new Longitude( -6.043701))));
        customersExample.add(new Customer(2, "Alice Cahill", new GeoCoordinate(new Latitude(51.92893), new Longitude(-10.27699))));
        customersExample.add(new Customer(3, "Ian McArdle", new GeoCoordinate(new Latitude(51.8856167), new Longitude(-10.4240951))));

        DublinOfficeDistanceSolution.setDublinOfficeAsStartingPoint();

        List<Customer> customersWithinGivenDistanceFromDublinOffice = DublinOfficeDistanceSolution
                .getSortedCustomersWithinGivenDistanceFromDublinOffice(customersExample, maxDistanceFromTheDublinOffice);

        printCustomers(customersWithinGivenDistanceFromDublinOffice);
    }

    private static void printCustomers(List<Customer> customerList) {
        customerList.forEach(customer -> System.out.printf(customerPrintFormat, customer.getId(), customer.getFullName()));
    }
}
