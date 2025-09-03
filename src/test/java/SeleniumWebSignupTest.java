import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.PriorityQueue;


public class SeleniumWebSignupTest {

    @Test
    public void start() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Desktop\\Drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://selenium-blog.herokuapp.com");
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
    }
    @Test
    public void positivesignup() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        driver.findElement(By.id("user_username")).sendKeys("Ayodeji93375757285");
        driver.findElement(By.id("user_email")).sendKeys("Ayodejiadeyemi609306@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("Joyiscomin53");
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}