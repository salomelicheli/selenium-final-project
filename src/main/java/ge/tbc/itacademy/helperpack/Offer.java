package ge.tbc.itacademy.helperpack;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Offer implements Comparable<Offer>{
    private final WebElement element;
    private double price;
    private String description;
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    private static final By OFFER_PRICE = By.cssSelector(".discounted-prices > p:first-child");
    private static final By OFFER_DESCRIPT = By.cssSelector("[class*='special-offer-text'] a");
    private static final By OFFER_NAME = By.cssSelector("[class*='special-offer-title'] a");
    public Offer(WebElement element){
        this.element = element;
        this.setPrice();
        this.setDescription();
    }
    private void setPrice(){
        try {
            WebElement priceElement = element.findElement(OFFER_PRICE);
            String priceText = priceElement.getText();
            this.price = Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
        }catch(NoSuchElementException e){
            throw new RuntimeException("element not found, check if it is an offer element");
        }
    }
    private void setDescription(){
        WebElement name =  element.findElement(OFFER_NAME);
        WebElement textElement = element.findElement(OFFER_DESCRIPT);
        this.description = textElement.getText() + name.getText();
    }
    @Override
    public int compareTo(Offer that) {
        return Double.compare(this.price, that.price);
    }
    @Override
    public String toString() {
        return "Offer{" + ", price=" + price + ", name='" + description + '\'' + '}';
    }
}
