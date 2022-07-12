package steps;

import core.driver.DriverManager;
import core.page.BusinessGrantPortalPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class BusinessGrantPortalSteps {
    WebDriver driver = DriverManager.getDriver();
    BusinessGrantPortalPage businessGrantPortalPage = new BusinessGrantPortalPage(driver);

    @And("I go to login with CorpPass page")
    public void iGoToLoginWithCorpPassPage() {
        businessGrantPortalPage.clickOnLogin();
    }
}
