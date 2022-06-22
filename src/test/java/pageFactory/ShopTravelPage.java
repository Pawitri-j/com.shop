package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.BaseClass;
import utilities.CommonMethods;

public class ShopTravelPage extends CommonMethods{

	public ShopTravelPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
    // Alip	06/21/2022
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
	
	
	
    // Alip	06/21/2022
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
		
		}catch(Exception e) {
			e.printStackTrace();
		}


		
	}
	
	
	
	
	
}// class 
