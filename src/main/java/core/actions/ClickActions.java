package core.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ClickActions extends BaseActions implements ElementActions {

    /**
     * Method to click on an element
     *
     * @param element : WebElement element
     */
    public void clickOn(WebElement element) {
        waitAction.waitUntilElementIsClickable(element);
        element.click();
        LOGGER.info("User clicks On Element: " + element);
    }

    /**
     * Method to click on an element
     *
     * @param locator : WebElement element
     */
    public void clickOn(By locator) {
        waitAction.waitUntilElementIsClickable(locator);
        WebElement element = driver.findElement(locator);
        element.click();
        LOGGER.info("User clicks On Element: " + locator);
    }

    /**
     * Method to forcefully click on an element
     *
     * @param element : WebElement element
     */
    public void clickByJSExecute(WebElement element) {
        waitAction.waitUntilElementIsClickable(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        LOGGER.info("User clicks js execute: " + element);
    }

    /**
     * Method to forcefully click on an element
     *
     * @param element : WebElement element
     */
    public void clickForceFully(WebElement element) {
        try {
            clickOn(element);
        } catch (ElementClickInterceptedException e){
            clickByJSExecute(element);
        }
    }
}
