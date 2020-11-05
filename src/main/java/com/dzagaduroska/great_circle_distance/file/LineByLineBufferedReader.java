package com.dzagaduroska.great_circle_distance.file;

import com.dzagaduroska.great_circle_distance.json.JsonNodeUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;

import static com.dzagaduroska.great_circle_distance.json.JsonNodeUtils.addToArrayNode;
import static com.dzagaduroska.great_circle_distance.json.JsonNodeUtils.mapStringToJsonNode;

public class LineByLineBufferedReader {

     static ArrayNode readJsonContentAndMapToArrayNode(String filePath) throws IOException {
        ArrayNode arrayNode = JsonNodeUtils.createArrayNode();

         InputStream inputStream = LineByLineBufferedReader.class.getResourceAsStream(filePath);
         InputStreamReader fileReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(fileReader);

        reader.lines().forEachOrdered(line -> {
            JsonNode node = mapStringToJsonNode(line);
            addNodeToArrayNodeIfNotNull(node, arrayNode, line);
        });

        reader.close();

        return arrayNode;
    }

    private static void addNodeToArrayNodeIfNotNull(JsonNode node, ArrayNode arrayNode, String line) {
        if (node != null) {
            addToArrayNode(arrayNode, node);
        } else {
            System.out.println("Invalid json object. Skipping line: " + line);
        }
    }
}
