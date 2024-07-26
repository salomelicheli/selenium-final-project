package ge.tbc.itacademy.data.objectrepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverInit {
    WebDriver driver;
    Actions action;
    WebDriverWait wait;
    JavascriptExecutor js;
    public DriverInit(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
        wait =  new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
    }
}
