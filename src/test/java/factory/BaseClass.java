package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class BaseClass {
	
	static WebDriver driver;
	static Properties p;
	static Logger lg;
	
	public static WebDriver intialzeDriver() throws IOException {
		
		p = getProperties();
		
		String execution_env = p.getProperty("execution_env");
		String os = p.getProperty("os");
		String browser = p.getProperty("browser");
		
		if(execution_env.equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			switch(os.toLowerCase()) {
			case "windows": capabilities.setPlatform(Platform.WIN11);
			break;
			case "mac": capabilities.setPlatform(Platform.MAC);
			break;
			default: System.out.println("Invalid OS");
			return null;
			}
			
			switch(browser.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome");
			break;
			case "edge": capabilities.setBrowserName("edge");
			break;
			default: System.out.println("Invalid browser");
			return null;
			}
			
			driver = new RemoteWebDriver(new URL("http://192.168.31.166:4444/wd/hub"), capabilities);
		}
		
		if(execution_env.equalsIgnoreCase("local")) {
			
			switch(browser.toLowerCase()) {
			case "chrome": driver = new ChromeDriver();
			break;
			case "edge": driver = new EdgeDriver();
			break;
			
			default: System.out.println("invalid browser");
			return null;
			}
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
	
	
	public static Logger getLogger() 
	{		 
		lg=LogManager.getLogger(); //Log4j
		return lg;
	}
	
	
	public static Properties getProperties() throws IOException {
		 
		p = new Properties();
		 
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		
		p.load(file);
		
		return p;
	}
	
	public static String randomString() {
		String randomeString = RandomStringUtils.randomAlphabetic(5);
		
		return randomeString;
		
	}
	
	public static String randomePassword() {
		
		String AlphaNumberic = RandomStringUtils.randomAlphanumeric(3);
		String Numeric = RandomStringUtils.randomNumeric(4);
		
		String password = AlphaNumberic+"@"+Numeric;
		return password;
	}
	
	

}
