package com.dzagaduroska.great_circle_distance;

import com.dzagaduroska.great_circle_distance.file.FileUtils;
import com.dzagaduroska.great_circle_distance.mapper.JsonNodeToCustomerMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.dzagaduroska.great_circle_distance.Constants.customerPrintFormat;
import static com.dzagaduroska.great_circle_distance.Constants.customersFileClasspath;

public class CustomerUtils {

    static void printCustomers(List<Customer> customerList) {
        customerList.forEach(customer -> System.out.printf(customerPrintFormat, customer.getId(), customer.getFullName()));
    }

    static ArrayList<Customer> readCustomersFromFile() throws IOException {
        ArrayNode arrayNode = FileUtils.readJsonContentFromFileOnClasspath(customersFileClasspath);
        return mapToArrayOfCustomers(arrayNode);
    }

    private static ArrayList<Customer> mapToArrayOfCustomers(ArrayNode arrayNode) {
        ArrayList<Customer> customers = new ArrayList<>();
        arrayNode.forEach(n -> customers.add(JsonNodeToCustomerMapper.map(n)));
        return  customers;
    }
}
