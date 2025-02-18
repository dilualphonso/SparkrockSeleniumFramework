package base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.lang.reflect.Method; // Correct import
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Constants;

public class baseTest {

    public static WebDriver driver;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @BeforeTest
    public void beforeTestMethod() {
        // Initialize Extent Reports
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports"
                + File.separator + "/test-output/STMExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setTheme(Theme.DARK);
        extent.setSystemInfo("Host Name", "RHEL8");
        extent.setSystemInfo("UserName", "root");
        sparkReporter.config().setDocumentTitle("Automation Reports");
        sparkReporter.config().setReportName("Name of the Report Comes here ");
    }
// I have setup the webdriver and browser
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethodMethod(String browser, Method testMethod) {
        logger = extent.createTest(testMethod.getName());
        setupDriver(browser);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
//This method checks the status of the test (PASS, FAIL, or SKIP) 
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Testcase Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable().toString(), ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Testcase Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Testcase PASSED", ExtentColor.GREEN));
        }

//       if (driver != null) {
//           driver.quit();
//        }
        }
    //After all tests are done, this ensures the report is finalized and saved
    @AfterTest
    public void afterTest() {
        extent.flush();
    }
    
    // This method sets up the WebDriver based on the browser passed 

    public void setupDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }
}
