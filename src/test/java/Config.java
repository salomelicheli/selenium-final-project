import ge.tbc.itacademy.data.objectrepository.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static ge.tbc.itacademy.data.constants.Links.LANDING_PAGE_PATH;

public class Config {
    WebDriver driver;
    CommonElements commonElements;
    LandingPage landing;
    HolidayPage holiday;
    RegistrationPage register;
    MoviePage moviePage;
    JavascriptExecutor js;
    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome")String browser){
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(LANDING_PAGE_PATH);
        commonElements = new CommonElements(driver);
        commonElements.acceptCookies();
        holiday = new HolidayPage(driver);
        landing = new LandingPage(driver);
        moviePage = new MoviePage(driver);
        register = new RegistrationPage(driver);
        js =(JavascriptExecutor) driver;
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
