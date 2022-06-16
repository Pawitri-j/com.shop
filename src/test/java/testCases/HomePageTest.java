package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class HomePageTest extends CommonMethods {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		//open browser and get URL
		driver = BaseClass.openBrowserAndGetURL();
		
		//Dismiss the pop up
		try {
			
			h.dismissButton.click();
			
			CommonMethods.click(h.signInIcon);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

//	@AfterClass
//	public void destroy() {
//		BaseClass.tearDown();
//	}

	
	
	
	
	
	@Test(priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void homePage_hgfglkjkhgdfjhklhkglkhgf_1() {
		
		System.out.println("hello");
		
	}

}// class
