package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "(//a[normalize-space()='Proceed To Checkout'])[1]")
    private WebElement proceedToCheckout;
    @FindBy(linkText = "Place Order")
    private WebElement placeOrder;
    @FindBy(name = "name_on_card")
    private WebElement cardNameField;
    @FindBy(name = "card_number")
    private WebElement cardNumberField;
    @FindBy(name = "cvc")
    private WebElement cvcField;
    @FindBy(name = "expiry_month")
    private WebElement expireMonth;
    @FindBy(name = "expiry_year")
    private WebElement expireYear;
    @FindBy(id = "submit")
    private WebElement confirmOrder;
    @FindBy(xpath = "(//p[normalize-space()='Congratulations! Your order has been confirmed!'])[1]")
    private WebElement orderConfirm;

    public PaymentPage(WebDriver driver) throws InterruptedException {
        this.driver =driver;
        InitPage();
    }

    public void proceedToCheckout() {
        proceedToCheckout.click();
        placeOrder.click();
        cardNameField.sendKeys("Projera Test User");
        cardNumberField.sendKeys("0001000200030004");
        cvcField.sendKeys("123");
        expireMonth.sendKeys("06");
        expireYear.sendKeys("2027");
        confirmOrder.click();

    }
    public boolean isConfirmed(){

        return orderConfirm.isDisplayed();
    }
}
