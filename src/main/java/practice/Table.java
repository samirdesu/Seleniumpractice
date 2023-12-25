package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Table {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1) Find total number of rows

        int totalrows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
        // not using below line as its counting other tables, only preferable when only one table present
       // int totalrows=driver.findElements(By.tagName("tr")).size();

        System.out.println("Total number of rows: "+totalrows);
        // 2) Find total number of columns

        int colomn=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
        System.out.println("Total number of colomn: "+colomn);
        // 3) Read specific row and columns data
        String specificdata =driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
        System.out.println("Specific Data from row number 5: "+specificdata);
        // 4) Read data from all the rows and columns // For rows and column we need to for loops

       for(int r=2;r<=totalrows;r++){

            for (int c=1;c<=colomn;c++){

                String totaltable=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
                System.out.print(totaltable+"  ");

            }
            System.out.println();

        }

        // 5) Print book name whose Author is Amit

        for (int r=2;r<=totalrows;r++){
            String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
            if (author.equals("Amit")){
                String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
                System.out.println(author+"  "+bookname);
            }
        }

        // 6) Find sum of prices for all the books
        int sum=0;
        for (int r=2;r<=totalrows;r++){
            String bookprice=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
            int totalsum=sum+Integer.parseInt(bookprice);
            System.out.println("total Sum of Books: "+totalsum);

        }
    }
}
