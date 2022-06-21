package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class SignInTest extends CommonMethods {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {
		
		driver = BaseClass.openBrowserAndGetURL();
		
		CommonMethods.dismissNonJsPopUp(h.dismissButton);
	}

//	@AfterClass
//	public void destroy() {
//		BaseClass.tearDown();
//	}

	
	/////////////////////Maria Tahir//////////////////////////////
	@Test(priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void SignIn_ValidUserNameAndPassword_1()  {
		h.signInIcon.click();

		s.clicksigninTab();
		s.enterEmailAddress();
		s.enterPassword();
		s.clickSignInSubmitBtn();
		s.confirmLogin();

	}

	////////////////////////////Maria Tahir/////////////////////////////
	
	
	
	
	
	
	
	
	
	
	
	
	

}// class
