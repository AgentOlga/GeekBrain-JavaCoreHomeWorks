package Lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuccessBlock {
    private SelenideElement successHeader = $(By.xpath("//div[contains(@class,'layer_cart_product')]//h2"));

    private SelenideElement sumElement = $(By.xpath("//span[@class='ajax_block_cart_total']"));

    @Step("Проверка корректности суммы товаров в корзине")
    public void checkCorrectSumInCart(String expectedSum) {
        Assertions.assertAll(
                () -> successHeader.shouldBe(visible),
                () -> sumElement.shouldHave(text(expectedSum))
        );
    }
}



