import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AlertTests {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    public void beforeMethod(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    @AfterTest
    public void afterMethod(){
        driver.quit();
    }
    @Test
    public void AlertTest(){
        driver.get("https://demo.automationtesting.in/Alerts.html");
        WebElement alertbutton = driver.findElement(By.className("active"));
        alertbutton.click();

        WebElement alertTitle = driver.findElement(By.className("btn btn-info"));
        alertTitle.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Vakho Skhirtladze");
        alert.accept();

        WebElement text = driver.findElement(By.id("demo1"));
        Assert.assertEquals(text.getText(), "Hello Vakho Skhirtladze how are you today?");
    }
}
