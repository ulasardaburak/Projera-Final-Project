package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    public void testInitMessage(String testName){
        System.out.println("Starting " + testName);
    }
    public void testConcludeMessage(String testName){
        System.out.println(testName + " completed...");
    }

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
