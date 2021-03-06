package com.dzagaduroska.great_circle_distance.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * JsonNode Utility Class.
 */
public class JsonNodeUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Creates an empty array node.
     * @return the array node
     */
    public static ArrayNode createArrayNode() {
        return objectMapper.createArrayNode();
    }

    /**
     * Maps text to json node.
     *
     * @param text the text
     * @return the node
     */
    public static JsonNode mapTextToJsonNode(String text) {
        JsonNode node = null;
        try {
            node = objectMapper.readTree(text);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return node;
    }

    /**
     * Adds the node to the array node.
     *
     * @param arrayNode the array node
     * @param node the node to add to the array node
     */
    public static void addToArrayNode(ArrayNode arrayNode, JsonNode node) {
        arrayNode.add(node);
    }
}
