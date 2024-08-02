package ge.tbc.itacademy.data.objectrepository;
import org.openqa.selenium.By;
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
    @FindBy(xpath = "//span[text() = 'მდედრობითი']/ancestor::label//input")
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

    public void inputEmail(String email){
        emailField.sendKeys(email);
    }
    public void inputPasswords(String password){
        passwordFields.forEach(c -> c.sendKeys(password));
    }
    public void markGender(String gender){
        WebElement genderRadioButton = driver.findElement(By.xpath("//span[text() = '" + gender + "']/ancestor::label//input"));
        genderRadioButton.click();
    }
    public void inputName(String firstName){
        nameField.sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }
    public void inputPhoneNumber(String phoneNumber){
        phoneField.sendKeys(phoneNumber);
    }
    public void selectBirthYear(String year){
        js.executeScript("arguments[0].value='"+ year +"'", dropDownField);
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
