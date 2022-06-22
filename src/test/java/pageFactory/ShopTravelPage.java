package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.BaseClass;
import utilities.CommonMethods;

public class ShopTravelPage extends CommonMethods {

	public ShopTravelPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}

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
			CommonMethods.sendText(pickUpLocationBox, "DCA");

			CommonMethods.waitForVisibility(airportDropDown);
			CommonMethods.doubleClickValueFromListByText(airportList, "DCA Ronald Reagan Washington National Airport");

			Assert.assertTrue(dropOffLocationBox.isEnabled());
//		CommonMethods.sendText(dropOffLocationBox, "MIA");
			pickUpDate.click();
			CommonMethods.selectCalendarDate(pickUpDateBox, "28");
			CommonMethods.selectDropDownValue(pickUpTimeDropDown, "11:00 AM");
			dropOffDate.click();
			CommonMethods.selectCalendarDate(pickUpDateBox, "30");
			CommonMethods.selectDropDownValue(dropOffTimeDropDown, "1:00 PM");
			CommonMethods.sendText(emailBox, "kapow1@gmail.com");
			Assert.assertTrue(searchButton.isEnabled());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

///////////////////Maria/////////////////////////////////////////////
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

	String CityOrairPortCodeHotel = "LAX";
	String noOfAdults = "2";
	String noOfChildren = "1";
	String flightStartDate = "24";
	String flightEndDate = "28";
	String email = "kapow1@gmail.com";
	String flightToCity = "LAX";
	String flightstartMonth = "August";
	String flightFromCity = "DCA";
	String flightstartYear = "2022";
	String flightendMonth = "August";
	String flightendYear = "2022";
	String hotelNoOfRooms = "1";

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
		cityorAirportCodeBTNHotel.sendKeys(CityOrairPortCodeHotel);

		CommonMethods.waitVisibilityOfList(hotelCityList);
	
		for (int i = 0; i < hotelCityList.size(); i++) {
			CommonMethods.waitForVisibility(hotelCityList.get(i));
			if (hotelCityList.get(i).getText()
					.contains("Los Angeles, CA (LAX-Los Angeles Intl.)")) {

				hotelCityList.get(i).click();
			}
		}
			
		}
	

	public void startAndEndDate() {
		
		hotelDateBar.click();
		
			while (true) {
				
				String currentMonth = calenderMonth.getText();
				String currentYear = calenderYear.getText();
				
				if (currentMonth.equals("August") && currentYear.equals("2022")) {
					CommonMethods.selectCalendarDate(hotelStartDate, "12");
					break;
				}
				
				calendernextMonthButton.click();
			}
			
		hotelendDate.click();
			while (true) {
				
				String currentMonth = calenderMonth.getText();
				String currentYear = calenderYear.getText();
				
				if (currentMonth.equals("August") && currentYear.equals("2022")) {
					CommonMethods.selectCalendarDate(hotelStartDate, "24");
					break;
				}
				
				calendernextMonthButton.click();
			}
				
		
		
		
	}

	

	public void enterNoOfAdults() {
		CommonMethods.sendText(noOfAdultsBarhotel, noOfAdults);

	}

	public void enterNoOfChildren() {
		CommonMethods.sendText(noOfChildrenBarhotel, noOfChildren);
	}

	public void enterEmail() {
		CommonMethods.sendText(UserEmailhotel, email);
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
			if (roundTripRadioButtonList.get(i).getText().contains("Round Trip")) {
				roundTripRadioButtonList.get(i).click();
			}
		}
	}

	public void flightFromCityselect() {
		flightFromCityOrAirport.click();
		flightFromCityOrAirport.sendKeys(flightFromCity);
		
		CommonMethods.waitVisibilityOfList(flightFromCityAirportlistOptions);

		for (int i = 0; i < flightFromCityAirportlistOptions.size(); i++) {
			if (flightFromCityAirportlistOptions.get(i).getText()
					.contains("Arlington County, DC (DCA Ronald Reagan Washington National Airport)")) {

				flightFromCityAirportlistOptions.get(i).click();
			}
		}
	}

	public void flightToCity() {

		flightToCityOrAirportBar.click();
		flightToCityOrAirportBar.sendKeys(flightToCity);

		//CommonMethods.wait(3);
	
		
		CommonMethods.waitVisibilityOfList(flightToCityOrAirportList);
		
		for (int i = 0; i < flightToCityOrAirportList.size(); i++)

			if (flightToCityOrAirportList.get(i).getText()
					.contains("Los Angeles, CA (LAX Los Angeles International Airport)")) {
			
				flightToCityOrAirportList.get(i).click();
			}
	}

	public void selectflightstartEndDate() {

		flightDepartureDate.click();
		while (true) {
			String currentMonth = calenderMonth.getText();
			String currentYear = calenderYear.getText();
			if (currentMonth.equals(flightstartMonth) && currentYear.equals(flightstartYear)) {
				break;
			} else {
				calendernextMonthButton.click();
			}
		}

		CommonMethods.selectCalendarDate(allDates, flightStartDate);
		CommonMethods.getWaitObject();
		flightReturnDate.click();
		while (true) {
			String currentMonth = calenderMonth.getText();
			String currentYear = calenderYear.getText();
			if (currentMonth.equals(flightendMonth) && currentYear.equals(flightendYear)) {
				break;
			}
			calendernextMonthButton.click();
		}
		CommonMethods.selectCalendarDate(allDates, flightEndDate);
	}

	public void flightNoOfTravellers() {

		CommonMethods.sendText(flightNoOfTravellers, "2");
	}

	public void flightEmailEnter() {

		CommonMethods.sendText(flightUserEmail, email);
	}

	public void flightSearchButtonClick() {

		CommonMethods.waitForClickability(flightSearchCheapOAir);
		CommonMethods.wait(3);
		Assert.assertTrue(flightSearchCheapOAir.isEnabled());///////////////
//CommonMethods.jsClick(flightSearchCheapOAir);

	}
///////////////////Maria   end/////////////////////////////////////////////

}// class
