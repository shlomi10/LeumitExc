package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.BasePageFunctions;

/**
 * this class represents the main page
 *
 * @author Shlomi
 */

public class MainPage extends BasePageFunctions {

    // constructor
    public MainPage(WebDriver driver) {
        super(driver);
    }

    String columnToSearchTemplate = "//table[@id='customers']//tr[.//td[contains(text(),'%s')]]//td[%d]";
    String indexSearchTemplate = ".//td[%d]";

    // navigate to the site
    public Boolean getWebSite(String site) {
        return navigateToURL(site);
    }

    // navigate to the site
    public WebElement getWebElem(String elem) {
        return getWebElement(elem);
    }

    public String getTableCellText(WebElement table, String searchText, int returnColumnText){
        try {
            String cell = String.format(columnToSearchTemplate, searchText, returnColumnText);
            return table.findElement(By.xpath(cell)).getText().trim();
        } catch ( Exception e){
            System.out.println("Failed to find cell by given search text and return column text");
            return null;
        }
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText){
        String actualContent = null;
        if (searchColumn == 2) {
            actualContent = getTableCellTextByXpath(table, searchColumn, searchText);
        } else {
            actualContent = getTableCellText(table, searchText, returnColumnText);
        }
        if (actualContent == null) {
            System.out.println("Failed to find cell by given parameters");
            return false;
        }
        return expectedText.contains(actualContent);
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String rowXpath) {
        try {
            String indexXpath = String.format(indexSearchTemplate, searchColumn);
            WebElement rowElement =  table.findElement(By.xpath(rowXpath));
            WebElement cellElement = rowElement.findElement(By.xpath(indexXpath));
            String text = cellElement.getText().trim();
            return text;
        } catch (Exception e){
            System.out.println("Failed to find cell by given search xpath and return column index");
            return null;
        }
    }

}
