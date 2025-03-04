package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	
	@FindBy(xpath="//input[@id='gender-male']")
	WebElement Male_RadioBtn;
	
	@FindBy(xpath="//input[@id='gender-female']")
	WebElement Female_RadioBtn;
	
	@FindBy(xpath="//input[@name='FirstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='LastName']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='Email']")
	WebElement email;
	
	@FindBy(id = "Company")
	WebElement companyName;
	
	@FindBy(css = "input[name='Password']")
	WebElement PWDfield;
	
	@FindBy(css = "input[name='ConfirmPassword']")
	WebElement confirmPWDfield;
	
	@FindBy(xpath="//button[text()='Register']")
	WebElement registrationBtn;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	public void SetMaleRadioBtn() {
		Male_RadioBtn.click();
	}
	
	public void SetFemaleRadioBtn() {
		Female_RadioBtn.click();
	}
	
	public void EnterFirstName(String fname) {
		firstname.sendKeys(fname);
	}
	
	public void EnterLastName(String lname) {
		lastname.sendKeys(lname);
	}
	
	public void EnterEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void EnterCompanyName(String cname) {
		companyName.sendKeys(cname);
	}
	
	public void EnterPassword(String pwd) {
		PWDfield.sendKeys(pwd);
		confirmPWDfield.sendKeys(pwd);
	}
	
	public void clickRegistrationBtn() {
		registrationBtn.click();
	}
}
