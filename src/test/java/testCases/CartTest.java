package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class CartTest extends CommonMethods {

	
	
	@BeforeMethod
	public void setUp() {

		BaseClass.openBrowserAndGetURL();

		CommonMethods.dismissNonJsPopUp(h.dismissButton);
	}

    @AfterClass
    public void destroy() {
        BaseClass.tearDown();    
        }

	// Alip 06/21/2022
	@Test(priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void Cart_VerifySaveForLater_1() {
		c.verifySaveForLater();

	}

	// Alip 06/21/2022
	@Test(priority = 2, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void Cart_VerifySubTotal_2() {
		c.verifySubTotal();

	}

}// class
