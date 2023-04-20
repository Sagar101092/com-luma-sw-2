package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class RegisterTest extends BaseTest {
    String baseurl = "https://magento.softwaretestingboard.com/";
    String email;

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
    public void verifyThatSignInPageDisplay() {
        String exceptedMessage = "Create New Customer Account";
        // Element to click on create account link
        driver.findElement(By.linkText("Create an Account")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//span[@class='base']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to click on create account link", exceptedMessage, actualMessage);

    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        String exceptedMessage = "Thank you for registering with Main Website Store.";
        String exceptedMessage1 = "You are signed out";

        String name = UUID.randomUUID().toString();
        email = name + "@gmail.com";
        // Element to click on create account link
        driver.findElement(By.linkText("Create an Account")).click();
        //Element to send first name
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Prime");
        //Element to send first name
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Testing");
        //Element to click Sign Up for Newsletter chechbox
        driver.findElement(By.xpath("//input[@name='is_subscribed']")).click();
        // Element to Enter Email
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(email);
        // Element to Enter Password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@123");
        // Element to Confirm Password
        driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("Admin@123");
        //Element to Click on Create an Account button
        driver.findElement(By.xpath("//button[@class='action submit primary']")).click();


        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//div[@data-ui-id='message-success']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to Register", exceptedMessage, actualMessage);

        //Element to Click on down aero near Welcome
        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();

        // Element Click on Sign Out link
        driver.findElement(By.xpath("(//li[@class='authorization-link'][normalize-space(.)='Sign Out'])[1]")).click();

        // Element to get message
        WebElement getMessage1 = driver.findElement(By.xpath("//*[@ data-ui-id='page-title-wrapper']"));
        String actualMessage1 = getMessage1.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to Register", exceptedMessage1, actualMessage1);


    }


}
