package test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import page.HomePage;

public class SignUpTest extends BaseTest {
    String testName = "SignUpTest";

    @BeforeTest
    public void testInitMessage() {
        testInitMessage(testName);
    }

    @Test
    public void signUpAndLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToSignup();
        homePage.signUp();
        homePage.completeSignup();
        homePage.logout();
        homePage.navigateToSignup();
        homePage.login("testuser1@projera.com", "test1234");
        homePage.logout();
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed(), "Login failed!");
    }

    @AfterTest
    public void testConcludeMessage(){
        testConcludeMessage(testName);
    }
}
