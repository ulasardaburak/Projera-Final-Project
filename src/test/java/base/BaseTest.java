package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class BaseTest {
    protected WebDriver driver;
    protected  ExtentReports extent;
    protected  ExtentTest extentTest;
    protected  ExtentSparkReporter htmlReporter;



    public void testInitMessage(String testName){
        System.out.println("Starting " + testName +"...");
    }
    public void testConcludeMessage(String testName){
        System.out.println(testName + " completed...");
    }

    @BeforeMethod
    public void setup() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.setSystemInfo("Organization", "UAB");
        extent.attachReporter(spark);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

        Date d = new Date();
        String date = d.toString().replace(":", "_").replace(" ", "_") + ".png";
        htmlReporter = new ExtentSparkReporter("./test-output/report/index" + date + ".html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Test Report UAB");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.setSystemInfo("Organization", "UAB");
        extent.attachReporter(htmlReporter);
        Properties properties = System.getProperties();
        extent.setSystemInfo("os.name", properties.getProperty("os.name", "win11-home"));
        extent.setSystemInfo("java.version", properties.getProperty("java.version", "23"));

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
        extent.flush();
    }

    @AfterMethod
    public void screenShotOnFailure(ITestResult result){
        String methodName = result.getMethod().getMethodName();
        String caseDescription = result.getMethod().getDescription();
        if(result.getStatus() == ITestResult.SUCCESS){
            String logText = "Test Method " + methodName + "successful<br>";
            extentTest = extent.createTest(methodName + " - " + caseDescription);
            com.aventstack.extentreports.markuputils.Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            extentTest.log(Status.PASS, markup);
        }else if (result.getStatus() == ITestResult.FAILURE){
            String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
            extentTest = extent.createTest(methodName + " - " + caseDescription);
            extentTest.fail("<details><summary><b><font color=red>Exception Occurred, click to see details" + "</font></b></summary>" + exceptionMessage + "</details>");
            String path = takeScreenShot(result.getMethod().getMethodName());
            try{
                extentTest.fail("<b><font color=red>" + "Screen of failing" + "</font></br>", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            }catch(Exception e){
                extentTest.fail("Test failed, could not attach screenshot");

            }
            String logText = "Test Method: " + methodName + "failed</br>";
            com.aventstack.extentreports.markuputils.Markup markup = MarkupHelper.createLabel(logText,ExtentColor.RED);
            extentTest.log(Status.FAIL, markup);
        }
    }

    public String takeScreenShot(String methodName){
        String fileName = getScreenshotName(methodName);
        String directory = "./Screenshots/";
        new File(directory).mkdirs();
        String path = directory + fileName;
        try{
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(path));
            System.out.println("**********");
            System.out.println("Screenshot stored at: " + path);
            System.out.println("**********");
        }catch(IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    private String getScreenshotName(String methodName){
      Date d = new Date();
      String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
     return fileName;
    }
}
