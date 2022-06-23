package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.BaseClass;
import utilities.CommonMethods;

public class ShopTravelPage extends CommonMethods {

	public ShopTravelPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	private WebDriver driver = BaseClass.getDriver();

	// Alip 06/21/2022
	@FindBy(xpath = "//*[@id=\"js-shop-travel-car\"]")
	public static WebElement carButton;

	@FindBy(xpath = "//*[@id=\"car_from_city\"]")
	public static WebElement pickUpLocationBox;

	@FindBy(xpath = "//*[@id=\"car_to_city\"]")
	public static WebElement dropOffLocationBox;

	@FindBy(xpath = "//*[@id='car_pickup_date']")
	public static WebElement pickUpDate;

	@FindBy(xpath = "//*[contains(@class, 'ui-state-default')]")
	public static List<WebElement> pickUpDateBox;

	@FindBy(xpath = "//*[@id=\"car_pickup_time\"]")
	public static WebElement pickUpTimeDropDown;

	@FindBy(xpath = "//*[@id=\"car_dropoff_date\"]")
	public static WebElement dropOffDate;

	@FindBy(xpath = "//*[contains(@class, 'ui-state-default')]")
	public static List<WebElement> dropOffDateList;

	@FindBy(xpath = "//*[@id=\"car_dropoff_time\"]")
	public static WebElement dropOffTimeDropDown;

	@FindBy(xpath = "//*[@id=\"js-shopper-email\"]")
	public static WebElement emailBox;

	@FindBy(xpath = "//*[@id=\"js-travel-search\"]")
	public static WebElement searchButton;

	@FindBy(xpath = "//*[@id='car-from-city-type-ahead']/li")
	public static List<WebElement> airportList;

	@FindBy(xpath = "//*[@id='car-from-city-type-ahead']/li")
	public static WebElement airportDropDown;

	// Alip 06/21/2022
	public void SearchCarRental() {
		h.shopTravelButton.click();
		CommonMethods.waitForVisibility(carButton);
		carButton.click();

		try {
			CommonMethods.waitForVisibility(dropOffLocationBox);
			CommonMethods.sendText(pickUpLocationBox, BaseClass.getPropertyString("carPickUpLocation"));

			CommonMethods.waitForVisibility(airportDropDown);
			CommonMethods.doubleClickValueFromListByText(airportList, BaseClass.getPropertyString("carAtAirport"));

			Assert.assertTrue(dropOffLocationBox.isEnabled());
//		CommonMethods.sendText(dropOffLocationBox, "MIA");
			pickUpDate.click();
			CommonMethods.selectCalendarDate(pickUpDateBox, BaseClass.getPropertyString("carPickUpDate"));
			CommonMethods.selectDropDownValue(pickUpTimeDropDown, BaseClass.getPropertyString("carPickUpTime"));
			dropOffDate.click();
			CommonMethods.selectCalendarDate(dropOffDateList, BaseClass.getPropertyString("carDropOffDate"));
			CommonMethods.selectDropDownValue(dropOffTimeDropDown, BaseClass.getPropertyString("carDropOffTime"));
			CommonMethods.sendText(emailBox, BaseClass.getPropertyString("validUserName"));
			Assert.assertTrue(searchButton.isEnabled());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//Maria
	@FindBy(xpath = "//*[contains(@id,'js-shop-travel-']/span[1]")
	public List<WebElement> travelCategoryList;
	@FindBy(xpath = "//*[text()='SHOP Travel']")
	public WebElement shopTravelTab;

	@FindBy(xpath = "//*[@id='js-shop-travel-hotel']")
	public WebElement hotelButton;

	@FindBy(xpath = "//*[@id='hotel_city']")
	public WebElement cityorAirportCodeBTNHotel;
	@FindBy(xpath = "//*[@id='hotel-city-type-ahead']/li")
	public List<WebElement> hotelCityList;

	@FindBy(xpath = "//*[@id='hotel_start_date']")
	public WebElement hotelDateBar;

	@FindBy(xpath = "//*[contains(@class, 'ui-state-default')]")
	public List<WebElement> hotelStartDate;

	@FindBy(xpath = "//input[@id='hotel_end_date']")
	public WebElement hotelendDate;
	@FindBy(xpath = "//*[@id='rooms-hotel']/div[1]/button[1]")
	public WebElement hotelNoOfRoomsIncrement;

	@FindBy(xpath = "//input[@name='hotel_adult1']")
	public WebElement noOfAdultsBarhotel;

	@FindBy(xpath = "//input[@name='hotel_child1']")
	public WebElement noOfChildrenBarhotel;

	@FindBy(xpath = "//input[@id='js-shopper-email']")
	public WebElement UserEmailhotel;

	@FindBy(xpath = "//input[@id='js-travel-search']")
	public WebElement searchBookinghotel;

//Flight xpaths/////////////////////////////////////////

	@FindBy(xpath = "//div[@id='js-shop-travel-flights']")
	public WebElement flightButton;
	@FindBy(xpath = "//div[@role='radiogroup']")
	List<WebElement> roundTripRadioButtonList;
	@FindBy(xpath = "//input[@id='flight-round-trip']")
	public WebElement roundTripButton;

	@FindBy(xpath = "//input[@id='flight_origination']")
	public WebElement flightFromCityOrAirport;
	@FindBy(xpath = "//input[@id='flight_destination']")
	public WebElement flightToCityOrAirportBar;

	@FindBy(xpath = "//*[@id='flight-from-type-ahead']/li")
	List<WebElement> flightFromCityAirportlistOptions;
	@FindBy(xpath = "//*[@id=\"flight-to-type-ahead\"]/li")
	List<WebElement> flightToCityOrAirportList;
	@FindBy(xpath = "//input[@id='flight_depart_date']")
	public WebElement flightDepartureDate;
	@FindBy(xpath = "//span[@class='ui-datepicker-month']")
	public WebElement calenderMonth;

	@FindBy(xpath = "//span[@class='ui-datepicker-year']")
	public WebElement calenderYear;
	@FindBy(xpath = "//a[@title='Next']")
	public WebElement calendernextMonthButton;

	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
	List<WebElement> allDates;
	@FindBy(xpath = "//input[@id='flight_return_date']")
	public WebElement flightReturnDate;
	@FindBy(xpath = "//input[@id='flight_number_travelers']")
	public WebElement flightNoOfTravellers;
	@FindBy(xpath = "//input[@id='js-shopper-email']")
	public WebElement flightUserEmail;
	@FindBy(xpath = "//input[@id='js-travel-search']")
	public WebElement flightSearchCheapOAir;



	public void clickShopTravelTab() {

		shopTravelTab.click();
	}

	public void clickHotelButton() {
		CommonMethods.waitForVisibility(hotelButton);
		hotelButton.click();
	}


	public void clickCityAirportCodeBTN() {

		CommonMethods.waitForClickability(cityorAirportCodeBTNHotel);
		cityorAirportCodeBTNHotel.click();
		cityorAirportCodeBTNHotel.sendKeys(BaseClass.getPropertyString("CityOrairPortCodeHotel"));

		CommonMethods.waitVisibilityOfList(hotelCityList);
	
		for (int i = 0; i < hotelCityList.size(); i++) {
			CommonMethods.waitForVisibility(hotelCityList.get(i));
			if (hotelCityList.get(i).getText()
					.contains(BaseClass.getPropertyString("hotelCityDropDown"))) {

				hotelCityList.get(i).click();
				break;
				
			}
		}
			
		}
	

	public void startAndEndDate() {
		
		hotelDateBar.click();
		
			while (true) {
				
				String currentMonth = calenderMonth.getText();
				String currentYear = calenderYear.getText();
				
				if (currentMonth.equals(BaseClass.getPropertyString("hotelStartMonth")) && currentYear.equals(BaseClass.getPropertyString("hotelStartYear"))) {
					CommonMethods.selectCalendarDate(hotelStartDate, BaseClass.getPropertyString("hotelStartDate"));
					break;
				}
				
				calendernextMonthButton.click();
			}
			
		hotelendDate.click();
			while (true) {
				
				String currentMonth = calenderMonth.getText();
				String currentYear = calenderYear.getText();
				
				if (currentMonth.equals(BaseClass.getPropertyString("hotelEndMonth")) && currentYear.equals(BaseClass.getPropertyString("hotelEndYear"))) {
					CommonMethods.selectCalendarDate(hotelStartDate, BaseClass.getPropertyString("hotelEndDate"));
					break;
				}
				
				calendernextMonthButton.click();
			}
				
		
		
		
	}

	

	public void enterNoOfAdults() {
		CommonMethods.sendText(noOfAdultsBarhotel, BaseClass.getPropertyString("noOfAdults"));

	}

	public void enterNoOfChildren() {
		CommonMethods.sendText(noOfChildrenBarhotel, BaseClass.getPropertyString("noOfChildren"));
	}

	public void enterEmail() {
		CommonMethods.sendText(UserEmailhotel, BaseClass.getPropertyString("validUserName"));
	}

	public void clickSearchBookingcom() {
		CommonMethods.waitForClickability(searchBookinghotel);

		Assert.assertTrue(searchBookinghotel.isEnabled());
		//CommonMethods.jsClick(searchBookinghotel);

	}

	public void flightButtonClick() {
		CommonMethods.waitForVisibility(flightButton);
		flightButton.click();
	}


	public void flightclickRounTripButton() {

	
		CommonMethods.waitForVisibility(roundTripButton);
		
		for (int i = 0; i < roundTripRadioButtonList.size(); i++) {
			if (roundTripRadioButtonList.get(i).getText().contains(BaseClass.getPropertyString("roundTripOROneway"))) {
				roundTripRadioButtonList.get(i).click();
			}
		}
	}

	public void flightFromCityselect() {
		flightFromCityOrAirport.click();
		flightFromCityOrAirport.sendKeys(BaseClass.getPropertyString("flightFromCity"));
		
		CommonMethods.waitVisibilityOfList(flightFromCityAirportlistOptions);

		for (int i = 0; i < flightFromCityAirportlistOptions.size(); i++) {
			if (flightFromCityAirportlistOptions.get(i).getText()
					.contains(BaseClass.getPropertyString("flightFromCityDropDown"))) {

				flightFromCityAirportlistOptions.get(i).click();
			}
		}
	}

	public void flightToCity() {

		flightToCityOrAirportBar.click();
		flightToCityOrAirportBar.sendKeys(BaseClass.getPropertyString("flightToCity")); 

		//CommonMethods.wait(3);
	
		
		CommonMethods.waitVisibilityOfList(flightToCityOrAirportList);
		
		for (int i = 0; i < flightToCityOrAirportList.size(); i++)

			if (flightToCityOrAirportList.get(i).getText()
					.contains(BaseClass.getPropertyString("flightToCityDropDown"))) {
			
				flightToCityOrAirportList.get(i).click();
			}
	}

	public void selectflightstartEndDate() {

		flightDepartureDate.click();
		while (true) {
			String currentMonth = calenderMonth.getText();
			String currentYear = calenderYear.getText();
			if (currentMonth.equals(BaseClass.getPropertyString("flightstartMonth")) && currentYear.equals(BaseClass.getPropertyString("flightstartYear"))) {
				break;
			} else {
				calendernextMonthButton.click();
			}
		}

		CommonMethods.selectCalendarDate(allDates, BaseClass.getPropertyString("flightStartDate")); 
		CommonMethods.getWaitObject();
		flightReturnDate.click();
		while (true) {
			String currentMonth = calenderMonth.getText();
			String currentYear = calenderYear.getText();
			if (currentMonth.equals(BaseClass.getPropertyString("flightendMonth")) && currentYear.equals(BaseClass.getPropertyString("flightendYear"))) {
				break;
			}
			calendernextMonthButton.click();
		}
		CommonMethods.selectCalendarDate(allDates, BaseClass.getPropertyString("flightEndDate")); 
	}

	public void flightNoOfTravellers() {

		CommonMethods.sendText(flightNoOfTravellers, BaseClass.getPropertyString("flightNoOfTravellers"));
	}

	public void flightEmailEnter() {

		CommonMethods.sendText(flightUserEmail, BaseClass.getPropertyString("validUserName"));
	}

	public void flightSearchButtonClick() {

		CommonMethods.waitForClickability(flightSearchCheapOAir);
		CommonMethods.wait(3);
		Assert.assertTrue(flightSearchCheapOAir.isEnabled());
		//CommonMethods.jsClick(flightSearchCheapOAir);
	}

}// class
