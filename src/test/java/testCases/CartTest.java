package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class CartTest extends CommonMethods {

	public WebDriver driver;
    @BeforeMethod
    public void setUp() {

        driver = BaseClass.openBrowserAndGetURL();

      CommonMethods.dismissNonJsPopUp(h.dismissButton);
    }

    @AfterClass
    public void destroy() {
        BaseClass.tearDown();    
        }
    
    // Alip	06/21/2022
	@Test(priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void Cart_VerifySubTotal_1() {
		c.verifySubTotal();

	}
	
    // Alip	06/21/2022
	@Test(priority = 2, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void Cart_VerifySaveForLater_2() {
		c.verifySaveForLater();
		
	}
    
   
	
	
	
	
	

}// class
