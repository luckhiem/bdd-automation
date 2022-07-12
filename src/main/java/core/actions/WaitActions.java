package core.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WaitActions extends BaseActions implements ElementActions {

    /**
     * Method waits until element is visible
     * @param timeout : int : timeout
     */
    public static void staticWait(int timeout) throws InterruptedException {
        Thread.sleep(timeout);
        LOGGER.info("Wait with timeout " + timeout);
    }

    /**
     * Method waits until element is visible
     * @param element : WebElement : element to wait
     */
    public void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        LOGGER.info("Wait until element: " + element + "is visible");
    }

    /**
     * Method waits until element is visible
     * @param element : WebElement : element to wait
     */
    public void waitUntilLocatorVisible(By element) throws InterruptedException {
        staticWait(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        LOGGER.info("Wait until element: " + element + "is visible");
    }

    /**
     * Method waits until element is clickable
     * @param element : WebElement : element to wait
     */
    public void waitUntilElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        LOGGER.info("Wait until element: " + element + "is clickable");
    }

    /**
     * Method waits until element is clickable
     * @param locator : WebElement : element to wait
     */
    public void waitUntilElementIsClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        LOGGER.info("Wait until element: " + locator + "is clickable");
    }

    /**
     * Method waits until element able to take action
     * @param element : WebElement : element to wait
     */
    public void waitForElementActionable(WebElement element) {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOf(element),
                ExpectedConditions.elementToBeClickable(element),
                ExpectedConditions.elementToBeSelected(element)));
        LOGGER.info("Wait until element: " + element + "is actionable");
    }

    /**
     * Method waits until element able to take action
     * @param element : WebElement : element to wait
     */
    protected WebElement fluentWait(WebElement element, int timeOut, int polling) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(polling))
                .ignoring(NoSuchElementException.class)
                .withTimeout((Duration.ofSeconds(timeOut)));
        WebElement el = wait.until(driver -> element);
        LOGGER.info("Fluent wait is success waiting for " + el);
        return el;
    }

}
