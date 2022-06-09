package Lesson6;

import Lesson7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import io.qameta.allure.*;



import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

@Epic("Добавить в корзину")
public class AutomationTest {
    WebDriver driver;
    TShirtsPage tShirtsPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
        tShirtsPage = new TShirtsPage(driver);

    }

    @Test
    @Feature("Корзина")
    @Story("Работа с корзиной")
    @TmsLink("123")

   void addToCartTest()  {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        new LoginPage(driver)
                .login("agentolga@gmail.com", "Barsuk")
                .navigationBlock.clickTShirtsButtonInWomenSuggest()
                .selectSize("S")
                .addTShirtToCartByText("Faded")
                .checkCorrectSumInCart("$18.51");

        Assertions.assertAll(
                () -> Assertions.assertTrue(new SuccessBlock(driver).successHeader.isDisplayed()),
                () -> assertThat(new SuccessBlock(driver).sumElement, hasText("$18.51"))
        );
    }


    @AfterEach
    void tearDown() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry logEntry : logEntries) {
            Allure.addAttachment("Элемент лога браузера", logEntry.getMessage());
        }

        driver.quit();
    }

}
