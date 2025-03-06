package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	@FindBy(css="a.ico-register")
	WebElement registerBtn;
	
	@FindBy(xpath="//a[text()='Log in']")
	WebElement HPLoginBtn;
	
	public HomePage (WebDriver driver) {
		
		super(driver);
	}
	
	public void ClickOnRegisterBtn() {
		
		registerBtn.click();
	}
	
	public boolean RegisterBtnVisibility() {
		
		return registerBtn.isDisplayed();
	}
	
	public void clickOnLoginBtn() {
		HPLoginBtn.click();
	}
	
	public boolean LoginBtnVisibility() {
		
		return HPLoginBtn.isDisplayed();
	}
}
