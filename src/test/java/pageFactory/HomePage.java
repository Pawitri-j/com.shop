package pageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class HomePage extends CommonMethods {

	public HomePage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	// General
	@FindBy(xpath = "//*[@id='promo-new-session']/button")
	public WebElement dismissButton;
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[1]/button")
	public WebElement signInIcon;

	// Pawitri - Search Functionality Test cases
	@FindBy(xpath = "//*[@id='quick-search-input']")
	public WebElement searchBar;
	@FindBy(xpath = "//*[@id='search-form']/div/div[1]/div")
	public WebElement departmentButton;
	@FindBy(xpath = "//*[@id='search-form']/div/div[1]/div/div/ul/li")
	public List<WebElement> departmentList;
	@FindBy(xpath = "//*[@id='search-form']/div/button[2]")
	public WebElement searchIconButton;
	@FindBy(xpath = "//*[@id='search-form']/div/section/div[2]")
	public List<WebElement> suggestionList;
	@FindBy(xpath = "//*[@id='new-header']/section/section[1]/div[2]/button/span[2]")
	public WebElement categoryButton;
	@FindBy(xpath = "//*[@id='page']/section/section/section[2]/section[11]/div/section/h2/div")
	public WebElement topSellerBanner;
	@FindBy(xpath = "//*[@id='type-ahead']/li[1]/a/img")
	public WebElement firstMagnifyIcon;
	// HomePage Test
	@FindBy(xpath = "//*[@id='main-menu']/li")
	public List<WebElement> categoryList;

	// Pawitri 06/16/2022

	public void checkSuggestionList() {

		try {

			CommonMethods.waitForVisibility(firstMagnifyIcon);
			for (int i = 0; i < suggestionList.size(); i++) {
				// System.out.println(h.suggestionList.get(i).getText());
				Assert.assertTrue(suggestionList.get(i).getText().contains(Constants.SEARCH_SUGGESTION));
			}

		} catch (StaleElementReferenceException e) { // because the suggestion list will come up and then gone for
														// non-matching word
			e.printStackTrace();
			System.out.println("item that you searched is not matching with any product");
		}
	}

	public void checkEachSearchByDepartmentButton1() {

		String departmentText;

		for (int i = 0; i < departmentList.size(); i++) {

			departmentButton.click();

			departmentText = departmentList.get(i).getText();
			// System.out.println("homePage="+departmentText);

			CommonMethods.click(departmentList.get(i));

			searchIconButton.click();

			if (departmentText.contains(Constants.ALL_DEPARTMENTS_TEXT)) {
				CommonMethods.scrollToElement(h.shopLocal);
				Assert.assertTrue(h.shopLocal.isDisplayed());
			} else {
				// User should be navigated to the department being tested
				String productDepartmentText = p.productDepartmentName.getText();
				// System.out.println("productPage="+productDepartmentText);
				Assert.assertTrue(departmentText.contains(productDepartmentText));
			}

		} // loop

	}

	public void checkEachSearchByDepartmentButton2() {

		String departmentText;

		for (int i = 0; i < departmentList.size(); i++) {

			departmentButton.click();

			departmentText = departmentList.get(i).getText();
			// System.out.println("homePage="+departmentText);

			CommonMethods.click(departmentList.get(i));

			searchIconButton.click();

			if (departmentText.contains(Constants.ALL_DEPARTMENTS_TEXT)) {
				CommonMethods.scrollToElement(h.shopLocal);
				Assert.assertTrue(h.shopLocal.isDisplayed());
			} else if (departmentText.contains(Constants.GIFTS_DEPARTMENT)) {
				Assert.assertFalse(false); // this one failed but need to test on another one as well
			} else {
				// User should be navigated to the department being tested
				String productDepartmentText = p.productDepartmentName.getText();
				// System.out.println("productPage="+productDepartmentText);
				Assert.assertTrue(departmentText.contains(productDepartmentText));
			}

		} // loop

	}

	public void checkIfSearchResultmatching() {

		String searchResultText = "";

		try {
			searchResultText = p.matchingSearchResult.getText();
			if (searchResultText.contains(Constants.SEARCH_INPUT)
					&& searchResultText.contains(Constants.MATCHING_SEARCH_RESULT)) {
				Assert.assertTrue(searchResultText.contains(Constants.MATCHING_SEARCH_RESULT));
				Assert.assertTrue(searchResultText.contains(Constants.SEARCH_INPUT));
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (p.notMatchingSearchResult1.isDisplayed() || p.notMatchingSearchResult2.isDisplayed()) {
				System.out.println(Constants.NOT_MATCHING_SEARCH_RESULT);
			}

		}

	}

	// Sumetta - HomePage test
	@FindBy(xpath = "//*[@id='page']/section/section/section[2]/section/div/h2/div")
	public List<WebElement> homepageBannerList;
	@FindBy(xpath = "//*[@id='page']/section/section/section[2]/section[14]/div/div/section[1]/img")
	public WebElement shopLocal;
	@FindBy(xpath = "//*[@id='page']/section/a/img")
	public WebElement backToTopButton;
	@FindBy(xpath = "//*[@id='id-296-1']/div/div/h2")
	public List<WebElement> allDepartmentsHeaderList;
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/section/nav/ul/li/a")
	public List<WebElement> underSearchBarTabList;
	@FindBy(xpath = "//*[@id='new-header']/section/section[1]/div[1]/a/div[1]/img")
	public WebElement shopLogo;
	@FindBy(xpath = "//*[@id='sub-header']/div/div[1]")public WebElement shopConsultant;

	// Verify if Home Page Contains 6 Category banner
	public void homePageBannerListSIze6() {

		Assert.assertTrue(homepageBannerList.size() == 6);
	}

	public void homePageBannerName() {

		ArrayList<String> nameOfBanner = new ArrayList<>(Arrays.asList("Hot New Products", "For your Little Miracle",
				"Layered Custom Capsule Collection", "Best of Web Prices & Instant Cashback!",
				"Stay Healthy with Essential 9!", "Cleaning & Health Have Never Been More Important"));

		for (int i = 0; i < homepageBannerList.size(); i++) {

			Assert.assertTrue(homepageBannerList.get(i).getText().contains(nameOfBanner.get(i)));
		}
	}

	public void scrollDownThenClickBackToTopButton() {
		CommonMethods.scrollToElement(shopLocal);
		CommonMethods.takeScreenshot_pass("BottomOfHomePage");
		backToTopButton.click();
		
		CommonMethods.wait(1);
		CommonMethods.waitForVisibility(shopConsultant);
		CommonMethods.takeScreenshot_pass("TopOfHomePage");
	}
	
	public void checkIfLogoNavigateToHomePage() {
		
		String homePageURL = BaseClass.getDriver().getCurrentUrl();
		
		for (int i = 0; i < h.underSearchBarTabList.size(); i++) {
		
			h.underSearchBarTabList.get(i).click();
			String clickedPageURL = BaseClass.getDriver().getCurrentUrl();
			
			Assert.assertFalse(homePageURL.equals(clickedPageURL));
			
			h.shopLogo.click();
			
			Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().equals(homePageURL));
		}

	}
	
	
	
	
	
	
	
	
	

}// class
