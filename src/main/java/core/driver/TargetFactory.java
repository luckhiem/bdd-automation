package core.driver;

import core.driver.manager.ChromeDriverManager;
import core.driver.manager.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class TargetFactory {
    public WebDriver createInstance(String platform) throws MalformedURLException {
        WebDriver webdriver = null;
        Platform platformType = Platform.valueOf(platform.toUpperCase());

        switch (platformType) {
            case CHROME:
                webdriver = new ChromeDriverManager().createDriver();
                break;
            case FIREFOX:
                webdriver = new FirefoxDriverManager().createDriver();
                break;
            default:
                break;
        }
        return webdriver;
    }

    public enum Platform {
        CHROME, FIREFOX,
    }
}
