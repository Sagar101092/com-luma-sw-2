package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends RegisterTest {
    String baseurl = "https://magento.softwaretestingboard.com/";
    // String email;

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
    public void userShouldLoginSuccessfullyWithValid() throws InterruptedException {
        String exceptedMessage = "Welcome";
        userSholdRegisterAccountSuccessfully();
        // Element to click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Element to Enter valid Email
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(super.email);
        // Element to Enter valid password
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Admin@123");
        // Element to click  Sign In button
        driver.findElement(By.xpath("//*[@id='send2']")).click();
        Thread.sleep(1000);
        //driver.wait(Duration.ofSeconds(5));
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("(//span[@class='logged-in'])[1]"));
        String actualMessage = getMessage.getText();
        String[] acmsg = actualMessage.split(",");
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to Register", exceptedMessage, acmsg[0]);

    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        String exceptedMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        // Element to click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Element to Enter valid Email
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("admin123456@gmail.com");
        // Element to Enter invalid password
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Admin123");
        // Element to click  Sign In button
        driver.findElement(By.xpath("//*[@id='send2']")).click();
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("//div[@class='message-error error message']"));
        String actualMessage = getMessage.getText();
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to Register", exceptedMessage, actualMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {
        String exceptedMessage = "Welcome";
        String exceptedMessage1 = "You are signed out";
        userSholdRegisterAccountSuccessfully();
        // Element to click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Element to Enter valid Email
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys(super.email);
        // Element to Enter valid password
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("Admin@123");
        // Element to click  Sign In button
        driver.findElement(By.xpath("//*[@id='send2']")).click();
        Thread.sleep(1000);
        //driver.wait(Duration.ofSeconds(5));
        // Element to get message
        WebElement getMessage = driver.findElement(By.xpath("(//span[@class='logged-in'])[1]"));
        String actualMessage = getMessage.getText();
        String[] acmsg = actualMessage.split(",");
        // verification of actual message and excepted message
        Assert.assertEquals("Fail to Register", exceptedMessage, acmsg[0]);
        Thread.sleep(1000);
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
