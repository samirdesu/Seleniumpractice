package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class fluentwaitpractice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Waiting 10 seconds for an element to be present on the page, checking
        // for its presence once every 1 second.
        //fluent wait declaration
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        //fluent wait usage
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//input[@placeholder='Username']"))).sendKeys("Admin");
        driver.navigate().to("https://amazon.com");
        System.out.println(driver.getCurrentUrl());//expected result amazon.com
        driver.navigate().back(); // navigation commands

//        driver.quit();

    }
}
