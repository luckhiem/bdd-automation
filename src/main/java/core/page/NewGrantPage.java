package core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewGrantPage extends BasePage {
    WebDriver driver;

    @FindBy(css = "#dashboard-menubox-app-apply-grant .dashboard-action-title")
    protected WebElement getGrantNewButton;

    @FindBy(xpath = "//input[@id='Capability Development']//..//div[@class='item']")
    protected WebElement capabilityDevelopmentOption;

    @FindBy(xpath = "//input[@id='International Expansion']//..//div[@class='item']")
    protected WebElement internationalExpansionOption;

    @FindBy(xpath = "//input[@id=\"Enhance tourists' experience in Singapore\"]//..//div[@class='item']")
    protected WebElement enhanceTouristsExpOption;

    @FindBy(xpath = "//input[@id='Market Readiness Assistance 2']//..//div[@class='item']")
    protected WebElement marketReadinessOption;

    @FindBy(xpath = "//input[@id='Market Access & Development']//..//div[@class='item']")
    protected WebElement marketAccessOption;

    @FindBy(id = "go-to-grant")
    protected WebElement applyButton;

    @FindBy(id = "keyPage-form-button")
    protected WebElement proceedButton;

    public NewGrantPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public NewGrantPage clickOnGetGrantNewBtn() {
        clickAction.clickOn(getGrantNewButton);
        return this;
    }

    public NewGrantPage selectSector(String sector) {
        String sectorLocator = "//div[@class='itemname'][text()='%s']";
        String sectorValue = String.format(sectorLocator, sector);
        clickAction.clickOn(By.xpath(sectorValue));
        return this;
    }

    public NewGrantPage selectDevelopmentArea(String option) {
        if (option.equalsIgnoreCase("Capability Development")) {
            clickAction.clickOn(capabilityDevelopmentOption);
        } else if (option.equalsIgnoreCase("International Expansion")) {
            clickAction.clickOn(internationalExpansionOption);
        } else {
            clickAction.clickOn(enhanceTouristsExpOption);
        }
        return this;
    }

    public NewGrantPage selectOverseaPlan(String option) {
        if (option.equalsIgnoreCase("Market Access & Development")) {
            clickAction.clickOn(marketAccessOption);
        } else {
            clickAction.clickOn(marketReadinessOption);
        }
        return this;
    }

    public NewGrantPage clickOnApplyBtn() {
        clickAction.clickOn(applyButton);
        return this;
    }

    public NewGrantPage clickOnProceedButton() {
        clickAction.clickOn(proceedButton);
        return this;
    }
}
