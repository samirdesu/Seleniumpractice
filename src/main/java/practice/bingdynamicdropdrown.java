package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//practicing the dynamic drop down of bing
public class bingdynamicdropdrown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.bing.com/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("selenium");
        Thread.sleep(4000);
        List<WebElement> list=driver.findElements(By.xpath("//ul[@class='sa_drw']/li"));
        System.out.println("Total number of text:"+list.size());
        for (int i=0;i< list.size();i++){
           String lis=list.get(i).getText(); //Capturing the search results
            System.out.println(lis); // printing the search results
            if (lis.equals("selenium ide")){
                list.get(i).click();
            }

        }


    }
}
