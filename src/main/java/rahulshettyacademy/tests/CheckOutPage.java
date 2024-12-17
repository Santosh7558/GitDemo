package rahulshettyacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {

    WebDriver driver;

    public CheckOutPage (WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "input[@placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    WebElement placeorder;

    @FindBy(xpath = "//button[contains(@class,'ta-item')])[2]")
    WebElement selectcountry;

    By results = By.cssSelector(".ta-results");

    public  void SelectCountry(String countryName)
    {
        Actions a = new Actions(driver);
        a.sendKeys(country,countryName).build().perform();
        waitForElementToAppear(results);
        selectcountry.click();
    }

    public ConfirmationPage PlaceOder()
    {
        placeorder.click();
        return  new ConfirmationPage(driver);
    }
}
