package runnerFile;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		plugin = { "pretty", "html:target/cucumber-reports" },
		features = "C:\\E_Personal\\LearnigJ2EE\\RestAPI_U_BDD\\src\\test\\java\\features\\Maveric.feature",
		glue= "stepDefinitions",
		dryRun=false,
		tags= {"@Createuser","~@GetUser"},
		monochrome=true

		)

public class TestRunner {
	
//	@AfterClass
//	public static void setup()
//	{
//	Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
//	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
//	Reporter.setSystemInfo("User Name", "AJ");
//	Reporter.setSystemInfo("Application Name", "Test App ");
//	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
//	Reporter.setSystemInfo("Environment", "Production");
//	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
//	}
	
	
}
