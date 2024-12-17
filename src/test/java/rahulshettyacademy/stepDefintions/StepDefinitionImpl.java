package rahulshettyacademy.stepDefintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.tests.*;

import java.io.IOException;
import java.util.List;

public class StepDefinitionImpl extends BaseTest {


    public LandingPage landingPage;
    public ProductCatalogue productCatalogue;
    public ConfirmationPage confirmationPage;
    @Given("I landed on ecommerce page")
    public void I_landed_on_ecommerce_page() throws IOException {
        landingPage= launchApplication();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username(String username,String password)
    {
        productCatalogue = landingPage.LoginApplication(username,password);
    }

    @When("^I add product (.+) to the cart$")
    public void I_add_product_productName(String productName) throws InterruptedException
    {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void Checkout_submit_the_order(String productName)
    {
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckOutPage checkoutPage = cartPage.goToCheckOut();
        checkoutPage.SelectCountry("india");
        confirmationPage = checkoutPage.PlaceOder();
    }

    @Then(" message is displayed on the confirmation page")
    public void message_displayed_on_the_confirmationpage(String string)
    {
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
    }

}
