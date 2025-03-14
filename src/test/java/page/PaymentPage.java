package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        driver.findElement(By.linkText("Proceed To Checkout")).click();

    }
}
