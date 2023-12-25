package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class framepractices {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_placeholder");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement iframe=driver.findElement(By.xpath("//*[@id=\"iframeResult\"]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//input[@id='phone']")).clear();
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("123");


    }
}
