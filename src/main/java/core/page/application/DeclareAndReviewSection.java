package core.page.application;

import core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.actions.WaitActions.staticWait;

public class DeclareAndReviewSection extends BasePage {
    WebDriver driver;

    @FindBy(id = "react-declaration-consent_acknowledgement_check")
    protected WebElement acknowledgeCheck;

    String criminalLiabilityCheck = "//input[@name='react-declaration-criminal_liability_check']//../span[text()='%s']";
    String civilProceedingCheck = "//input[@name='react-declaration-civil_proceeding_check']//../span[text()='%s']";
    String insolvencyProceedingCheck = "//input[@name='react-declaration-insolvency_proceeding_check']//../span[text()='%s']";
    String incentivesCheck = "//input[@name='react-declaration-project_incentives_check']//../span[text()='%s']";
    String otherIncentivesCheck = "//input[@name='react-declaration-other_incentives_check']//../span[text()='%s']";
    String commenceCheck = "//input[@name='react-declaration-project_commence_check']//../span[text()='%s']";
    String relatedPartyCheck = "//input[@name='react-declaration-related_party_check']//../span[text()='%s']";
    String debarmentCheck = "//input[@name='react-declaration-debarment_check']//../span[text()='%s']";
    String covidSafeCheck = "//input[@name='react-declaration-covid_safe_check']//../span[text()='%s']";
    String covidSafeQuesCheck = "//input[@name='react-declaration-covid_safe_ques_check']//../span[text()='%s']";

    public DeclareAndReviewSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public DeclareAndReviewSection selectCriminalLiabilityCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(criminalLiabilityCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection selectCivilProceedingCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(civilProceedingCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection selectInsolvencyProceedingCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(insolvencyProceedingCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection selectIncentivesCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(incentivesCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection selectOtherIncentivesCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(otherIncentivesCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection selectCommenceCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(commenceCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection selectRelatedPartyCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(relatedPartyCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection selectDebarmentCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(debarmentCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection selectCovidSafeCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(covidSafeCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection selectCovidSafeQuesCheck(String value) throws InterruptedException {
        By locator = By.xpath(String.format(covidSafeQuesCheck, value));
        waitAction.waitUntilLocatorVisible(locator);
        clickAction.clickOn(locator);
        return this;
    }

    public DeclareAndReviewSection checkOnAcknowledgeCheck(){
        clickAction.clickOn(acknowledgeCheck);
        return this;
    }
}
