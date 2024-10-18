package TaxCalc;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Path to your feature files
        glue = "com.example.calculationservice" // Package containing your step definitions and configuration class
)
public class RunCucumberTest {
}
