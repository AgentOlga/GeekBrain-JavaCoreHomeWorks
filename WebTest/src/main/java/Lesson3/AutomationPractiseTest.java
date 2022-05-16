package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPractiseTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implecitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationpractice.com/index.php?id_category=8&controller=category#/");
        //Thread.sleep(10000);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement casualDressesCheckbox = driver.findElement(By.id("layered_category_9"));
        casualDressesCheckbox.click();
        //Thread.sleep(10000);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Cancel']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Cancel']"))));

        driver.findElement(By.xpath("//a[@title='Cancel']")).click();

        Thread.sleep(5000);
        driver.quit();

    }

}
