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
    
   
	
	
	
	
	

}// class
