package pageFactory;

import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class CartPage {
	
	
	
	// constructor 
	public CartPage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);	
		
	}

	
}//class
