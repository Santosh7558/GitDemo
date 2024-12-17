package rahulshettyacademy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

import java.util.List;

public class ProductCatalogue extends AbstractComponent{

    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //WebElement username = driver.findElement(By.xpath("//input[@type='email']"));
    // List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

   By productsBy = By.cssSelector(".mb-3");
   By addToCart = By.xpath("//button[@class='btn w-10 rounded']");
   By toaster = By.cssSelector("#toast-container");

    public List<WebElement> getProductList()
    {
        waitForElementToAppear(productsBy);
        return (List<WebElement>) products;
    }

    public WebElement getProductByName(String productName)
    {

        WebElement prod = getProductList().stream().filter(product ->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        prod.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
        return prod;
    }

    public void addProductToCart(String productName)
    {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toaster);
        waitForElementToDisappear(spinner);
    }

}

