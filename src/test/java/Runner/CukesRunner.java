package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/CucumberFeatures/BuyingAirJordanRetro.feature",
        glue = "",
        monochrome = true,
        dryRun = true
)

public class CukesRunner {
}
