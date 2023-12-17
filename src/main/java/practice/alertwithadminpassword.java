package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alertwithadminpassword {

    // Here we will handle alert which ask for userID and Password
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //adding username and password with URL for login into the alert as we cant inspect the alert pop-up
        //username : admin
        //password " admin
        // link will include the username and password
        //https://admin:admin@the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //Success message validation
        String text=driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).getText();
        if (text.contains("Congratulations!")){
            System.out.println("Login Success");
        } else {
            System.out.println("Login Fail");
        }




    }
}
