package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    @FindBy(xpath = "(//a[@href='/products'])[1]")
    private WebElement productsButton;
    @FindBy(xpath = "(//input[@id='search_product'])[1]")
    private WebElement searchField;
    @FindBy(xpath = "(//button[@id='submit_search'])[1]")
    private WebElement submitSearch;
    @FindBy(xpath = "(//a[@class='btn btn-default add-to-cart'][normalize-space()='Add to cart'])[1]")
    private WebElement addToCartButton;
    @FindBy(xpath = "(//u[normalize-space()='View Cart'])[1]")
    private WebElement viewCart;
    @FindBy(xpath = "//td[@class='cart_description']")
    private WebElement cartDescription;


    public CartPage(WebDriver driver) throws InterruptedException {
        this.driver =driver;
        InitPage();
    }

    public void navigateToProducts() {
        productsButton.click();
    }
    public void addToCart() {
        addToCartButton.click();
        viewCart.click();
    }

    public boolean isProductInCart() {
        return cartDescription.isDisplayed();
    }
}
