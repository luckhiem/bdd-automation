package core.page.application;

import core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyProfileSection extends BasePage {
    WebDriver driver;

    @FindBy(id = "react-declaration-info_truthfulness_check")
    protected WebElement infoTruthfulness;

    @FindBy(css = ".card h3")
    protected WebElement submitSuccessMessage;

    public CompanyProfileSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CompanyProfileSection checkOnInfoTruthfulness() {
        clickAction.clickOn(infoTruthfulness);
        return this;
    }

    public String getSubmitSuccessMessage() {
        return assertAction.getElementText(submitSuccessMessage);
    }
}
