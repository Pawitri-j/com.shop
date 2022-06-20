package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class ProductPage extends CommonMethods{

	
	public ProductPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	
	//Pawitri - Search Functionality Test cases
	@FindBy(xpath = "//*[@id='page']/section/section/div[2]/div/ul/li[2]/a/span") public WebElement productDepartmentName;
	@FindBy(xpath = "//*[@id='page']/section/section/section[1]/div/div/h2") public WebElement notMatchingSearchResult1;
	@FindBy(xpath = "//*[@id='page']/section/section/div[3]/div[1]/span[1]") public WebElement notMatchingSearchResult2;
	@FindBy(xpath = "//*[@id='page']/section/section/div[3]/div[1]")public WebElement matchingSearchResult;
	
	
	
	
	
	
}// class
