package rahulshettyacademy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    public CartPage (WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class='cartSection']/h3")
    List<WebElement> productTitles;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkOut;

    public boolean verifyProductDisplay(String productName)
    {
        Boolean match = productTitles.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckOutPage goToCheckOut()
    {
        checkOut.click();
        return new CheckOutPage(driver);
    }



}
