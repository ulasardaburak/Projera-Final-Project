package test;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import page.PaymentPage;

public class PaymentTest extends BaseTest {
    String testName = "PaymentTest";

    @BeforeTest
    public void testInitMessage() {
        testInitMessage(testName);
    }

    @Test

    public void proceedToPayment() {
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.proceedToCheckout();
    }

    @AfterTest
    public void testConcludeMessage(){
        testConcludeMessage(testName);
    }
}
