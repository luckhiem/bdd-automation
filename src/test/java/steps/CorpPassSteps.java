package steps;

import core.driver.DriverManager;
import core.model.CorpUser;
import core.page.CorpPassPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class CorpPassSteps {
    WebDriver driver = DriverManager.getDriver();
    CorpPassPage corpPassPage = new CorpPassPage(driver);

    @And("I login with manual corp")
    public void iLoginWithManualCorp() throws InterruptedException {
        CorpUser user = new CorpUser("BGPQETECH", "S1234567A", "Acceptor", "Tan Ah Kow");
        corpPassPage
                .inputEntityID(user.getEntityID())
                .inputUserID(user.getUserID())
                .inputUserRole(user.getRole())
                .inputFullName(user.getFullName())
                .clickOnLoginButton();
    }
}
