package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class framepractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");
        //Frame 1
        //First have to capture one frame as WebElement, then switch
       WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
        driver.switchTo().frame(frame1);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Samir");
        Thread.sleep(3000);

        driver.switchTo().defaultContent(); // Switching to main page

        //Frame 2
        WebElement frame2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.name("mytext2")).sendKeys("Switched to frame 2");

        driver.switchTo().defaultContent(); // Switching to main page

        //Frame 3

        WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.name("mytext3")).sendKeys("Switched to frame 3");

        //iFrame inside frame

        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id=\"i5\"]/div[3]/div")).click();




    }
}
