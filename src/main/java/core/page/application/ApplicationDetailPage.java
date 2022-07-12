package core.page.application;

import core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationDetailPage extends BasePage {
    WebDriver driver;


    @FindBy(id = "save-btn")
    protected WebElement saveButton;

    @FindBy(id = "next-btn")
    protected WebElement nextButton;

    @FindBy(id = "review-btn")
    protected WebElement reviewButton;

    @FindBy(id = "submit-btn")
    protected WebElement submitButton;

    @FindBy(css = ".growl-title")
    protected WebElement successNoty;

    @FindBy(css = ".bgp-btn-group")
    protected WebElement bgpButtonGroup;

    public ApplicationDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ApplicationDetailPage selectMenu(String menu) {
        String menuLocator = "//span[@class='menu-text'][text()='%s']";
        clickAction.clickOn(By.xpath(String.format(menuLocator, menu)));
        waitAction.waitUntilElementVisible(bgpButtonGroup);
        return this;
    }

    public EligibilitySection getEligibilitySection() {
        return new EligibilitySection(driver);
    }

    public ContactDetailSection getContactDetailSection() {
        return new ContactDetailSection(driver);
    }

    public ProposalSection getProposalSection() {
        return new ProposalSection(driver);
    }

    public BusinessImpactSection getBusinessImpactSection() {
        return new BusinessImpactSection(driver);
    }

    public CostSection getCostSection() {
        return new CostSection(driver);
    }

    public DeclareAndReviewSection getDeclareAndReviewSection() {
        return new DeclareAndReviewSection(driver);
    }

    public CompanyProfileSection getCompanyProfileSection() {
        return new CompanyProfileSection(driver);
    }

    public ApplicationDetailPage clickOnSaveButton() {
        clickAction.clickOn(saveButton);
        return this;
    }

    public ApplicationDetailPage clickOnNextButton() {
        clickAction.clickOn(nextButton);
        return this;
    }

    public ApplicationDetailPage clickOnReviewButton() {
        clickAction.clickForceFully(reviewButton);
        return this;
    }

    public ApplicationDetailPage clickOnSubmitButton() {
        clickAction.clickOn(submitButton);
        return this;
    }

    public boolean getSuccessMessageIsDisplayed() {
        return assertAction.isDisplayed(successNoty);
    }
}
