package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
//Dynamic search of flipkart automation.
public class dynamicdropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("/html/body/div[3]/div/span")).click();
        Thread.sleep(2000);
        WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/header/div[1]/div[2]/form/div/div/input"));
        searchbox.sendKeys("Pendrive");
       List<WebElement> searchresult = driver.findElements(By.xpath("//div[contains(@class,'YGcVZO _2VHNef')]"));
        Thread.sleep(2000);

        System.out.println("Total Number of result "+ searchresult.size());
        for (int i=0;i<searchresult.size();i++){
           String list = searchresult.get(i).getText();
           if(list.equals("pendrive 512 gb")){
               searchresult.get(i).click();
               break;
           }
        }

    }
}
