package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import page.CartPage;
import page.HomePage;
import page.PaymentPage;

public class PaymentTest extends BaseTest {
    String testName = "PaymentTest";

    @BeforeTest
    public void testInitMessage() {
        testInitMessage(testName);
    }

    @Test

    public void proceedToPayment() throws InterruptedException {
        //Login steps
        HomePage homePage = new HomePage(driver);
        homePage.navigateToSignup();
        homePage.login("testuser42@hitchhikers.com", "test1234");
        Thread.sleep(1000);
        //Add to Cart steps
        CartPage cartPage = new CartPage(driver);
        cartPage.navigateToProducts();
        cartPage.addToCart();
        Thread.sleep(1000);
        //Payment steps
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.proceedToCheckout();
        Thread.sleep(1000);
        Assert.assertTrue(paymentPage.isConfirmed(), "Payment failed");
    }


    @AfterTest
    public void testConcludeMessage(){
        testConcludeMessage(testName);
    }
}
