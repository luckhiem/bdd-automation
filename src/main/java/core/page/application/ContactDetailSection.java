package core.page.application;

import core.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.actions.WaitActions.staticWait;

public class ContactDetailSection extends BasePage {
    WebDriver driver;

    @FindBy(id = "react-contact_info-name")
    protected WebElement nameInput;

    @FindBy(id = "react-contact_info-designation")
    protected WebElement jobTitleInput;

    @FindBy(id = "react-contact_info-phone")
    protected WebElement phoneNumberInput;

    @FindBy(css = "input[id=react-contact_info-correspondence_address-postal]")
    protected WebElement postCodeInput;

    @FindBy(id = "react-contact_info-primary_email")
    protected WebElement emailInput;

    @FindBy(id = "react-contact_info-copied")
    protected WebElement sameMainContactCheckbox;

    @FindBy(id = "react-contact_info-correspondence_address-copied")
    protected WebElement sameMallingAddressCheckbox;

    @FindBy(css = "input[id='react-contact_info-offeree_name']")
    protected WebElement offerNameInput;

    @FindBy(css = "input[id='react-contact_info-offeree_designation']")
    protected WebElement offerDesignationInput;

    @FindBy(css = "input[id='react-contact_info-offeree_email']")
    protected WebElement offerEmailInput;

    public ContactDetailSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ContactDetailSection inputName(String value) {
        inputAction.inputText(nameInput, value);
        return this;
    }

    public ContactDetailSection inputJobTitle(String value) {
        inputAction.inputText(jobTitleInput, value);
        return this;
    }

    public ContactDetailSection inputPhoneNumber(String value) {
        inputAction.inputText(phoneNumberInput, value);
        return this;
    }

    public ContactDetailSection inputEmail(String value) {
        inputAction.inputText(emailInput, value);
        return this;
    }

    public ContactDetailSection inputPostCode(String value) {
        inputAction.inputText(postCodeInput, value);
        return this;
    }

    public ContactDetailSection checkOnSameMainContact() {
        clickAction.clickOn(sameMainContactCheckbox);
        return this;
    }

    public ContactDetailSection checkOnSameMallingAddress() {
        clickAction.clickOn(sameMallingAddressCheckbox);
        return this;
    }

    public String getOfferNameValue() {
        return assertAction.getElementAttribute(offerNameInput, "value");
    }

    public String getOfferDesignationValue() {
        return assertAction.getElementAttribute(offerDesignationInput, "value");
    }

    public String getOfferEmailValue() {
        return assertAction.getElementAttribute(offerEmailInput, "value");
    }
}
