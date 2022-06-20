package utilities;

import pageFactory.CartPage;
import pageFactory.HomePage;
import pageFactory.ProductPage;
import pageFactory.ShopTravelPage;
import pageFactory.SignInPage;

public class PageInitializer extends BaseClass {

	
	public static HomePage h;
	public static CartPage c;
	public static ProductPage p;
	public static ShopTravelPage st;
	public static SignInPage s;
	
	
	public static void initialize() {
		h = new HomePage();
		c = new CartPage();
		p = new ProductPage();
		st = new ShopTravelPage();
		s = new SignInPage();
	}
	
	
	
	
	
}
