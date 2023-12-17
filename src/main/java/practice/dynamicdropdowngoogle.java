package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class dynamicdropdowngoogle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.co.in");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Api testing");
        Thread.sleep(2000);
        List<WebElement> Totallist = driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
        System.out.println("Total number of Search iteams: " +Totallist.size());
        for (int i=0;i<Totallist.size();i++){
           String  list= Totallist.get(i).getText();
            System.out.println(list);
            if (list.equals("api testing jobs")){
                Totallist.get(i).click();
                break;
            }
        }


    }
}
