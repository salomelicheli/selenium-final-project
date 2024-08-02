import ge.tbc.itacademy.data.constants.ConstantData;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.constants.Links.EXPECTED_URL;
import static ge.tbc.itacademy.data.constants.Links.LANDING_PAGE_PATH;

public class LandingPageTest extends Config {
    @Test
    public void activeCategoryTest(){
        landing.clickingOnCategoryDropDown();
        landing.hoverOnSportsCategories();
        landing.choosingCartingOption();
        Assert.assertEquals(driver.getCurrentUrl(), EXPECTED_URL);
        String color = landing.kartingi().getCssValue(ConstantData.COLOR);
        Color colorInHex = Color.fromString(color);
        Assert.assertTrue(ConstantData.COLOR_HEX.equalsIgnoreCase(colorInHex.asHex()));
    }
    @Test
    public void logoTest(){
        landing.clickingOnHolidayIcon();
        holiday.clickingOnALogo();
        Assert.assertEquals(driver.getCurrentUrl(), LANDING_PAGE_PATH);
    }
}
