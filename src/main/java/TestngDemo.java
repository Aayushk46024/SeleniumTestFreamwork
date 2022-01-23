import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngDemo {

    WebDriver driver = null;
    @BeforeTest
    public void setUpTest(){
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void googleSearch(){
        driver.get("https://google.com/");
        driver.findElement(By.name("q")).sendKeys("automation step by step");

        driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

    }

    @AfterTest
    public void tearDownTest(){
        driver.close();
        driver.quit();
        System.out.println("Test completed Successfully");
    }
}
