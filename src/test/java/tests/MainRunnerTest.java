package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.InputStream;
import java.util.Properties;

/**
 * this class represents the test runner
 *
 * @author Shlomi
 */

public class MainRunnerTest extends BaseTest {

    private String siteURL;
    private String tableString;
    private int searchColumnInt;
    private String searchTextString;
    private int returnColumnTextString;
    private String expectedTextString;

    @Test(priority = 1, description = "table test")
    public void assignmentXpathTest() {
        getProperty("xpathConfig.properties");
        Assert.assertTrue(mainPage.getWebSite(siteURL), "site was not loaded");
        WebElement table = mainPage.getWebElem(tableString);
        Assert.assertTrue(mainPage.verifyTableCellText(table, searchColumnInt, searchTextString, returnColumnTextString, expectedTextString), " search was not performed");
    }

    @Test(priority = 2, description = "table test")
    public void assignmentTextTest() {
        getProperty("config.properties");
        Assert.assertTrue(mainPage.getWebSite(siteURL), "site was not loaded");
        WebElement table = mainPage.getWebElem(tableString);
        Assert.assertTrue(mainPage.verifyTableCellText(table, searchColumnInt, searchTextString, returnColumnTextString, expectedTextString), " search was not performed");
    }

    public void getProperty(String property) {
        try {
            // load properties
            Properties props = new Properties();
            // get the config properties file
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(property);
            props.load(inputStream);
            siteURL = props.getProperty("siteURL");
            tableString = props.getProperty("table");
            searchColumnInt = Integer.valueOf(props.getProperty("searchColumn"));
            searchTextString = props.getProperty("searchText");
            returnColumnTextString = Integer.valueOf(props.getProperty("returnColumnText"));
            expectedTextString = props.getProperty("expectedText");
        } catch (Exception e) {
            System.out.println("There was problem load the properties file");
        }
    }

}
