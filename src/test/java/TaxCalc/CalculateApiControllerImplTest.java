package TaxCalc;

import com.example.calculationservice.CalculateApiControllerImpl;
import com.example.model.CalculateTaxRequest;
import com.example.model.CalculateTaxResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateApiControllerImplTest {

    @Test
    public void testCalculateTaxPost() {
        // Arrange
        CalculateApiControllerImpl controller = new CalculateApiControllerImpl();
        CalculateTaxRequest request = new CalculateTaxRequest();
        request.setSteuerbilanzgewinn(new BigDecimal("1000"));

        // Act
        ResponseEntity<CalculateTaxResponse> response = controller.calculateTaxPost(request);

        // Assert
        assertNotNull(response, "Die ResponseEntity sollte nicht null sein");
        assertEquals(200, response.getStatusCodeValue(), "Der HTTP-Statuscode sollte 200 sein");

        CalculateTaxResponse responseBody = response.getBody();
        assertNotNull(responseBody, "Der Response-Body sollte nicht null sein");
        assertEquals(new BigDecimal("300"), responseBody.getResult(), "Das berechnete Steuerergebnis sollte 300.0 sein");
    }
}
