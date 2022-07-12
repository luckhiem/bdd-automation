package runner;

import core.driver.DriverManager;
import core.driver.TargetFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import static core.constants.Platform.BROWSER;

public class Hook {
    public final static Logger LOGGER = LogManager.getLogger("Cucumber");

    @Before
    public void beforeEachScenario(Scenario scenario) throws MalformedURLException {
        System.out.println();
        System.out.println("============================================================");
        LOGGER.warn("** AUTOMATION TEST ***");
        System.out.println("============================================================");
        System.out.println();
        String scenarioName = scenario.getName();
        LOGGER.info(String.format("Starting test: %s", scenarioName));
        WebDriver driver = new TargetFactory().createInstance(BROWSER);
        DriverManager.setDriver(driver);
    }

    @After()
    public void afterEachScenario() {
        DriverManager.quit();
        System.out.println();
        System.out.println("============================================================");
        LOGGER.warn("** DONE TEST ***");
        System.out.println("============================================================");
        System.out.println();
    }
}