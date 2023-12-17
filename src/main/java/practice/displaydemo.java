package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class displaydemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
       WebElement logo= driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
        System.out.println("Logo Displayed: "+ logo.isDisplayed());
        WebElement searchbox=driver.findElement(By.xpath("//*[@id='small-searchterms']"));
        System.out.println("Search Box Displayed: "+searchbox.isDisplayed());
        System.out.println("Search Box Active: " + searchbox.isEnabled());
        WebElement Radiobutton= driver.findElement(By.xpath("//*[@id='gender-male']"));
        Radiobutton.click();
        System.out.println("Male Radio Button Check: " +Radiobutton.isSelected());

        driver.quit();


    }
}
