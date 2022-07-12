package core.page.application;

import core.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessImpactSection extends BasePage {
    WebDriver driver;

    @FindBy(css = "input[id='react-project_impact-fy_end_date_0']")
    protected WebElement fyEndDateInput;

    @FindBy(css = "input[id='react-project_impact-overseas_sales_0']")
    protected WebElement overseaSale_0;

    @FindBy(css = "input[id='react-project_impact-overseas_sales_1']")
    protected WebElement overseaSale_1;

    @FindBy(css = "input[id='react-project_impact-overseas_sales_2']")
    protected WebElement overseaSale_2;

    @FindBy(css = "input[id='react-project_impact-overseas_sales_3']")
    protected WebElement overseaSale_3;

    @FindBy(css = "input[id='react-project_impact-overseas_investments_0']")
    protected WebElement overseaInvestment_0;

    @FindBy(css = "input[id='react-project_impact-overseas_investments_1']")
    protected WebElement overseaInvestment_1;

    @FindBy(css = "input[id='react-project_impact-overseas_investments_2']")
    protected WebElement overseaInvestment_2;

    @FindBy(css = "input[id='react-project_impact-overseas_investments_3']")
    protected WebElement overseaInvestment_3;

    @FindBy(css = "textarea[id='react-project_impact-rationale_remarks']")
    protected WebElement projectImpactReasonableInput;

    @FindBy(css = "textarea[id='react-project_impact-benefits_remarks']")
    protected WebElement projectImpactBenefitInput;

    public BusinessImpactSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public BusinessImpactSection inputFYEndDate(String value) {
        inputAction.inputText(fyEndDateInput, value);
        return this;
    }

    public BusinessImpactSection inputOverseaSale(String total0, String total1, String total2, String total3) {
        inputAction.inputText(overseaSale_0, total0);
        inputAction.inputText(overseaSale_1, total1);
        inputAction.inputText(overseaSale_2, total2);
        inputAction.inputText(overseaSale_3, total3);
        return this;
    }

    public BusinessImpactSection inputOverseaInvestment(String total0, String total1, String total2, String total3) {
        inputAction.inputText(overseaInvestment_0, total0);
        inputAction.inputText(overseaInvestment_1, total1);
        inputAction.inputText(overseaInvestment_2, total2);
        inputAction.inputText(overseaInvestment_3, total3);
        return this;
    }

    public BusinessImpactSection inputProjectImpactReasonable(String value) {
        inputAction.inputText(projectImpactReasonableInput, value);
        return this;
    }

    public BusinessImpactSection inputProjectImpactBenefitInput(String value) {
        inputAction.inputText(projectImpactBenefitInput, value);
        return this;
    }
}
