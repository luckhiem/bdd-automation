package core.actions;

public class NavigationActions extends BaseActions implements ElementActions {
    private String oldWindow = null;
    private String lastWinHandle;

    /**
     * Method to open link
     *
     * @param url : String : URL for navigation
     */
    public void navigateTo(String url) {
        driver.get(url);
        LOGGER.info("Navigate to page " + url);
    }

    /**
     * Method to navigate back & forward
     *
     * @param direction : String : Navigate to forward or backward
     */
    public void navigate(String direction) {
        if (direction.equals("back")) driver.navigate().back();
        else driver.navigate().forward();
    }

    /**
     * Method to maximize browser
     */
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    /**
     * Method to switch to new window
     */
    public void switchToNewWindow() {
        oldWindow = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            lastWinHandle = winHandle;
        }
        driver.switchTo().window(lastWinHandle);
    }

    /**
     * Method to switch to old window
     */
    public void switchToOldWindow() {
        driver.switchTo().window(oldWindow);
    }

    /**
     * Method to switch to window by title
     *
     * @param windowTitle : String : Name of window title to switch
     */
    public void switchToWindowByTitle(String windowTitle) throws Exception {
        oldWindow = driver.getWindowHandle();
        boolean winFound = false;
        for (String winHandle : driver.getWindowHandles()) {
            String str = driver.switchTo().window(winHandle).getTitle();
            if (str.equals(windowTitle)) {
                winFound = true;
                break;
            }
        }
        if (!winFound)
            throw new Exception("Window having title " + windowTitle + " not found");
    }

    /**
     * Method to close new window
     */
    public void closeNewWindow() {
        driver.close();
    }

    /**
     * method to switch to default content
     */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
