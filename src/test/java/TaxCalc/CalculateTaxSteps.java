package TaxCalc;

import com.example.calculationservice.CalculateApiControllerImpl;
import com.example.model.CalculateTaxRequest;
import com.example.model.CalculateTaxResponse;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.de.Dann;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateTaxSteps {

    private CalculateApiControllerImpl controller;
    private CalculateTaxRequest request;
    private ResponseEntity<CalculateTaxResponse> response;

    @Angenommen("ich habe einen Steuerbilanzgewinn von {double}")
    public void ich_habe_einen_Steuerbilanzgewinn_von(Double steuerbilanzgewinn) {
        controller = new CalculateApiControllerImpl();
        request = new CalculateTaxRequest();
        request.setSteuerbilanzgewinn(BigDecimal.valueOf(steuerbilanzgewinn));
    }

    @Wenn("ich die calculateTaxPost-Methode aufrufe")
    public void ich_die_calculateTaxPost_Methode_aufrufe() {
        response = controller.calculateTaxPost(request);
    }

    @Dann("erhalte ich eine Antwort mit dem Ergebnis {double}")
    public void erhalte_ich_eine_Antwort_mit_dem_Ergebnis(Double erwartetesErgebnis) {
        assertNotNull(response, "Die ResponseEntity sollte nicht null sein");
        assertEquals(200, response.getStatusCodeValue(), "Der HTTP-Statuscode sollte 200 sein");

        CalculateTaxResponse responseBody = response.getBody();
        assertNotNull(responseBody, "Der Response-Body sollte nicht null sein");
        assertEquals(BigDecimal.valueOf(erwartetesErgebnis), responseBody.getResult(), "Das berechnete Ergebnis ist nicht korrekt");
    }
}
