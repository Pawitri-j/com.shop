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

	        CommonMethods.dismissNonJsPopUp(h.dismissButton);
	    }

	 	
//	    @AfterClass
//	    public void destroy() {
//	        BaseClass.tearDown();
//	    }
	 
	 
	 // Alip	06/21/2022
//		@Test(priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	 	@Test
		public void ShopTravel_SearchCarRental_1() {
			st.SearchCarRental();
		}

	 ///////////////Maria///////////////
	 	@Test(priority = 1 ,retryAnalyzer = utilities.RetryAnalyzer.class)
		public void Search_hotel_1() {

			st.clickShopTravelTab();
			st.clickHotelButton();
			st.clickCityAirportCodeBTN();
		    st.startAndEndDate();
			st.enterNoOfAdults();
			st.enterNoOfChildren();
			st.enterEmail();
			st.clickSearchBookingcom();
		}
		@Test(priority = 2 ,retryAnalyzer = utilities.RetryAnalyzer.class)
		public void Search_flight_2() {
			st.clickShopTravelTab();
			st.flightButtonClick();
			st.flightclickRounTripButton();
			st.flightFromCityselect();
			st.flightToCity();
			st.selectflightstartEndDate();
			st.flightNoOfTravellers();
			st.flightEmailEnter();
			st.flightSearchButtonClick();
		}
///////////////////maria end//////////////////////////
	 
	 
	 
	 

	    
	    
}// class
