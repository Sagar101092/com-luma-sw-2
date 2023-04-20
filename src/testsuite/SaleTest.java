package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseurl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        // Open browser and launch base url
        openBrowser(baseurl);
    }

    @After
    public void terminateBrowser() {
        // close browser method
        closeBrowser();
    }

    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomens() {
        // Element of ‘Sale’ Menu tab
        driver.findElement(By.xpath("//a[@class='level-top ui-corner-all']//span[text()='Sale']")).click();
        // Element Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.xpath("(//a[@href='https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html'])[2]")).click();
        // Element to get all product list
        List<WebElement> allProductList = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        for (int i = 1; i <= allProductList.size(); i++) {
            // Printing all product name
            System.out.println(driver.findElement(By.xpath("(//a[@class='product-item-link'])[" + i + "]")).getText());
        }
        // Verifying number of products
        Assert.assertEquals("Total product is not 12", 12, allProductList.size());
    }

}
