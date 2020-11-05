package com.dzagaduroska.great_circle_distance.file;

import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;

public class FileUtils {

    public static ArrayNode readJsonContentFromFileOnClasspath(String filePath) throws IOException {
        return LineByLineBufferedReader.readJsonContentAndMapToArrayNode(filePath);
    }
}
