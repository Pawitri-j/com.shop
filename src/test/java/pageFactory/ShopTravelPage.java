package pageFactory;

import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class ShopTravelPage extends CommonMethods{

	public ShopTravelPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	
	
	
	
}// class 
