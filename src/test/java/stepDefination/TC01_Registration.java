package stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.*;

public class TC01_Registration {

	//WebDriver driver;
	HomePage hp;
	MyAccountPage macc;
	RegistrationPage rp;
	
	@Given("user should be nopcommerce home page")
	public void user_should_be_nopcommerce_home_page() {
	    
		BaseClass.getLogger().info("Test Strated for Registration");
		hp = new HomePage(BaseClass.getDriver());
		boolean status = hp.RegisterBtnVisibility();
		Assert.assertTrue(status);
	}

	@When("user should click on registration button")
	public void user_should_click_on_registration_button() {
		hp = new HomePage(BaseClass.getDriver());
		hp.ClickOnRegisterBtn();

		BaseClass.getLogger().info("User is on the registration Page");
	}

	@When("user should fill all the details on registration page")
	public void user_should_fill_all_the_details_on_registration_page() {
	   
		rp = new RegistrationPage(BaseClass.getDriver());
		rp.SetMaleRadioBtn();
		rp.EnterFirstName(BaseClass.randomePassword().toUpperCase());
		rp.EnterLastName(BaseClass.randomString().toLowerCase());
		rp.EnterEmail(BaseClass.randomString()+"@"+"gmail.com");
		rp.EnterCompanyName(BaseClass.randomString().toUpperCase());
		rp.EnterPassword(BaseClass.randomePassword());
		rp.clickRegistrationBtn();
		BaseClass.getLogger().info("User Clicked on Register Btn");
	}

	@Then("user should display the registration successful message")
	public void user_should_display_the_registration_successful_message() {


		macc = new MyAccountPage(BaseClass.getDriver());
		boolean statusMsg = macc.RegMsgStatus();
		if(statusMsg) {
			Assert.assertTrue(statusMsg);Assert.assertTrue(statusMsg);
			BaseClass.getLogger().info("Test Successfully Validated");
		}else {
			BaseClass.getLogger().info("Test is unsuccessful");
		}
		
	}



}
