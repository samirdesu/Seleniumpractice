package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class assigmentonswitchingbrowser {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']/div"));
        System.out.println("Total number of Element: "+list.size());

        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
        }

        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.linkText("Selenium in biology")).click();
        driver.findElement(By.linkText("Selenium (software)")).click();
        driver.findElement(By.linkText("Selenium disulfide")).click();
        driver.findElement(By.linkText("Selenium dioxide")).click();


        System.out.println("Web Page Title");
        System.out.println("--------------------");


        Set<String> WindowID=driver.getWindowHandles();
        for (String win:WindowID){
            String Tittle = driver.switchTo().window(win).getTitle();
            System.out.println(Tittle);
        }
        driver.quit();

    }
}
