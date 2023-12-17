package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class locatorparactice {

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
       // driver.get("https://www.flipkart.com/");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
       Thread.sleep(5000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
       driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        //List<WebElement> links=driver.findElements(By.tagName("a"));
        Thread.sleep(2000);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links: " + links.size());
        for (int i=0;i<links.size();i++){
                WebElement a=links.get(i);
            String s=a.getText();
            System.out.println(s);
        }
//        List<WebElement> imgsize = driver.findElements(By.tagName("img"));
//        System.out.println("Total number of image: " + imgsize.size());



        // List<WebElement> img=driver.findElements(By.tagName("img"));
       // System.out.println("Total number of image :" +img.size());

        /*
        CSS selector practice
        */
        // finding element using tag and attributes

        driver.findElement(By.cssSelector("input[placeholder='Search']")).sendKeys("Admin");

         //finding element using tag.class
        driver.findElement(By.cssSelector("button.oxd-main-menu-button")).click();

        driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Set<String> windids=driver.getWindowHandles(); // get window handles will capture windows ids that are open in browser

        for(String ids:windids)
        {
            System.out.println(ids);
        }




    }
}
