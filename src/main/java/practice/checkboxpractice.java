package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class checkboxpractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.ironspider.ca/forms/checkradio.htm");
        List<WebElement> checbox=driver.findElements(By.xpath("//input[@name='color']"));
        //count how many check box available
        System.out.println("Total number of check box: "+checbox.size());

        // need for-loop to click all the check boxes
        //normal for-loop
        for(int i=0;i<checbox.size();i++){
            checbox.get(i).click();

        }
//        // Enhanced for loop same action like line number 23
//        for(WebElement chk:checbox){
//            chk.click();
//        }
        Thread.sleep(3000);
        for(int i=0;i<checbox.size();i++){
            if(checbox.get(i).isDisplayed()){
                checbox.get(i).click();

            }
        }

        // Selecting last 3 check box
        // total number of check box 6-3
        for(int i=3;i<checbox.size();i++){
            checbox.get(i).click();

        }
       /* // un-Selecting last 3 check box using normal for loop
        for(int i=0;i<checbox.size();i++){
            if(checbox.get(i).isSelected()) {
                checbox.get(i).click();
            }
        }*/

        // un-Selecting last 3 check box using enhanced for loop same as line 47

        for (WebElement check:checbox){
            if (check.isSelected()) {
                check.click();
            }
        }
        for(int i=0;i<3;i++){
            checbox.get(i).click();

        }

    }
}
