package rahulshettyacademy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class OrderPage extends AbstractComponent {
    WebDriver driver;

    public OrderPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
   // @FindBy(xpath = "//*[@class='cartSection']/h3")
   // List<WebElement> productTitles;
    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> productNames;


    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkOut;

    public boolean verifyOrderDisplay(String productName)
    {
        Boolean match = productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

}
