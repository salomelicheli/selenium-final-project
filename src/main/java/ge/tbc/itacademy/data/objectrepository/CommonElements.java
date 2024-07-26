package ge.tbc.itacademy.data.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonElements {
    WebDriver driver;
    @FindBy(css =".cookieButton")
    WebElement acceptCookieButton;
    public CommonElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void acceptCookies(){
        acceptCookieButton.click();
    }
}
