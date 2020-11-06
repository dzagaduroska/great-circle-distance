package com.dzagaduroska.great_circle_distance.file;

import com.dzagaduroska.great_circle_distance.json.JsonNodeUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;

import static com.dzagaduroska.great_circle_distance.json.JsonNodeUtils.addToArrayNode;
import static com.dzagaduroska.great_circle_distance.json.JsonNodeUtils.mapTextToJsonNode;

public class LineByLineBufferedReader {

    static ArrayNode readJsonContentAndMapToArrayNode(String filePath) throws IOException {
        ArrayNode arrayNode = JsonNodeUtils.createArrayNode();

        var fromClasspath = LineByLineBufferedReader.class;

        InputStream inputStream = fromClasspath.getResourceAsStream(filePath);
        InputStreamReader fileReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(fileReader);

        reader.lines().forEachOrdered(line -> {
            JsonNode node = mapTextToJsonNode(line);
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
