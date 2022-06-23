package testCases;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class SignInTest extends CommonMethods {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		
		driver = BaseClass.openBrowserAndGetURL();
		
		CommonMethods.dismissNonJsPopUp(h.dismissButton);
	}

	@AfterClass
	public void destroy() {
		BaseClass.tearDown();
	}

	
	//Maria 06/21/22
	
	@Test(priority = 1)
	public void SignIn_ValidUserNameAndPassword_1()  {
		h.signInIcon.click();

		s.clicksigninTab();
		s.enterEmailAddress();
		s.enterPassword();
		s.clickSignInSubmitBtn();
		s.confirmLogin();

	}

	
	
	
	
	
	
	
	
	
	

}// class
