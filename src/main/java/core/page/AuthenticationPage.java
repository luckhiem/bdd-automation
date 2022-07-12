package core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.constants.Path.BASE_PATH;

public class AuthenticationPage extends BasePage {
    WebDriver driver;

    @FindBy(css = ".visible-md #signInFormUsername")
    protected WebElement userNameInput;

    @FindBy(css = ".visible-md #signInFormPassword")
    protected WebElement passwordInput;

    @FindBy(css = ".visible-md [name=signInSubmitButton]")
    protected WebElement signInButton;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AuthenticationPage goToAuthenticationPage() {
        navigationAction.navigateTo(BASE_PATH);
        return this;
    }

    public AuthenticationPage inputUsername(String value) {
        inputAction.inputText(userNameInput, value);
        return this;
    }

    public AuthenticationPage inputPassword(String value) {
        inputAction.inputText(passwordInput, value);
        return this;
    }

    public AuthenticationPage clickOnSignInBtn() {
        clickAction.clickOn(signInButton);
        return this;
    }
}
