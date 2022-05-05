package Svetnt;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class MainTest {

    @Test
    public void testMyTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chromedriver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://stepik.org/catalog");

        WebElement input = driver.findElementByXPath("//input[@placeholder=\"Название курса, автор или предмет\"]");

        input.sendKeys("selenium", Keys.ENTER);

        String actualResult = input.getAttribute("value");
        String expectedResult = "selenium";

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }
}
