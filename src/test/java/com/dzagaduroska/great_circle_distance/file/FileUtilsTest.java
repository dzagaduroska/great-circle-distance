package com.dzagaduroska.great_circle_distance.file;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class FileUtilsTest {

    @Test
    void shouldReadFileContentAndMapToArrayNode() throws IOException {
        String filePath = "/customers.txt";
        ArrayNode node = new ArrayNode(JsonNodeFactory.instance);

        MockedStatic<LineByLineBufferedReader> mockedStatic = Mockito.mockStatic(LineByLineBufferedReader.class);
        mockedStatic.when( () -> LineByLineBufferedReader.readJsonContentAndMapToArrayNode(any(String.class))).thenReturn(node);

        FileUtils.readJsonContentFromFileOnClasspath(filePath);

        mockedStatic.verify(() -> LineByLineBufferedReader.readJsonContentAndMapToArrayNode(filePath));
    }
}
