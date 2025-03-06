package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	@FindBy(xpath="//div[@class='result']")
	WebElement registrationMsg;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement LogOutBtn;

	public MyAccountPage(WebDriver driver) {
		
		super(driver);
	}
	
	public boolean RegMsgStatus() {
		
		return registrationMsg.isDisplayed();
	}
	
	public boolean LogoutBtn_isDisplayed() {
		
		return LogOutBtn.isDisplayed();
	}
}
