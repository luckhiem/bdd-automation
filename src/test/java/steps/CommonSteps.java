package steps;

import core.driver.DriverManager;
import core.page.application.ApplicationDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static core.actions.WaitActions.staticWait;

public class CommonSteps {
    WebDriver driver = DriverManager.getDriver();
    ApplicationDetailPage applicationDetailPage = new ApplicationDetailPage(driver);

    @And("I click on save button")
    public void iClickOnSaveButton() {
        applicationDetailPage.clickOnSaveButton();
    }

    @And("I click on next button")
    public void iClickOnNextButton() {
        applicationDetailPage.clickOnNextButton();
    }

    @Then("I should see the success message is displayed")
    public void iShouldSeeTheSuccessMessageIsDisplayed() {
        boolean state = applicationDetailPage.getSuccessMessageIsDisplayed();
        Assert.assertTrue(state);
    }

    @And("I wait for a while {string}")
    public void iClickOnSaveButton(String timeout) throws InterruptedException {
        staticWait(Integer.parseInt(timeout));
    }

    @And("I click on review button")
    public void iClickOnReviewButton() {
        applicationDetailPage.clickOnReviewButton();
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        applicationDetailPage.clickOnSubmitButton();
    }
}
