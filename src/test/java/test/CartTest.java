package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import page.CartPage;

public class CartTest extends BaseTest {
    String testName = "CartTest";

    @BeforeTest
    public void testInitMessage() {
        testInitMessage(testName);
    }

    @Test
    public void addToCartAndVerify() {
        CartPage cartPage = new CartPage(driver);
        cartPage.navigateToProducts();
        cartPage.addToCart();
        Assert.assertTrue(cartPage.isProductInCart(), "Product not added to cart!");
    }

    @AfterTest
    public void testConcludeMessage(){
        testConcludeMessage(testName);
    }
}
