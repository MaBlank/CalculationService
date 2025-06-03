package com.example.calculationservice.Unittests;

import static org.junit.jupiter.api.Assertions.*;

import com.example.calculationservice.CalculateApiControllerImpl;
import com.example.model.CalculateRequest;
import com.example.model.CalculateResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class Calculate2ApiControllerImplTest {

    private final CalculateApiControllerImpl controller = new CalculateApiControllerImpl();

    @Test
    void testCalculate2PostPositiveNumbers() {
        CalculateRequest request = new CalculateRequest().number1(5).number2(3);
        ResponseEntity<CalculateResponse> response = controller.calculate2Post(request);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(8, response.getBody().getResult());
    }

    @Test
    void testCalculate2PostNegativeNumbers() {
        CalculateRequest request = new CalculateRequest().number1(-5).number2(-3);
        ResponseEntity<CalculateResponse> response = controller.calculate2Post(request);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(-8, response.getBody().getResult());
    }

    @Test
    void testCalculate2PostLargeNumbers() {
        CalculateRequest request = new CalculateRequest().number1(Integer.MAX_VALUE).number2(1);
        ResponseEntity<CalculateResponse> response = controller.calculate2Post(request);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(Integer.MIN_VALUE, response.getBody().getResult()); // Overflow
    }
}
