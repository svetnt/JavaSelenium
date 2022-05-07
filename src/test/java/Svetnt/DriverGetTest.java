package Svetnt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DriverGetTest {
//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chromedriver\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();

    @BeforeMethod
    public void Setup() {

       driver.get("https://www.duolingo.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void Test() {

        Assert.assertEquals(driver.getTitle(),"Duolingo - The world's best way to learn a language");
    }

    @Test
    public void Test1() {

        driver.findElement(By.xpath("//a[@class='_24dlP _3HhhB _2NolF _275sd _1ZefG _6TCdY']")).click();
        String assertTitle = driver.findElement(By.xpath("//h1[@class='_1Ii2h']")).getText();
        Assert.assertEquals(assertTitle,"I want to learn...");
    }

    @AfterTest
    public void Close(){
        driver.quit();
    }
}
