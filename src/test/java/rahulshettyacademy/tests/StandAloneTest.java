package rahulshettyacademy.tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class StandAloneTest extends BaseTest {
    String productName = "ZARA COAT 3";


    @Test(dataProvider = "getData",groups = "Purchase")
    public void standAlone(HashMap<String,String> input) throws IOException, InterruptedException
    {
        ProductCatalogue productCatalogue= landingPage.LoginApplication(input.get("email"),input.get("password"));
        List<WebElement> products =productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalogue.goToCartPage();
        Boolean match = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckOutPage checkoutPage = cartPage.goToCheckOut();
        checkoutPage.SelectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.PlaceOder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER"));
    }
    @Test(dependsOnMethods = {"standAlone"})
    public void orderHistoryTest()
    {
        ProductCatalogue productCatalogue= landingPage.LoginApplication("soniaraju04@gmail.com","Santhu@7558");
        OrderPage orderPage = productCatalogue.goToOrderPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }

}

 /* HashMap<String,String> map = new HashMap<String,String>();
        map.put("email","soniaraju04@gmail.com");
        map.put("password","Santhu@7558");
        map.put("product","ZARA CODE 3");

        HashMap<String,String> map1 = new HashMap<String,String>();
        map1.put("email","shetty@gmail.com");
        map1.put("password","Iamking@000");
        map1.put("product","ADIDAS ORIGINAL");*/
