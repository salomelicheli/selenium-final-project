package ge.tbc.itacademy.data.objectrepository;
import ge.tbc.itacademy.helperpack.Offer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
public class HolidayPage extends DriverInit{
    @FindBy(css = "#sidebar #minprice")
    WebElement priceRangeFrom;
    @FindBy(css = "#sidebar #maxprice")
    WebElement priceRangeTo;
    @FindBy(css = "div.special-offer")
    WebElement firstOfferAfterSorting;
    @FindBy(xpath = "//a[./img[contains(@src, 'arrow-01')]]")
    WebElement button;
    @FindBy(id = "sort")
    WebElement dropDownSelect;
    @FindBy(css = "#sidebar [value='2'][type='checkbox']")
    WebElement cottege;
    @FindBy(css = "#sidebar .submit-button")
    WebElement submitButton;
    @FindBy(css = "div.special-offer")
    List<WebElement> offers;
    @FindBy(css = ".Newlogo")
    WebElement logo;

    public HolidayPage(WebDriver driver) {
        super(driver);
    }

    public void clickingOnALogo(){
        logo.click();
    }
    public void selectingAValue(String value){
        Select select = new Select(dropDownSelect);
        select.selectByValue(value);
        wait.until(ExpectedConditions.urlContains("ID=" +value));
    }
    public void surfPages(List<Offer> offers){
        boolean exceptionOccured = false;
        while(!"none".equals(button.getCssValue("pointer-events"))) {
            try{collectOffers(offers);
                js.executeScript("window.scrollBy(0,2200);");
                button.click(); }catch(Exception e){exceptionOccured = true; break;}}if(!exceptionOccured){
            lastPage(offers);
        }
    }
    public void fillOutMinPriceField(String minPrice){
        js.executeScript("window.scrollBy(0,650);");
        priceRangeFrom.sendKeys(minPrice);
    }
    public void fillOutMaxPriceField(String maxPrice){
        priceRangeTo.sendKeys(maxPrice);
    }
    public void clickingASubmitButton(){
        submitButton.click();
        wait.until(ExpectedConditions.urlContains("maxprice"));
    }
    public double getFirstElementAfterSorting(){
        Offer firstOfferAfterSorting = new Offer(this.firstOfferAfterSorting);
        return firstOfferAfterSorting.getPrice();
    }
    public void lastPage(List<Offer> offerss){
        js.executeScript("window.scrollBy(0,1500);");
        collectOffers(offerss);
    }
    private void collectOffers(List<Offer> offerss){
        for (WebElement element : offers) {offerss.add(new Offer( element));}
    }
    public void checkCottageSection(){
        js.executeScript("window.scrollBy(0,150);");
        cottege.click();
        wait.until(ExpectedConditions.urlContains("arrangements=2"));
    }

}
