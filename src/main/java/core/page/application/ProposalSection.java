package core.page.application;

import core.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static core.actions.WaitActions.staticWait;

public class ProposalSection extends BasePage {
    WebDriver driver;

    @FindBy(css = "input[id='react-project-title']")
    protected WebElement projectTitleInput;

    @FindBy(css = "input[id='react-project-start_date']")
    protected WebElement startDateInput;

    @FindBy(css = "input[id='react-project-end_date']")
    protected WebElement endDateInput;

    @FindBy(css = "textarea[id='react-project-description']")
    protected WebElement projectDescriptionInput;

    @FindBy(css = "[id='react-select-project-activity--value'] .Select-placeholder")
    protected WebElement searchActivity;

    @FindBy(css = "[id='react-select-project-activity--value'] input")
    protected WebElement searchActivityInput;

    @FindBy(css = "[id='react-select-project-primary_market--value'] .Select-placeholder")
    protected WebElement searchMarket;

    @FindBy(css = "[id='react-select-project-primary_market--value'] input")
    protected WebElement searchMarketInput;

    String firstTimeExpand = "//input[@name='react-project-is_first_time_expand']//../span[text()='%s']";


    public ProposalSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ProposalSection inputProjectTitle(String value) {
        inputAction.inputText(projectTitleInput, value);
        return this;
    }

    public ProposalSection inputStartDate(String value) {
        inputAction.inputText(startDateInput, value);
        return this;
    }

    public ProposalSection inputEndDate(String value) {
        inputAction.inputText(endDateInput, value);
        return this;
    }

    public ProposalSection inputProjectDescription(String value) {
        inputAction.inputText(projectDescriptionInput, value);
        return this;
    }

    public ProposalSection selectActivity(String value) {
        clickAction.clickOn(searchActivity);
        inputAction.inputTextAndPressEnter(searchActivityInput, value);
        return this;
    }

    public ProposalSection selectMarket(String value) {
        clickAction.clickOn(searchMarket);
        inputAction.inputTextAndPressEnter(searchMarketInput, value);
        return this;
    }

    public ProposalSection selectFirstTimeExpand(String value) {
        clickAction.clickOn(By.xpath(String.format(firstTimeExpand, value)));
        return this;
    }
}
