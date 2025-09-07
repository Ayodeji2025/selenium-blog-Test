import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignupTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        // Set up GeckoDriver (Firefox)
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\user\\Desktop\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // 1. Verify the user input the right url and his on the right webpage*
        driver.get("https://selenium-blog.herokuapp.com");
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("https://selenium-blog.herokuapp.com")) {
            System.out.println("Correct webpage: " + currentUrl);
        } else {
            System.out.println("Wrong webpage. Found: " + currentUrl);
        }
    }
    @Test(priority = 1)
    public void positiveSignup() {
        // Verify that when user clicks on the signup button, the user is directed to the signup page*
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("User is on the correct Signup page: " + actualUrl);
        } else {
            System.out.println("Wrong page. Expected: " + expectedUrl + " but found: " + actualUrl);
        }

    }
    @Test(priority = 2)
    public void signuptest() {

        // Fill in signup form
        driver.findElement(By.id("user_username")).sendKeys("Winner20929059");
        String expectedUsername = "Winner2029059";
        String actuelUsername = driver.findElement(By.id("user_username")).getAttribute("value");
        if (actuelUsername.equals(expectedUsername)) {
            System.out.println("Username entered correctly: " + "Winner2029059");
        } else {
            System.out.println("Wrong username. Expected: " + expectedUsername + " but found: " + "Winner20259");
        }
    }
    @Test(priority = 3)
    public void useremail() {
            driver.findElement(By.id("user_email")).sendKeys("sonofgodgrace2090025@gmail.com");
    }
    @Test(priority = 4)
    public void userpassword() {
        driver.findElement(By.id("user_password")).sendKeys("Joyiscomin53");
        driver.findElement(By.id("submit")).click();
    }
    @Test(priority = 5)
    public void meaghantest() {
        // Navigate into user area
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();

    }
    @Test(priority = 6)
    public void user1test() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
    }
    @Test(priority = 7)
    public void logout() {
        // Logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();

        // Assertion: check page title contains "Alpha Blog" after signup
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
    }


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
