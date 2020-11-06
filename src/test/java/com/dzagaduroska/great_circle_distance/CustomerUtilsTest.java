package com.dzagaduroska.great_circle_distance;

import com.dzagaduroska.great_circle_distance.file.FileUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;

import static com.dzagaduroska.great_circle_distance.Constants.customersFileClasspath;

@ExtendWith(MockitoExtension.class)
public class CustomerUtilsTest {

    @Test
    void shouldReadCustomersFromFile() throws IOException {
        ArrayNode node = getArrayNodeContainingJsonNodeWithCustomerFields();
        MockedStatic<FileUtils> mockedStatic = Mockito.mockStatic(FileUtils.class);
        mockedStatic.when( () -> FileUtils.readJsonContentFromFileOnClasspath(customersFileClasspath)).thenReturn(node);

        ArrayList<Customer> customerArrayList = CustomerUtils.readCustomersFromFile();

        mockedStatic.verify(() -> FileUtils.readJsonContentFromFileOnClasspath(customersFileClasspath));
        Assertions.assertNotNull(customerArrayList);
    }

    private ArrayNode getArrayNodeContainingJsonNodeWithCustomerFields() {
        ObjectNode node = new ObjectNode(JsonNodeFactory.instance);
        node.put("user_id", 1);
        node.put("name", "John Smith");
        node.put("longitude", "22");
        node.put("latitude", "123");

        ArrayNode arrayNode = new ObjectMapper().createArrayNode();
        arrayNode.add(node);
        return arrayNode;
    }
}
