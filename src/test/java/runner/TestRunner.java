package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features= {".//Feature"}, glue ="stepDefination", plugin={"pretty", "html:target/cucumber-reports.html"}, dryRun=false, monochrome=true, publish=true)
@CucumberOptions(features = {".//Features"}, glue ="stepDefination", plugin={"pretty", "html:target/cucumber-reports.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, dryRun=false, monochrome=true, publish=true)

public class TestRunner extends AbstractTestNGCucumberTests{

}