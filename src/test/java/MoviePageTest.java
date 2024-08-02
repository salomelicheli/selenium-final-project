import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static ge.tbc.itacademy.data.constants.RegistrationData.*;

public class MoviePageTest extends Config {
    @Test
    public void moviePage(){
        moviePage.navigatingToMoviePage();
        moviePage.choosingFirstMovie();
        moviePage.choosingCaveaEastPoint();
        for(WebElement cavea : moviePage.eastPointOptions()){
            String str =js.executeScript("return arguments[0].textContent", cavea).toString();
            Assert.assertEquals(str,movieName);
        }
        moviePage.clickOnLastDateAvailable();
        moviePage.clickOnLastSeance();
        Assert.assertEquals(moviePage.movieName(), moviePage.expectedMovieName());
        Assert.assertEquals(moviePage.caveaEastPoint().getText(), moviePage.expectedMovieTheatre());
        Assert.assertTrue(moviePage.expectedDateTime().contains(moviePage.correctTime()));
        moviePage.choosingAnAvailablePlace();
        moviePage.creatingAnAccount();
        register.inputEmail(email);
        register.inputName(firstName);
        register.inputLastName(lastName);
        register.inputPasswords(password);
        register.markGender(gender);
        register.selectBirthYear(birthYear);
        register.inputPhoneNumber(phoneNumber);
        register.agreeToTermsCheck();
        register.agreeToPoliticsCheck();
        register.submitForm();
        Assert.assertEquals(register.message(), "მეილის ფორმატი არასწორია!");
    }
}
