package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;


    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://kudago.com/spb/kino/schedule-cinema/");
    }

    @Test
    void likeFilmTest() {
        List<WebElement> filmsList = driver.findElements(By.xpath("//a[@class='post-title-link' and contains(@href, 'movie')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filmsList.stream().filter(f -> f.getText().contains("Волк с Уолл-стрит")).findFirst().get());
        filmsList.stream().filter(f -> f.getText().contains("Волк с Уолл-стрит")).findFirst().get().click();

        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@flat_button WidgetButton WidgetButton--bookmarks WidgetButton']")));

        driver.findElement(By.xpath("//*[@id='userzone']/a[1]")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"auth-form-login\"]/input[1]")));

        WebElement email = driver.findElement(By.xpath("//*[@id=\"auth-form-login\"]/input[1]"));
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"auth-form-login\"]/input[2]"));
        email.sendKeys("olga");
        pass.sendKeys("pwd123");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"auth-form-login\"]/button"));
        button.click();

        Assertions.assertEquals(driver.findElement(By.id("logout")).isDisplayed(), true);
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
