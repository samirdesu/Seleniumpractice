package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.awt.*;
import java.security.Key;

public class clickingenterwithcomands {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://google.co.in");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Emoji", Keys.ENTER);
    }
}
