package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/* 1- Launch Browser
   2- open URL https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
   3- Provide username : Admin
   4- Provide Password : admin123
   5-Click on login button
   6-Verify the tittle of dashboard page
            Expected : OrangeHRM
   7- Close Browser
 */
public class firstpractice {
    public static void main(String[] args) {
       // 1- Launch Browser
   WebDriverManager.chromedriver().setup(); // optional and not mandatory after the new selenium update
   ChromeDriver driver =new ChromeDriver();



 driver.manage().window().maximize(); // This line will launch browser window in full screen
    // Thread.sleep(5000);
    // wait statement declaration
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
        WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10)); //Explicit Wait

        //2- open URL
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // 3- Provide username : Admin // 4- Provide Password : admin123
    //driver.findElement(By.name("username")).sendKeys("Admin");
        WebElement user = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        user.sendKeys("Admin");
     driver.findElement(By.name("password")).sendKeys("admin123");

//5-Click on login button

driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

//Thread.sleep(7000);
/*//6-Verify the tittle of dashboard page
String actualtitle=driver.getTitle();
String expectedtitle ="OrangeHRM";
if (actualtitle.equals(expectedtitle)){
    System.out.println("Test Pass");
}else {

    System.out.println("Test Fail");
}*/

//7- Close Browser
//driver.quit();
// 8 -Validation using lable "Dashboard"
String act_lbl=null;
try {
    act_lbl = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
}
catch (Exception e){
    act_lbl="";
}

 String expected_lbl ="Dashboard";
if (act_lbl.equals(expected_lbl)){
    System.out.println("Test passed");
}else {
    System.out.println("Test Fail");
}
    }
}
