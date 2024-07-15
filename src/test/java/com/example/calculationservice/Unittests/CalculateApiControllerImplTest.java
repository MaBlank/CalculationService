package com.example.calculationservice.Unittests;

import static org.junit.jupiter.api.Assertions.*;

import com.example.calculationservice.CalculateApiControllerImpl;
import org.junit.jupiter.api.Test;
import com.example.model.CalculateResponse;
import org.springframework.http.ResponseEntity;
import com.example.model.CalculateRequest;

class CalculateApiControllerImplTest {

    private final CalculateApiControllerImpl controller = new CalculateApiControllerImpl();

    @Test
    void testCalculatePostPositiveNumbers() {
        CalculateRequest request = new CalculateRequest().number1(5).number2(3);
        ResponseEntity<CalculateResponse> response = controller.calculatePost(request);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(8, response.getBody().getResult());
    }

    @Test
    void testCalculatePostNegativeNumbers() {
        CalculateRequest request = new CalculateRequest().number1(-5).number2(-3);
        ResponseEntity<CalculateResponse> response = controller.calculatePost(request);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(-8, response.getBody().getResult());
    }

    @Test
    void testCalculatePostZeroAndPositive() {
        CalculateRequest request = new CalculateRequest().number1(0).number2(3);
        ResponseEntity<CalculateResponse> response = controller.calculatePost(request);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(3, response.getBody().getResult());
    }

    @Test
    void testCalculatePostLargeNumbers() {
        CalculateRequest request = new CalculateRequest().number1(Integer.MAX_VALUE).number2(1);
        ResponseEntity<CalculateResponse> response = controller.calculatePost(request);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(Integer.MIN_VALUE, response.getBody().getResult()); // Overflow
    }
}
