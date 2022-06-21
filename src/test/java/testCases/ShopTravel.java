package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class ShopTravel extends CommonMethods {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = BaseClass.openBrowserAndGetURL();

		try {
			
			h.dismissButton.click();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void destroy() {
		BaseClass.tearDown();
	}

	@Test(priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void ShopTravel_SearchCarRental_1() {
		st.SearchCarRental();
	}

}// class
