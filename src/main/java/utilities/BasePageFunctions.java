package utilities;

import org.openqa.selenium.*;

/**
 * this class represents the main functions of all pages
 *
 * @author Shlomi
 */


public abstract class BasePageFunctions {

    protected WebDriver driver;

    // constructor
    public BasePageFunctions(WebDriver driver) {
        this.driver = driver;
    }

    // get webDriver
    public WebDriver getDriver() {
        return this.driver;
    }

    // get webElement
    public WebElement getWebElement(String elem) {
        return getDriver().findElement(By.xpath(elem));
    }

    // navigate to URL
    public Boolean navigateToURL(String URL) {
        try {
            getDriver().navigate().to(URL);
            return true;
        } catch (Exception e) {
            System.out.println("Site was not loaded");
            return false;
        }
    }

}
