package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class alerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://practice.cydeo.com/javascript_alerts");
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
        driver.switchTo().alert();
      // Alert capturealreat =driver.switchTo().alert(); // Capturing the alert with-out wait
        WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Explicit wait

        Alert capturealreat = mywait.until(ExpectedConditions.alertIsPresent()); // capturing the alert pop-up using wait
        System.out.println(capturealreat.getText());
        capturealreat.accept(); // clicking OK in alert pup-up
        //capturealreat.dismiss(); // clicking Cancel in alert pop-up
    }
}
