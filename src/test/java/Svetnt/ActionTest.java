package Svetnt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionTest {

    @Test
    public void actionsTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\Chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            WebElement element1 = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));

            Actions actions = new Actions(driver);
            actions.moveToElement(element1).clickAndHold().moveToElement(element2).release().build().perform();

        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        finally {
            Thread.sleep(7000);
            driver.quit();
        }
    }
}

