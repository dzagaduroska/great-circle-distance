package com.dzagaduroska.great_circle_distance.file;

import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;

/**
 * Class containing file utility methods.
 */
public class FileUtils {

    /**
     * Reads json content from file on classpath.
     *
     * @param filePath the file path
     * @return the file content in array node
     * @throws IOException IO exception
     */
    public static ArrayNode readJsonContentLineByLineFromTextFile(String filePath) throws IOException {
        return LineByLineBufferedReader.readJsonContentFromClasspathAndMapToArrayNode(filePath);
    }
}
