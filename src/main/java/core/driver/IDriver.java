package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.net.MalformedURLException;

public interface IDriver {
    WebDriver createDriver() throws MalformedURLException;
    AbstractDriverOptions<?> createCapabilities();
}
