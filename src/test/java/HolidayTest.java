import ge.tbc.itacademy.helperpack.Offer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ge.tbc.itacademy.data.constants.RegistrationData.maxprice;
import static ge.tbc.itacademy.data.constants.RegistrationData.minprice;

public class HolidayTest extends Config {
    @BeforeMethod
    public void goToHolidaySection() {
        landing.clickingOnHolidayIcon();
    }

    @Test
    public void descendingOrderTest(){
        List<Offer> price = new ArrayList<>();
        holiday.surfPages(price);
        holiday.selectingAValue("1");
        try {
            double firstOfferDisplayed = holiday.getFirstElementAfterSorting();
            Offer maxPrice = Collections.max(price);
            System.out.println(maxPrice);
            Assert.assertEquals(firstOfferDisplayed, maxPrice.getPrice());
        }catch(Exception e){

        }
    }
    @Test
    public void ascendingOrderTest(){
        List<Offer> price = new ArrayList<>();
        holiday.surfPages(price);
        holiday.selectingAValue("2");
        try {
            double firstDisplayed = holiday.getFirstElementAfterSorting();
            Offer minPrice = Collections.min(price);
            System.out.println(minPrice);
            Assert.assertEquals(firstDisplayed, minPrice.getPrice());
        }catch(Exception e){

        }
    }
    @Test
    public void filterTest(){
        holiday.checkCottageSection();
        List<Offer> offers = new ArrayList<>();
        holiday.surfPages(offers);
        holiday.selectingAValue("2");
        try {
            Offer minPrice = Collections.min(offers);
            System.out.println(minPrice);
            double firstDisplayed = holiday.getFirstElementAfterSorting();
            Assert.assertEquals(firstDisplayed, minPrice.getPrice());
        }catch(Exception e){

        }
        for(Offer offer : offers){
            System.out.println(offer);
            Assert.assertTrue(offer.getDescription().contains("კოტეჯი"));
        }
    }
    @Test
    public void priceRangeTest(){
        holiday.fillOutMinPriceField(minprice);
        holiday.fillOutMaxPriceField(maxprice);
        holiday.clickingASubmitButton();
        List<Offer> offers = new ArrayList<>();
        holiday.surfPages(offers);
        for(Offer offer : offers){
            Assert.assertTrue(offer.getPrice()>=80 & offer.getPrice()<=90);
        }
    }
}
