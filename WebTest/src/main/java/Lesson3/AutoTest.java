package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implecitlyWait(Duration.ofSeconds(10));
        driver.get("https://dk.intrend.it/p-8222342005001-6bergen-beige");
        //Thread.sleep(10000);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement casualDressesCheckbox = driver.findElement(By.className("icon-dt-cart"));
        casualDressesCheckbox.click();
        //Thread.sleep(10000);


        Thread.sleep(5000);
        driver.quit();
    }
}
