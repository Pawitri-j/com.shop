package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class SignInTest extends CommonMethods {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = BaseClass.openBrowserAndGetURL();

	}

	@AfterClass
	public void destroy() {
		BaseClass.tearDown();
	}

	
	
	String validUserName = "kapow1@gmail.com";
	
	
	
	
	
	
	
	@Test(priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void SignIn_hjklasdfasdfsdafas_1() {

	}

}// class
