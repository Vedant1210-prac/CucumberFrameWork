package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	@FindBy(xpath="//input[@id='Email']")
	WebElement LoginEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement LoginPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement LoginBtn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void setEmail(String email) {
		LoginEmail.sendKeys(email);
	}
	
	public void setPassword(String PWD) {
		LoginPassword.sendKeys(PWD);
	}
	
	public void clickOnLoginBtn() {
		LoginBtn.click();
	}
}
