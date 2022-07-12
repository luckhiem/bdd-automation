package core.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AssertionActions extends BaseActions implements ElementActions {

    /**
     * Method to get page title
     *
     * @return String
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Method to get element title
     *
     * @param element : WebElement element
     * @return String
     */
    public String getElementText(WebElement element) {
        waitAction.waitUntilElementVisible(element);
        String result = element.getText();
        LOGGER.info("Element text is returned: " + result);
        return result;
    }

    /**
     * Method to get element status - displayed?
     *
     * @param element : WebElement element
     * @return Boolean
     */
    public boolean isDisplayed(WebElement element) {
        element = wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    /**
     * Method to get attribute value
     *
     * @param element : WebElement element
     * @return String
     * @return String
     */
    public String getElementAttribute(WebElement element, String attributeName) {
        element = wait.until(ExpectedConditions.visibilityOf(element));
        String result = element.getAttribute(attributeName);
        LOGGER.info("Element attribute " + attributeName + " is returned: " + result);
        return result;
    }
}
