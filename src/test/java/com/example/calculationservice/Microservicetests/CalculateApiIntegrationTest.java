package com.example.calculationservice.Microservicetests;

import com.example.model.CalculateRequest;
import com.example.model.CalculateResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculateApiIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCalculateEndpoint() {
        CalculateRequest request = new CalculateRequest().number1(10).number2(5);
        ResponseEntity<CalculateResponse> response = restTemplate.postForEntity("/calculate", request, CalculateResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(15, response.getBody().getResult());
    }
}
