package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dropdownpractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

        WebElement dropdwn=driver.findElement(By.xpath("//div[@class='single_tab_div resp-tab-content resp-tab-content-active']//p//select"));

        Select drop =new Select(dropdwn); // object need to be created for dropdown
        drop.selectByVisibleText("Algeria"); // select by dropdown text
        drop.selectByValue("ALB"); // select by value if available
        List<WebElement>option=drop.getOptions();
        System.out.println("Total number of text: "+ option.size());
        for (WebElement opt:option){
            System.out.println(opt.getText());
        }

    }
}
