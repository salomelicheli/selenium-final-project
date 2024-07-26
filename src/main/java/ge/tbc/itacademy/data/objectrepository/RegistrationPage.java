package ge.tbc.itacademy.data.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import static ge.tbc.itacademy.data.constants.RegistrationData.*;

public class RegistrationPage extends DriverInit{
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(css="input[type='password']")
    List<WebElement> passwordFields;
    @FindBy(id = "Gender2")
    WebElement genderRadioButton;
    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(id="surname")
    WebElement lastNameField;
    @FindBy(id ="Phone" )
    WebElement phoneField;
    @FindBy(id = "test")
    WebElement agreeToRulesButton;
    @FindBy(css = "select[name='birth_year']")
    WebElement dropDownField;
    @FindBy(id = "registrationBtn")
    WebElement submitButton;
    @FindBy(id = "tbcAgreement")
    WebElement agreeToPolitics;
    @FindBy(id = "input-error-email")
    WebElement emailInputErrorMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String message(){
        return emailInputErrorMessage.getText();
    }

    public void inputEmail(){
        emailField.sendKeys(email);
    }
    public void inputPasswords(){
        passwordFields.forEach(c -> c.sendKeys(password));
    }
    public void markGender(){
        genderRadioButton.click();
    }
    public void inputName(){
        nameField.sendKeys(firstName);
    }
    public void inputLastName(){
        lastNameField.sendKeys(lastName);
    }
    public void inputPhoneNumber(){
        phoneField.sendKeys(phoneNumber);
    }
    public void selectBirthYear(){
        js.executeScript("arguments[0].value='2002'", dropDownField);
    }
    public void agreeToPoliticsCheck(){
        js.executeScript("arguments[0].click();", agreeToPolitics);
    }
    public void agreeToTermsCheck(){
        js.executeScript("arguments[0].scrollIntoView(true);", agreeToRulesButton);
        js.executeScript("arguments[0].click();", agreeToRulesButton);
    }
    public void submitForm(){
        js.executeScript("arguments[0].click();", submitButton);
    }
}
