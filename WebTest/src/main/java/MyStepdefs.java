import com.codeborne.selenide.Selenide;
import Lesson8.LoginPage;
import Lesson8.MyAccountPage;
import Lesson8.SuccessBlock;
import Lesson8.TShirtsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("User authorized")
    public void userAuthorized() {
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        new LoginPage().login("agentolga@gmail.com", "Barsuk");
    }

    @When("Click TShirts button in women suggest")
    public void clickTShirtsButtonInWomenSuggest() {
        new MyAccountPage().navigationBlock.clickTShirtsButtonInWomenSuggest();
    }

    @And("Select size S")
    public void selectSizeS() {
        new TShirtsPage().selectSize("S");
    }

    @And("choose tshirt by text")
    public void chooseTshirtByText() {
        new TShirtsPage().addTShirtToCartByText("faded");
    }

    @Then("cart sum should be correct")
    public void cartSumShouldBeCorrect() {
        new SuccessBlock().checkCorrectSumInCart("18$");
    }

    @When("Select size {string}")
    public void selectSizeSize(String size) {
        new TShirtsPage().selectSize(size);
    }

    @And("choose tshirt by text {string}")
    public void chooseTshirtByTextName(String tShirtName) {
        new TShirtsPage().addTShirtToCartByText(tShirtName);
    }

    @After(value = "@close")
    public void quitBrowser() {
        Selenide.closeWebDriver();
    }
}

