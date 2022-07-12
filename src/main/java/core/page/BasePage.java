package core.page;

import core.actions.ElementActions;
import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage implements ElementActions {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = DriverManager.getDriver();
        initElements(driver, this);
    }

    public <T> T redirect(Class<T> pageClass) throws NoSuchMethodException {
        try {
            Class[] parameterType = new Class[1];
            parameterType[0] = WebDriver.class;
            return pageClass.getDeclaredConstructor(parameterType).newInstance(DriverManager.getDriver());
        } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
