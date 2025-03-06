package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features= {".//Feature"}, glue ="stepDefination", plugin={"pretty", "html:target/cucumber-reports.html"}, dryRun=false, monochrome=true, publish=true)
@CucumberOptions(features = {".//Features"},
		//features = {"@target/rerun.txt"},
glue = {"stepDefination", "hooks"}, 
plugin={"pretty", "html:reports/cucumber-reports.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/rerun.txt"},
dryRun=false,
monochrome=true, 
publish=true, 
tags="@Functionality"
)

public class TestRunner extends AbstractTestNGCucumberTests{

}