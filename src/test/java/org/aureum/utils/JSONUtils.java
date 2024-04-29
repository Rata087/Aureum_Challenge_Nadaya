package org.aureum.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class JSONUtils {

    public static String updateField(String requestBody, String fieldName, String newValue) throws IOException {
        // Parse the JSON
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(requestBody);

        // Field update
        ((ObjectNode) jsonNode).put(fieldName, newValue);

        // Return the updated JSON as a String
        return objectMapper.writeValueAsString(jsonNode);
    }
}
