package rahulshettyacademy.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    public LandingPage (WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //WebElement username = driver.findElement(By.xpath("//input[@type='email']"));

    @FindBy(xpath="//input[@type='email']")
    WebElement username;

    @FindBy(xpath="//input[@type='password']")
    WebElement password;

    @FindBy(xpath="//input[@id='login']")
    WebElement submit;

    @FindBy(css="[class*='flyInOut']")
    WebElement errormessage;


    public ProductCatalogue LoginApplication(String email,String passcode)
    {
        username.sendKeys(email);
        password.sendKeys(passcode);
        submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }

    public String getErrorMessage()
    {
        waitForWebElementToAppear(errormessage);
        return errormessage.getText();
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
