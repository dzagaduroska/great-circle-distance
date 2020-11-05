package com.dzagaduroska.great_circle_distance.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JsonNodeUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ArrayNode createArrayNode() {
        return objectMapper.createArrayNode();
    }

    public static JsonNode mapStringToJsonNode(String line) {
        JsonNode node = null;
        try {
            node = objectMapper.readTree(line);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return node;
    }

    public static void addToArrayNode(ArrayNode arrayNode, JsonNode node) {
        arrayNode.add(node);
    }
}
