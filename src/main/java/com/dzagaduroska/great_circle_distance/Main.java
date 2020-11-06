package com.dzagaduroska.great_circle_distance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.dzagaduroska.great_circle_distance.Constants.*;
import static com.dzagaduroska.great_circle_distance.CustomerUtils.printCustomers;
import static com.dzagaduroska.great_circle_distance.CustomerUtils.readCustomersFromFile;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Customer> customers = readCustomersFromFile();

        DublinOfficeDistanceSolution.setDublinOfficeAsStartingPoint();
        List<Customer> customersWithinGivenDistanceFromDublinOffice = DublinOfficeDistanceSolution
                .getSortedCustomersWithinGivenDistanceFromDublinOffice(customers, maxDistanceFromTheDublinOffice);

        printCustomers(customersWithinGivenDistanceFromDublinOffice);
    }
}
