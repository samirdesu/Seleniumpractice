package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class switchbrowser {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();

        //Approach 1 using list collections
        // Getting the windows id/handles in set collection
        Set<String> windowsID= driver.getWindowHandles();
        // converting the set collection to list collection coz we cant get individual ids from set collections
        /*List<String> windowidlist = new ArrayList<>(windowsID);
        //Capturing the two windows id/handle help of index 0, 1
        String parentwindow=windowidlist.get(0);
        String childwindow=windowidlist.get(1);

        //Switching to child window
        driver.switchTo().window(childwindow);
        driver.findElement(By.xpath("//input[@id='Form_submitForm_action_request']")).click();

        driver.switchTo().window(parentwindow);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        // Keys.ENTER automatically pressing enter from keyboard
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).sendKeys(Keys.ENTER);

         */

        //Approach 2
        // In approach 2 we are not converting the set collection to list, we are using for loop
        for (String win:windowsID){
            String title = driver.switchTo().window(win).getTitle();
            if (title.equals("OrangeHRM HR Software | OrangeHRM")) {
                driver.findElement(By.xpath("//input[@id='Form_submitForm_action_request']")).click();

            }
            if(title.equals("OrangeHRM")){
                driver.close();
            }
        }


    }
}
