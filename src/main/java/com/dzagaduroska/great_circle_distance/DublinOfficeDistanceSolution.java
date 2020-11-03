package com.dzagaduroska.great_circle_distance;

import com.dzagaduroska.great_circle_distance.geo.GeoCoordinate;
import com.dzagaduroska.great_circle_distance.geo.Latitude;
import com.dzagaduroska.great_circle_distance.geo.Longitude;
import com.dzagaduroska.great_circle_distance.geo.SphericalLawOfCosinesImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class DublinOfficeDistanceSolution {

    private static final Latitude latitudeOfDublin = new Latitude(Constants.latitudeOfTheDublinOffice);
    private static final Longitude longitudeOfDublin = new Longitude(Constants.longitudeOfTheDublinOffice);
    private static final GeoCoordinate geoLocationOfDublinOffice = new GeoCoordinate(latitudeOfDublin, longitudeOfDublin);

    private static final SphericalLawOfCosinesImpl sphericalLawOfCosines = new SphericalLawOfCosinesImpl();

    static void setDublinOfficeAsStartingPoint() {
        sphericalLawOfCosines.setStartingCoordinate(geoLocationOfDublinOffice);
    }

    static List<Customer> getSortedCustomersWithinGivenDistanceFromDublinOffice(ArrayList<Customer> arrayOfCustomers, double maxDistance) {

        return arrayOfCustomers.stream()
                .filter(customer -> withinMaxDistance(customer, maxDistance))
                .sorted(Comparator.comparing(Customer::getId))
                .collect(Collectors.toList());
    }

    private static Boolean withinMaxDistance(Customer customer, Double maxDistance) {
        double distance = sphericalLawOfCosines.getDistanceFromStartingCoordinateToDestinationCoordinate(customer.getGeoCoordinate());
        return distance <= maxDistance;
    }
}
