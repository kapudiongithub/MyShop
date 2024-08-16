package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest {
    WebDriver driver;

    @Test
    public void verifyCanInteractWithCart() throws InterruptedException {
        // Launch browser
        driver = new ChromeDriver();
        // Enter URL
        driver.get("http://www.automationpractice.pl/index.php");
        //Maximise browser
        driver.manage().window().maximize();
        // Enter item to search
        driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
        // Click search button
        driver.findElement(By.name("submit_search")).click();
        // Click on item image
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@title='Blouse']")).click();
        // Select white colour
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        driver.findElement(By.name("White")).click();
        // Click Add to cart
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(.,'Add to cart')]")).click();
        // Click Proceed to checkout
        driver.switchTo().defaultContent();
        String proceedToCheckoutBtn = "//span[contains(.,'Proceed to checkout')]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(proceedToCheckoutBtn)));
        element.click();//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
