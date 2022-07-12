package steps;

import core.driver.DriverManager;
import core.page.NewGrantPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class NewGrantSteps {
    WebDriver driver = DriverManager.getDriver();
    NewGrantPage newGrantPage = new NewGrantPage(driver);


    @Given("I go to get new grant page")
    public void iGoToGetNewGrantPage() {
        newGrantPage.clickOnGetGrantNewBtn();
    }

    @And("I select sector {string}")
    public void iSelectSector(String sector) {
        newGrantPage.selectSector(sector);
    }

    @And("I select the development area {string}")
    public void iSelectDevelopmentArea(String option) {
        newGrantPage.selectDevelopmentArea(option);
    }

    @And("I select the oversea plan {string}")
    public void iSelectTheOverseaPlan(String option) {
        newGrantPage.selectOverseaPlan(option);
    }

    @And("I click on apply button")
    public void iClickOnApplyButton() throws InterruptedException {
        newGrantPage.clickOnApplyBtn();
    }

    @And("I click on proceed button")
    public void iClickOnProceedButton() {
        newGrantPage.clickOnProceedButton();
    }
}
