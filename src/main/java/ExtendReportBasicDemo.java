import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class ExtendReportBasicDemo {

    private static WebDriver driver = null;

    public static void main(String[] args) {

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        ExtentTest test1 = extent.createTest("Google Search Test One", "this is a test to validate google search functionality");

        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();

        test1.log(Status.INFO, "Starting Test Case");
        driver.get("https://google.com");
        test1.pass("Navigated to google.com");

        driver.findElement(By.name("q")).sendKeys("Automation");
        test1.pass("Enter text in searchbox");

        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
        test1.pass("Pressed keyboard enter key");

        driver.close();
        driver.quit();
        test1.pass("Closed the browser");

        test1.info("Test Completed");

        extent.flush( );


    }
}
