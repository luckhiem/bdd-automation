package core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.constants.Path.BASE_PATH;

public class BusinessGrantPortalPage extends BasePage {
    WebDriver driver;

    @FindBy(id = "login-button")
    protected WebElement loginButton;


    public BusinessGrantPortalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public BusinessGrantPortalPage clickOnLogin() {
        clickAction.clickOn(loginButton);
        return this;
    }
}
