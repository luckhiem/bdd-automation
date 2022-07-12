package core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CorpPassPage extends BasePage {
    WebDriver driver;

    @FindBy(id = "entityId")
    protected WebElement entityInput;

    @FindBy(id = "userId")
    protected WebElement userIDInput;

    @FindBy(id = "userRole")
    protected WebElement userRoleInput;

    @FindBy(id = "userFullName")
    protected WebElement userFullNameInput;

    @FindBy(xpath = "//button[text()='Log In']")
    protected WebElement loginButton;


    public CorpPassPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CorpPassPage inputEntityID(String value) {
        inputAction.inputText(entityInput, value);
        return this;
    }

    public CorpPassPage inputUserID(String value) {
        inputAction.inputText(userIDInput, value);
        return this;
    }

    public CorpPassPage inputUserRole(String value) {
        inputAction.inputText(userRoleInput, value);
        return this;
    }

    public CorpPassPage inputFullName(String value) {
        inputAction.inputText(userFullNameInput, value);
        return this;
    }

    public CorpPassPage clickOnLoginButton() {
        clickAction.clickOn(loginButton);
        return this;
    }
}
