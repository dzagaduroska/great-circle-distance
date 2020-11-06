package com.dzagaduroska.great_circle_distance.file;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class LineByLineBufferedReaderTest {

    @Test
    public void shouldReadJsonContentAndMapToArrayNode() throws IOException {
        ArrayNode node = LineByLineBufferedReader.readJsonContentAndMapToArrayNode("/customers.txt");
        Assertions.assertNotNull(node);
    }
}
