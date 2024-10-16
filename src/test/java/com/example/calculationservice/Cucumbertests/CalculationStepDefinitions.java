package com.example.calculationservice.Cucumbertests;
import com.example.calculationservice.CalculationServiceApplication;
import com.example.model.CalculateRequest;
import com.example.model.CalculateResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = CalculationServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class CalculationStepDefinitions {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private ResponseEntity<CalculateResponse> response;
    private ResponseEntity<String> errorResponse;

    @Given("the calculation service is running")
    public void theCalculationServiceIsRunning() {
        // Assuming the service is already running for the test
    }

    @When("I send a request to add {int} and {int}")
    public void iSendARequestToAddAnd(int number1, int number2) {
        CalculateRequest request = new CalculateRequest();
        request.setNumber1(number1);
        request.setNumber2(number2);
        String url = "http://localhost:" + port + "/calculate";
        response = restTemplate.postForEntity(url, request, CalculateResponse.class);
    }

    @Then("the response should be {int}")
    public void theResponseShouldBe(int expectedResult) {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody().getResult());
    }

    @When("I send a request with non-numeric values")
    public void iSendARequestWithNonNumericValues() {
        String invalidRequest = "{\"number1\":\"abc\",\"number2\":\"def\"}";
        String url = "http://localhost:" + port + "/calculate";
        errorResponse = restTemplate.postForEntity(url, invalidRequest, String.class);
    }

    @Then("the response should indicate an invalid input error")
    public void theResponseShouldIndicateAnInvalidInputError() {
        assertEquals(HttpStatus.BAD_REQUEST, errorResponse.getStatusCode());
        assertTrue(errorResponse.getBody().contains("Invalid input"));
    }

    @Then("the response should indicate an overflow error")
    public void theResponseShouldIndicateAnOverflowError() {
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().toString().contains("Overflow"));
    }
}
