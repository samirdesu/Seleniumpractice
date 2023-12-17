package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class alertwithinputbox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[3]")).click();
        WebDriverWait mywait =new WebDriverWait(driver, Duration.ofSeconds(10));
       Alert aleartcheck=mywait.until(ExpectedConditions.alertIsPresent());
        aleartcheck.sendKeys("Samir");
        System.out.println(aleartcheck.getText());
        aleartcheck.accept();
        String enteredtxt=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expected="You entered: Samir";
        if(enteredtxt.equals(expected)){
            System.out.println("Test Pass");
        }else {
            System.out.println("Test Fail");
        }
    }
}
