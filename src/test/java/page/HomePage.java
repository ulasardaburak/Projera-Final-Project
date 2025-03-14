package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(linkText = "Signup / Login")
    private WebElement signupLoginLink;

    @FindBy(name = "name")
    private WebElement nameField;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailField;
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(id = "id_gender1")
    private WebElement genderRadio;
    @FindBy(xpath = "(//input[@id='name'])[1]")
    private WebElement signUpName;
    @FindBy(xpath = "(//input[@id='email'])[1]")
    private WebElement signUpEmail;
    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "(//input[@id='first_name'])[1]")
    private WebElement firstName;
    @FindBy(xpath = "(//input[@id='last_name'])[1]")
    private WebElement lastName;
    @FindBy(xpath = "(//input[@id='address1'])[1]")
    private WebElement adressField;
    @FindBy(xpath = "(//input[@id='state'])[1]")
    private WebElement stateField;
    @FindBy(xpath = "(//input[@id='city'])[1]")
    private WebElement cityField;
    @FindBy(xpath = "(//input[@id='zipcode'])[1]")
    private WebElement zipcodeField;
    @FindBy(xpath = "(//input[@id='mobile_number'])[1]")
    private WebElement mobileNoField;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(linkText = "Continue")
    private WebElement continueButton;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement loginEmailField;
    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement loginPasswordField;
    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    public HomePage(WebDriver driver) {
        this.driver =driver;
        InitPage();
    }

    public void navigateToSignup() {
        signupLoginLink.click();
    }
    public void navigateToLogIn() {
        signupLoginLink.click();
    }

    public void signUp() {
        nameField.sendKeys("Marvin Test User");
        emailField.sendKeys("testuser42@hitchhikers.com");
        signupButton.click();
    }

    public void completeSignup() {
        genderRadio.click();
        passwordField.sendKeys("test1234");
        firstName.sendKeys("Marvin");
        lastName.sendKeys("Test User");
        adressField.sendKeys("Heart of Gold");
        stateField.sendKeys("Türkiye");
        cityField.sendKeys("İzmir");
        zipcodeField.sendKeys("35500");
        mobileNoField.sendKeys("+905005005050");

        createAccountButton.click();
        continueButton.click();
    }

    public void logout() {
        logoutLink.click();
    }

    public void login(String email, String password) {
        loginEmailField.sendKeys(email);
        loginPasswordField.sendKeys(password);
        loginButton.click();
    }

    public boolean isLoggedIn(){
        return logoutLink.isDisplayed();
    }
}
