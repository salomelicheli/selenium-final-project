package ge.tbc.itacademy.data.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends DriverInit{
    @FindBy(css = "div[class*='NewCategories']")
    WebElement categoryDropdown;
    @FindBy(css = "div.LeftSideCategories li[cat_id*='6']")
    WebElement sportCategory;
    @FindBy(css = "#sidebar a[href*='2058'] span")
    WebElement kartingi;
    @FindBy(css = "a[href*='dasveneba'] .MenuIcon")
    WebElement dasveneba;
    public LandingPage(WebDriver driver) {
        super(driver);
    }
    public WebElement kartingi(){
        return kartingi;
    }
    public void clickingOnCategoryDropDown(){
        categoryDropdown.click();
    }
    public void hoverOnSportsCategories(){
        action.moveToElement(sportCategory).perform();
        sportCategory.click();
    }
    public void choosingCartingOption(){
        js.executeScript("window.scrollBy(0,300);");
        kartingi.click();
    }
    public void clickingOnHolidayIcon(){
        dasveneba.click();
    }
}
