package core.actions;

import core.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseActions {
    public final static Logger LOGGER = LogManager.getLogger("Cucumber");
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseActions() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(30));
    }
}
