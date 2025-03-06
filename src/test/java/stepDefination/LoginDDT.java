package stepDefination;

import java.util.*;

import org.testng.Assert;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import utilities.DataReader;

public class LoginDDT {

	HomePage hp = new HomePage(BaseClass.getDriver());
	LoginPage lp = new LoginPage(BaseClass.getDriver());
	MyAccountPage mp = new MyAccountPage(BaseClass.getDriver());
	
	List<HashMap<String,String>> dataMap;
	String exp_res;
	
	@Given("user should navigate to Login page")
	public void user_should_navigate_to_login_page() {
		
		hp.clickOnLoginBtn();

	}

	@When("user should enter email and password provided in excel {string}")
	public void user_should_enter_email_and_password_provided_in_excel(String row) {

		try {
		dataMap = DataReader.data(System.getProperty("user.dir")+"\\testData\\nopCommerceLoginData.xlsx", "Sheet1");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		int index = Integer.parseInt(row) -1;
		String email = dataMap.get(index).get("Username");
		String password = dataMap.get(index).get("Password");
		exp_res = dataMap.get(index).get("Res");
		
		System.out.println(exp_res);
		
		
		lp.setEmail(email);
		lp.setPassword(password);
		
		lp.clickOnLoginBtn();
		
		boolean status = mp.LogoutBtn_isDisplayed();
		
try {
     if(exp_res.equalsIgnoreCase("valid")) {
	    	
	    	
	    	if(status==true) {
	    		
	    		Assert.assertTrue(status);
	    	}else 
	    	{
	    	Assert.assertTrue(false);
	    	}
	}
	
     if(exp_res.equalsIgnoreCase("invalid")) {
	    	
		
		if(status == true) {
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
	  }
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
}
}
	

	
	/*@Then("user should verify behaviour")
	public void user_should_verify_behaviour() {
	    
	
}*/

