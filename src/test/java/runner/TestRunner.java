package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/jsonReports/cucumber.json"},
        features = {"src/test/java/features"},
        glue = {"runner", "steps"},
        monochrome = true
)
public class TestRunner {

}
