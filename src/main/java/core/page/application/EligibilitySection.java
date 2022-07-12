package core.page.application;

import core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.actions.WaitActions.staticWait;

public class EligibilitySection extends BasePage {
    WebDriver driver;

    String registeredCheck = "//input[@name='react-eligibility-sg_registered_check']//..//..//span[text()='%s']";
    String turnOverCheck = "//input[@name='react-eligibility-turnover_check']//..//..//span[text()='%s']";
    String globalHQCheck = "//input[@name='react-eligibility-global_hq_check']//..//..//span[text()='%s']";
    String targetMarketCheck = "//input[@name='react-eligibility-new_target_market_check']//..//..//span[text()='%s']";
    String startedProjectCheck = "//input[@name='react-eligibility-started_project_check']//..//..//span[text()='%s']";

    @FindBy(xpath = "(//div[@class='field-warning-text'])[1]")
    protected WebElement waringMessageField;

    @FindBy(css = ".field-warning-text")
    protected List<WebElement> listOfWarningMessage;

    public EligibilitySection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public EligibilitySection selectRegisteredCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(registeredCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public EligibilitySection selectTurnOverCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(turnOverCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public EligibilitySection selectGlobalHQCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(globalHQCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public EligibilitySection selectTargetMarket(String value) throws InterruptedException {
        By locator = By.xpath(String.format(targetMarketCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public EligibilitySection selectStartedProjectCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(startedProjectCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public String getWarningMessageText() {
        return assertAction.getElementText(waringMessageField);
    }

    public int getNumberWarningMessage() {
        return listOfWarningMessage.size();
    }
}
