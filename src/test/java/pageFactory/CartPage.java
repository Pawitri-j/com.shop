package pageFactory;

import org.openqa.selenium.support.PageFactory;


import utilities.BaseClass;
import utilities.CommonMethods;

public class CartPage extends CommonMethods{
	
	
	
	// constructor 
	public CartPage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);	
		
	}
	
	
	
	
	
}//class
