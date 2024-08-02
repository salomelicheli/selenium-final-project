package ge.tbc.itacademy.data.objectrepository;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class MoviePage extends DriverInit{
    @FindBy(css="a[href*='events'] .MenuIcon")
    WebElement movie;
    @FindBy(css=".movies-deal .movie-name")
    WebElement firstMovie;
    @FindBy(xpath = "//li//a[text()= 'კავეა ისთ ფოინთი']")
    WebElement caveaEastPoint; //text
    @FindBy(xpath = "//div[@id='384933']//div[contains(@id, 'day')]//p[@class='cinema-title']")
    List <WebElement> eastPointOptions;
    @FindBy(css = "div[id*='384933'] div ul li:last-child")
    WebElement lastDate;
    @FindBy(css = "div[id='384933'] div[id*='day']:last-child")
    WebElement lastSeance;
    @FindBy(css = "div[class='seat free']")
    WebElement anyAvailableSeat;
    @FindBy(id ="tickets-pepsicorn" )
    WebElement ticketsAndPopcorn;
    @FindBy(css = ".black-hover")
    WebElement createAccountButton ;
    @FindBy(css="div[class='info'] p[class='name']")
    WebElement expectedMovieName;
    @FindBy(css = "div.content-header p:first-child")
    WebElement MovieName;
    @FindBy(css = "div[id='384933'] div[id*='day']:last-child a p[style]")
    WebElement correctTime;
    @FindBy(css = ".content-header .movie-cinema")
    WebElement expectedMovieTheatre;
    @FindBy(xpath = "//p[@class='movie-cinema']/following-sibling::p")
    WebElement expectedDateTime;

    public MoviePage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> eastPointOptions(){
        return eastPointOptions;
    }
    public WebElement caveaEastPoint(){
        return caveaEastPoint;
    }
    public String movieName(){
        return MovieName.getText();
    }
    public String expectedMovieName(){
        return expectedMovieName.getText();
    }
    public String correctTime(){
        return correctTime.getText();
    }
    public String expectedMovieTheatre(){
        return expectedMovieTheatre.getText();
    }
    public String expectedDateTime(){
        return expectedDateTime.getText();
    }

    public void navigatingToMoviePage(){
        movie.click();
    }
    public void choosingFirstMovie(){
        firstMovie.click();
    }
    public void choosingCaveaEastPoint(){
        js.executeScript("window.scrollBy(0,300);");
        action.moveToElement(caveaEastPoint).click().perform();
    }
    public void clickOnLastDateAvailable(){
        lastDate.click();
    }
    public void clickOnLastSeance(){
        js.executeScript("window.scrollBy(0,300);");
        lastSeance.click();
        wait.until(ExpectedConditions.visibilityOf(ticketsAndPopcorn));
    }
    public void choosingAnAvailablePlace(){
        try {
            anyAvailableSeat.click();
        } catch (NoSuchElementException e) {
            System.out.println("Free seat not available");
        }
    }
    public void creatingAnAccount(){
        createAccountButton.click();
    }
}