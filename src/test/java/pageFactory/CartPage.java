package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.BaseClass;
import utilities.CommonMethods;

public class CartPage extends CommonMethods{
	
	
	// Alip	06/21/2022
	// constructor 
	public CartPage() {
		
		PageFactory.initElements(BaseClass.getDriver(), this);	
		
	}
	
	
	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[9]/button")
	public static WebElement homeUnderCategories;
	
	@FindBy(xpath = "//*[@id=\"main-menu\"]/li[12]/button")
	public static WebElement jewelryUnderCategories;
	
	@FindBy(xpath = "//*[@id=\"Home-categoryMenu9\"]/ul/li[5]")
	public static WebElement gardenUnderHome;
	
	@FindBy(xpath = "//*[@id=\"Jewelry-categoryMenu12\"]/ul/li[3]/button")
	public static WebElement braceletsUnderJewelry;
	
	@FindBy(xpath = "//*[@id=\"Bracelets-categorySubMenu2\"]/ul/li[2]/a")
	public static WebElement chainUnderBracelets;
	
	@FindBy(xpath = "//*[@id=\"page\"]/section/section/section/section/section[2]/section[1]/ul/li[1]/section[2]/a")
	public static WebElement firstChooseOption;
	
	@FindBy(xpath = "//*[@id=\"52995937\"]/li[1]/a")
	public static WebElement firstOption;
	
	@FindBy(xpath = "//*[@id=\"product\"]/form/section/div[2]/aside/section/fieldset/section[1]/button")
	public static WebElement addToCartButton;
	
	@FindBy(xpath = "//*[@id='page']/section/section/section/section/section[2]/section[1]/ul/li[1]/section[2]/button")
	public static WebElement firstAddToCartButton;
	
	@FindBy(xpath = "//*[@id='page']/section/section/section/section/section[2]/section[1]/ul/li[3]/section[2]/button")
	public static WebElement thirdAddToCartButton;
	
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[3]/section/button[1]")
	public static WebElement closeCartButton;
	
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[3]/section/section/section[3]/section[2]/div/a")
	public static WebElement viewCartButton;
	
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[3]/section/section/section[3]/section[2]/div/a")
	public static WebElement viewCartButton2;
	
	@FindBy(xpath = "//*[@id='shopping-cart']/section/section[2]/p/span[2]")
	public static WebElement subTotal;
	
	@FindBy(xpath = "//*[@id='shopping-cart']/section/section[1]/section[1]/div/span[2]")
	public static WebElement storeTotal;
	
	@FindBy(xpath = "//*[@id='shopping-cart']/section/section[1]/section[1]/ul/li[2]/section/div[2]/form[2]/button")
	public static WebElement secondRemoveButton;
	
	@FindBy(xpath = "//*[@id='shopping-cart']/section/section[1]/section[1]/ul/li[1]/section/div[2]/form[2]/button")
	public static WebElement firstRemoveButton;
	
	@FindBy(xpath = "//*[@id=\"shopping-cart\"]/section/section[1]/section/ul/li/section/div[2]/form[1]/button")
	public WebElement saveForLater;
	
	@FindBy(xpath = "//*[@id='shopping-cart']/div[3]")
	public WebElement saveForLaterDislay;
	
	
	
	
    // Alip	06/21/2022
	public void verifySubTotal() {
		CommonMethods.waitForVisibility(h.categoriesButton).click();

		CommonMethods.clickValueFromListByText(h.categoriesListButton, "Home");
		CommonMethods.clickValueFromListByText(h.bigCategoriesList, "Garden");
	
		CommonMethods.waitForVisibility(firstAddToCartButton);
		CommonMethods.jsClick(firstAddToCartButton);
		CommonMethods.waitForVisibility(closeCartButton);
		CommonMethods.jsClick(closeCartButton);
		CommonMethods.jsClick(thirdAddToCartButton);
		CommonMethods.jsClick(viewCartButton);

		CommonMethods.waitForVisibility(subTotal);
		Assert.assertTrue(subTotal.getText().contains(storeTotal.getText()));
		
		secondRemoveButton.click();
		firstRemoveButton.click();
		
		
	}
	
    // Alip	06/21/2022
	public void verifySaveForLater() {
		CommonMethods.waitForVisibility(h.categoriesButton).click();

		CommonMethods.clickValueFromListByText(h.categoriesListButton, "Jewelry");
		CommonMethods.clickValueFromListByText(h.bigCategoriesList, "Bracelets");
		CommonMethods.clickValueFromListByText(h.bigCategoriesList, "Chain");
		
		try {
		CommonMethods.waitForVisibility(firstChooseOption);
		}catch(Exception e) {
			e.printStackTrace();
		}
		CommonMethods.jsClick(firstChooseOption);
		try {
		CommonMethods.waitForVisibility(firstOption);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		CommonMethods.jsClick(firstOption);
		CommonMethods.jsClick(addToCartButton);
		CommonMethods.waitForVisibility(viewCartButton);
		CommonMethods.jsClick(viewCartButton);
		CommonMethods.waitForVisibility(saveForLater);
		CommonMethods.jsClick(saveForLater);
		
		
		
		BaseClass.tearDown();
//		driver = BaseClass.openBrowserAndGetURL();
		BaseClass.openBrowserAndGetURL();
		
		try {	
			h.dismissButton.click();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		h.cartButton.click();
		h.paymentUnderCartButton.click();
				
		Assert.assertTrue(saveForLaterDislay.isDisplayed());
	}
	
	
	
	
	
}//class
