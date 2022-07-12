package core.actions;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class InputActions extends BaseActions implements ElementActions {

    /** Method to input text into text field
     * @param element : WebElement : element input text
     * @param value : String : Text value to enter in field
     */
    public void inputText(WebElement element, String value){
        waitAction.waitForElementActionable(element);
        try {
            element.clear();
        } catch (ElementNotInteractableException error) {
            LOGGER.error(error);
        }
        element.sendKeys(value);
        LOGGER.info("User inputs field with element: " + element + " and value " + value);
    }

    /** Method to input text into text field and press enter
     * @param element : WebElement : element input text
     * @param value : String : Text value to enter in field
     */
    public void inputTextAndPressEnter(WebElement element, String value){
        waitAction.waitForElementActionable(element);
        try {
            element.clear();
        } catch (ElementNotInteractableException error) {
            LOGGER.error(error);
        }
        element.sendKeys(value);
        element.sendKeys(Keys.RETURN);
        LOGGER.info("User inputs field with element: " + element + " and value " + value);
    }
}
