package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.CommonMethods;

public class ProductPage extends CommonMethods{

	
	public ProductPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	
	//Pawitri 06/16/22 - Search Functionality Test cases
	@FindBy(xpath = "//*[@id='page']/section/section/div[2]/div/ul/li[2]/a/span") public WebElement productDepartmentName;
	@FindBy(xpath = "//*[@id='page']/section/section/section[1]/div/div/h2") public WebElement notMatchingSearchResult1;
	@FindBy(xpath = "//*[@id='page']/section/section/div[3]/div[1]/span[1]") public WebElement notMatchingSearchResult2;
	@FindBy(xpath = "//*[@id='page']/section/section/div[3]/div[1]")public WebElement matchingSearchResult;
	
	
	//Alip	06/21/2022
		@FindBy(xpath = "//*[@id='page']/section/section/section/section/section[2]/section[1]/ul/li/section/div/a")
		public List<WebElement> productList;
		
		@FindBy(xpath = "//*[contains(@class, 'color-swatches__list-link')]")
		public List<WebElement> productOptionList;
		
		@FindBy(xpath = "//*[@id='single-purchase-selection']")
		public WebElement productBuyNow;
		
		@FindBy(xpath = "//*[@id='product']/form/section/div[2]/aside/section/fieldset/section[1]/button")
		public WebElement productAddToCart;
	
	
	
}// class
