package com.example.calculationservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import com.networknt.schema.SpecVersion;

import java.io.InputStream;
import java.util.Set;

public class JsonSchemaValidator {

    public static void validateJson(String schemaFilePath, String jsonFilePath) throws Exception {
        // Erstelle einen ObjectMapper zum Lesen von JSON-Dateien
        ObjectMapper objectMapper = new ObjectMapper();

        // Lade das Schema
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7);
        InputStream schemaInputStream = JsonSchemaValidator.class.getClassLoader().getResourceAsStream(schemaFilePath);
        JsonSchema schema = schemaFactory.getSchema(objectMapper.readTree(schemaInputStream));

        // Lade das JSON-Dokument
        InputStream jsonInputStream = JsonSchemaValidator.class.getClassLoader().getResourceAsStream(jsonFilePath);
        JsonNode jsonNode = objectMapper.readTree(jsonInputStream);

        // Validiere das JSON-Dokument gegen das Schema
        Set<ValidationMessage> errors = schema.validate(jsonNode);

        // Überprüfe auf Validierungsfehler
        if (!errors.isEmpty()) {
            for (ValidationMessage error : errors) {
                System.out.println(error.getMessage());
            }
            throw new Exception("JSON-Dokument entspricht nicht dem Schema.");
        }
    }
}
