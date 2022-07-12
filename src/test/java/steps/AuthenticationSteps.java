package steps;

import core.driver.DriverManager;
import core.page.AuthenticationPage;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class AuthenticationSteps {
    WebDriver driver = DriverManager.getDriver();
    AuthenticationPage authenticationPage = new AuthenticationPage(driver);

    @Given("I login to business grant portal")
    public void iLoginToBusinessGrantPortal() {
        authenticationPage
                .goToAuthenticationPage()
                .inputUsername("public")
                .inputPassword("Let$BeC001")
                .clickOnSignInBtn();
    }
}
