package stepDefination;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	 WebDriver driver;
	 Properties p;
	
	@Before
	public void setup() throws IOException {
	
		driver = BaseClass.intialzeDriver();
		p = BaseClass.getProperties();
		
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		
	}
	
	@After
	public void teardown(Scenario scenario) {
		
		driver.quit();
	}

	@AfterStep
	public void captureScreenshot(Scenario scenario) {
		
		TakesScreenshot Ts = (TakesScreenshot) driver;
		byte[] screenshot = Ts.getScreenshotAs(OutputType.BYTES);
		
		scenario.attach(screenshot, "image/png", scenario.getName());
		
	}
}
