package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class MyAccountTest extends CommonMethods {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = BaseClass.openBrowserAndGetURL();

	}

	@AfterClass
	public void destroy() {
		BaseClass.tearDown();
	}

	@Test(priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void MyAccount_putTheNamehere_1() {

	} //test1
	
	@Test(priority = 2, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void MyAccount_putTheNamehere_2() {

	}//test2
	
	@Test(priority = 3, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void MyAccount_putTheNamehere_3() {

	}//test3
	
	
	
	

}// class
