package core.driver.manager;

import core.driver.IDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager implements IDriver {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        return new ChromeDriver(createCapabilities());
    }

    @Override
    public ChromeOptions createCapabilities() {
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 2);
        chromePrefs.put("profile.default_content_settings.javascript", 1);
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
        chromePrefs.put("safebrowsing.enabled", true);
        chromePrefs.put("directory_upgrade", true);
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }
}
