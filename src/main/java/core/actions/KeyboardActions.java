package core.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions extends BaseActions implements ElementActions {

    /**
     * Method to double-click to an element by using keyboard action
     * @param element : WebElement : element to interact
     */
    protected void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
        LOGGER.info("Double Click element: " + element);
    }

    /**
     * Method to move mouse pointer to an element by using keyboard action
     * @param element : WebElement : element to interact
     */
    protected void moveMousePointerTo(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        LOGGER.info("Move your mouse pointer to element: " + element);
    }

    /**
     * Method to drag element from and drop to another element by using keyboard action
     * @param from : WebElement : element from
     * @param to : WebElement : element to
     */
    protected void dragFromAndDropTo(WebElement from, WebElement to) {
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(from)
                .moveToElement(to)
                .release(to)
                .build();
        dragAndDrop.perform();
        LOGGER.info("Drag from :" + from + " then drop to: " + to);
    }
}
