import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.text.Element;
import java.time.Duration;

public class FormTests {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test
    public void formTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        Actions action = new Actions(driver);
        WebElement firstName = driver.findElement(By.id("firstName"));
        action.scrollToElement(firstName).perform();
        firstName.sendKeys("va");

        WebElement lastName = driver.findElement(By.id("lastName"));
        action.scrollByAmount(0,lastName.getRect().getY()).perform();
        lastName.sendKeys("skh");


        WebElement gender = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label"));
        gender.click();

        WebElement Phone = driver.findElement(By.id("userNumber"));
        action.scrollToElement(Phone).perform();
        Phone.sendKeys("7777777777");



        WebElement email = driver.findElement(By.id("userEmail"));
        action.scrollToElement(email).perform();
        email.sendKeys("ctn@gmail.com");

        WebElement birth = driver.findElement(By.id("dateOfBirthInput"));
        action.scrollToElement(birth).perform();
        birth.click();
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select select =  new Select(month);
        select.selectByValue("7");
        select =  new Select(year);
        select.selectByValue("2005");
        driver.findElement(By.cssSelector("[aria-label='Choose Friday, August 12th, 2005']")).click();

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        action.scrollToElement(subjects).perform();
        subjects.sendKeys("Maths");
        driver.findElement(By.id("react-select-2-option-0")).click();
        subjects.sendKeys("Chemistry");
        driver.findElement(By.id("react-select-2-option-0")).click();

        WebElement hobbies = driver.findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label"));
        hobbies.click();

        WebElement address= driver.findElement(By.id("currentAddress"));
        action.scrollToElement(address).perform();
        address.sendKeys("e geixede iqit,iqana vcxovrob me");



        action.scrollByAmount(0,100).perform();
        driver.findElement(By.id("react-select-3-input")).sendKeys("NCR");
        driver.findElement(By.id("react-select-3-option-0")).click();
        driver.findElement(By.id("react-select-4-input")).sendKeys("Delhi");
        driver.findElement(By.id("react-select-4-option-0")).click();

        WebElement submit= driver.findElement(By.id("submit"));
        submit.click();

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText(),"ct kp");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).getText(),"ctn@gmail.com");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[3]/td[2]")).getText(),"Male");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[4]/td[2]")).getText(),"7777777777");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[5]/td[2]")).getText(),"12 August,2005");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[6]/td[2]")).getText(),"Maths, Chemistry");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[7]/td[2]")).getText(),"Sports");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[9]/td[2]")).getText(),"e geixede iqit,iqana vcxovrob me");
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/table/tbody/tr[10]/td[2]")).getText(),"NCR Delhi");


        Thread.sleep(3000);
    }

}

