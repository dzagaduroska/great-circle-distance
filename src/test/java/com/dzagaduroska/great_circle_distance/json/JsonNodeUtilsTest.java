package com.dzagaduroska.great_circle_distance.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JsonNodeUtilsTest {

    @Test
    public void shouldCreateJsonNode() {
        Assertions.assertNotNull(JsonNodeUtils.createArrayNode());
    }

    @Test
    public void shouldMapTextToJsonNode() {
        String jsonText = "{ \"text\": \"text\" }";
        Assertions.assertNotNull(JsonNodeUtils.mapTextToJsonNode(jsonText));
    }

    @Test
    public void shouldReturnNullWhenMappingInvalidJsonTextToJsonNode() {
        String invalidJsonText = "{ \"text\": text\" }";
        Assertions.assertNull(JsonNodeUtils.mapTextToJsonNode(invalidJsonText));
    }

    @Test
    public void shouldAddNodeToArrayNode() {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode arrayNode = objectMapper.createArrayNode();
        ObjectNode node = objectMapper.createObjectNode();
        ArrayNode arrayNodeSpy = Mockito.spy(arrayNode);

        JsonNodeUtils.addToArrayNode(arrayNodeSpy, node);

        Mockito.verify(arrayNodeSpy).add(node);
    }

}
