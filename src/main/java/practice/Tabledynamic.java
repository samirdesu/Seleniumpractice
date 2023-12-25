package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.sec.SECNamedCurves;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Tabledynamic {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
        username.clear();
        username.sendKeys("demo");
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.clear();
        password.sendKeys("demo", Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-close']")));
        if (popup.isDisplayed()) {
            popup.click();
        }
        driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='collapse show']//a[contains(text(), 'Customers')]"))).click();
        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        int total_pages = Integer.parseInt(text.substring(text.indexOf("(") + 1, text.indexOf("Pages") - 1));
        System.out.println("Only Total number of pages: " + total_pages);
        Thread.sleep(2000);
        //Clicking  five pages // If I want to click all numbers in pagination need to keep total_page instead of 5 in the loop.
        for (int i = 1; i <=5; i++) {
            if (total_pages > 1) {

                WebElement active_page = driver.findElement(By.xpath("//*[@id='form-customer']/div[2]/div[1]//li[" + i + "]"));
                ////*[@id='form-customer']/div[2]/div[1]//li["+i+"]
                //"//ul[@class='pagination']//li//*[text()="+i+"
                System.out.println("Active Page: " + active_page.getText());
                active_page.click();
                Thread.sleep(2000);

            }
            int number_of_rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
            System.out.println("Total number of rows:" + number_of_rows);


                for (int r = 1; r <= number_of_rows; r++) {

                    String first_row = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]/td[2]")).getText();
                    String second_row = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]/td[3]")).getText();
                    String fourth_row = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]/td[4]")).getText();
                    System.out.println(first_row + "  " + second_row + "  " + fourth_row);
                }
            }
        }
    }








