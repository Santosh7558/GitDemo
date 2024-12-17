package rahulshettyacademy.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends BaseTest {

    @Test(groups = {"errorHandling"},retryAnalyzer = Retry.class)
    public void LoginErrorValidation() throws IOException, InterruptedException {

        landingPage.LoginApplication("shetty@gmail.com", "Iamking@000");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException
    {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue= landingPage.LoginApplication("soniaraju04@gmail.com","Santhu@7558");
        List<WebElement> products =productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
        Assert.assertTrue(match);
    }

}
