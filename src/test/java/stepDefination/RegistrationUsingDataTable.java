package stepDefination;

import java.util.Map;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObject.*;

public class RegistrationUsingDataTable {

	HomePage hp = new HomePage(BaseClass.getDriver());
	RegistrationPage rp = new RegistrationPage(BaseClass.getDriver());
	MyAccountPage mp = new MyAccountPage(BaseClass.getDriver());
	
	@Given("User Navigates to Registration Page")
	public void user_navigates_to_registration_page() {

		BaseClass.getLogger().info("Registration using DataTable Test strated");
		hp.ClickOnRegisterBtn();
		
	}

	@When("User enters the data below formate")
	public void user_enters_the_data_below_formate(DataTable dataTable) {
	   
		BaseClass.getLogger().info("User entering the registration details");
		
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
	    
	    rp.SetFemaleRadioBtn();
	    rp.EnterFirstName(dataMap.get("firstname"));
	    rp.EnterLastName(dataMap.get("lastname"));
	    rp.EnterEmail(dataMap.get("email"));
	    rp.EnterCompanyName(dataMap.get("companyname"));
	    rp.EnterPassword(dataMap.get("password"));
	    
	}

	@When("user clicks on registration button")
	public void user_clicks_on_registration_button() {

		BaseClass.getLogger().info("User clicks on registration button");
		
		rp.clickRegistrationBtn();
	}

	@Then("user should be able to register successfully")
	public void user_should_be_able_to_register_successfully() {
	   
		boolean statusMsg = mp.RegMsgStatus();
		
		if(statusMsg == true) {
			Assert.assertTrue(true);
			BaseClass.getLogger().info("Test Completed successfully");
		}else {
			BaseClass.getLogger().error("Registration Failed");
		}
	}



}
