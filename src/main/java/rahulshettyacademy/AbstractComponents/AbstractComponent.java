package rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rahulshettyacademy.tests.CartPage;
import rahulshettyacademy.tests.OrderPage;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;

    public   AbstractComponent(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartHeader;

    @FindBy(xpath = "//button[@routerlink='myorders']")
    WebElement orderHeader;

    public void waitForElementToAppear(By findBy)
    {
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement findBy)
    {
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        Wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public CartPage goToCartPage()
    {
        cartHeader.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public OrderPage goToOrderPage()
    {
        orderHeader.click();
        OrderPage orderpage = new OrderPage(driver);
        return orderpage;
    }

    public void waitForElementToDisappear(WebElement element)
    {
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
