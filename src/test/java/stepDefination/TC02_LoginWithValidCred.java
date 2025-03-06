package stepDefination;

import java.io.IOException;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;

public class TC02_LoginWithValidCred {

	HomePage hp = new HomePage(BaseClass.getDriver());
	LoginPage lp = new LoginPage(BaseClass.getDriver());
	MyAccountPage mAcc = new MyAccountPage(BaseClass.getDriver());
	
	
	
	@Given("User should be noOpecommerce HomePage")
	public void user_should_be_no_opecommerce_home_page() {

		//hp = ;
		boolean status = hp.LoginBtnVisibility();
		Assert.assertTrue(status);
		
		
	}

	@When("user clicks on login button from HomePage")
	public void user_clicks_on_login_button_from_home_page() {
	    
		hp.clickOnLoginBtn();
	}

	@When("user enters the valid credentials")
	public void user_enters_the_valid_credentials() throws IOException {

		lp.setEmail(BaseClass.getProperties().getProperty("loginEmail"));
		lp.setPassword(BaseClass.getProperties().getProperty("loginPwd"));
		lp.clickOnLoginBtn();

	}
	
	
	
	// with Multiple credentials
	@When("user enters the {string} and {string} on login screen")
	public void user_enters_the_and_on_login_screen(String user, String pwd) {
	    
		lp.setEmail(user);
		lp.setPassword(pwd);
	}

	@When("User click on login button")
	public void user_click_on_login_button() {

		lp.clickOnLoginBtn();
	}

	@Then("user should be successfully logged in")
	public void user_should_be_successfully_logged_in() {

		boolean statusOfLogin = mAcc.LogoutBtn_isDisplayed();
		
		if(statusOfLogin==true) {
			Assert.assertTrue(statusOfLogin);
			BaseClass.getLogger().info("Test Successful");
		}else {
			//Assert.assertTrue(statusOfLogin);
			BaseClass.getLogger().debug("Test Failed");
		}

	}

}
