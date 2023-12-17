package practice;
/*
Test Case Assignment
----------------
1) Launch browser
2) open url
	URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
3) Provide username  - admin@yourstore.com
4) Provide password  - admin
5) Click on Login button
6) Verify the title of dashboard page
	Exp title : Dashboard / nopCommerce administration
7) Verify Dashboard*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class secondpractice {
    public static void main(String[] args) {
        //1) Launch browser
        ChromeDriver driver =new ChromeDriver();
        //2) open url
        //	URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
        //3) Provide username  - admin@yourstore.com
        //4) Provide password  - admin
        WebElement cleareml=driver.findElement(By.id("Email"));
        cleareml.clear();
        cleareml.sendKeys("admin@yourstore.com");
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("admin");
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();
       String actualtxt= driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/h1")).getText();
        String expectedtxt = "Dashboard";

        if (actualtxt.equals(expectedtxt)){
            System.out.println("Test Pass");
        }else {
            System.out.println("Test Fail");
        }
        driver.findElement(By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a")).click();
        driver.quit();
    }
}
