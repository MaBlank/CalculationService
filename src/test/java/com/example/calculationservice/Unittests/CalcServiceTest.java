package com.example.calculationservice.Unittests;

import com.example.calculationservice.CalcService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CalcServiceTest {

    @Test
    public void testCalculateExpectedValues() throws IOException {
        // JSON-Datei einlesen
        File jsonFile = new File("C:\\Users\\Matth\\IdeaProjects\\CalculationService\\src\\main\\resources\\export.json"); // Pfad zur JSON-Datei anpassen
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonFile);

        // CalcService-Instanz erstellen
        CalcService calcService = new CalcService();

        // Durch jede Anfrage in der JSON-Datei iterieren und berechnen
        for (JsonNode entry : rootNode) {
            // Anfrage-Werte auslesen
            int a = entry.get("Anfrage").get("A").asInt();
            int b = entry.get("Anfrage").get("B").asInt();
            int c = entry.get("Anfrage").get("C").asInt();
            int d = entry.get("Anfrage").get("D").asInt();

            // Erwartete Werte auslesen
            int expectedE = entry.get("Erwartete_Werte").get("E").asInt();
            int expectedF = entry.get("Erwartete_Werte").get("F").asInt();
            int expectedG = entry.get("Erwartete_Werte").get("G").asInt();
            int expectedH = entry.get("Erwartete_Werte").get("H").asInt();

            // Berechnete Werte abrufen
            int[] calculatedValues = calcService.calculateExpectedValues(a, b, c, d);

            // Erwartete Werte vergleichen
            int[] expectedValues = {expectedE, expectedF, expectedG, expectedH};
            assertArrayEquals(expectedValues, calculatedValues, "Die berechneten Werte stimmen nicht mit den erwarteten Werten überein.");
        }
    }
}
