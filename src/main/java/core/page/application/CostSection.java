package core.page.application;

import core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.actions.WaitActions.staticWait;

public class CostSection extends BasePage {
    WebDriver driver;

    @FindBy(css = "div[id='react-project_cost-vendors-accordion-header']")
    protected WebElement thirdPartyVendor;

    @FindBy(css = "button[id='react-project_cost-vendors-add-item']")
    protected WebElement costVendorAddButton;

    @FindBy(css = "input[id='react-project_cost-vendors-0-vendor_name']")
    protected WebElement vendorNameInput;

    @FindBy(css = "input[id='react-project_cost-vendors-0-attachments-input']")
    protected WebElement documentInput;

    @FindBy(id = "react-project_cost-vendors-0-amount_in_billing_currency")
    protected WebElement amountBilling;

    String vendorRegistered = "//input[@name='react-project_cost-vendors-0-local_vendor']//../span[text()='%s']";

    public CostSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CostSection clickOnThirdPartyVendor() {
        clickAction.clickOn(thirdPartyVendor);
        return this;
    }

    public CostSection clickOnAddItemCostVendor() {
        clickAction.clickOn(costVendorAddButton);
        return this;
    }

    public CostSection selectVendorRegistered(String value) {
        clickAction.clickOn(By.xpath(String.format(vendorRegistered, value)));
        return this;
    }

    public CostSection inputVendorName(String value) {
        inputAction.inputText(vendorNameInput, value);
        return this;
    }

    public CostSection addSupportingDocument(String filePath) throws InterruptedException {
        staticWait(2000);
        inputAction.inputText(documentInput, filePath);
        staticWait(2000);
        return this;
    }

    public CostSection inputVendorAmountBilling(String value) {
        inputAction.inputText(amountBilling, value);
        return this;
    }
}
