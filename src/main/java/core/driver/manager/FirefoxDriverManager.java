package core.driver.manager;

import core.driver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements IDriver {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        return new FirefoxDriver(createCapabilities());
    }

    @Override
    public FirefoxOptions createCapabilities() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("browser.download.folderList", 2);
        firefoxOptions.addPreference("browser.download.manager.showWhenStarting", false);
        firefoxOptions.addPreference("browser.download.useDownloadDir", true);
        firefoxOptions.addPreference("browser.download.viewableInternally.enabledTypes", "");
        return firefoxOptions;
    }
}
