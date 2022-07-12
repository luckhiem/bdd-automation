package core.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {
    WebDriver driver;

    @FindBy(css = "#dashboard-menubox-app-apply-grant .dashboard-action-title")
    protected WebElement getGrantNewButton;


    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public DashboardPage clickOnGetGrantNewBtn(){
        clickAction.clickOn(getGrantNewButton);
        return this;
    }
}
