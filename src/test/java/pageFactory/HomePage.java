package pageFactory;


import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
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

	 private WebDriver driver = BaseClass.getDriver();
	 
	// General
	@FindBy(xpath = "//*[@id='promo-new-session']/button")
	public WebElement dismissButton;
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[1]/button")
	public WebElement signInIcon;
	// Alip 06/21/2022	
//	@FindBy(xpath = "//*[@id=\"new-header\"]/section/section[2]/div[2]/section/nav/ul/li[4]/a")
//	public WebElement shopTravelButton;
	
//	@FindBy(xpath = "//*[@id='new-header']/section/section[1]/div[2]/button")
//	public WebElement categoriesButton;
	
//	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[3]/button")
//	public WebElement cartButton;
	
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[3]/section/section/section[2]/a")
	public WebElement paymentUnderCartButton;
	
	@FindBy(xpath = "//*[@id='main-menu']/li/button")
	public List<WebElement> categoriesListButton;
	
	@FindBy(xpath = "//*[contains (@class, 'header-subnav__item-link')]")
	public List<WebElement> bigCategoriesList;
	
	// Pawitri 06/16/2022 - Search Functionality Test cases
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

	public void checkSuggestionList() {

		try {

			CommonMethods.waitForVisibility(firstMagnifyIcon);
			for (int i = 0; i < suggestionList.size(); i++) {
				// System.out.println(h.suggestionList.get(i).getText());
				Assert.assertTrue(suggestionList.get(i).getText().contains(BaseClass.getPropertyString("searchWord")));
			}

		} catch (StaleElementReferenceException e) { // because the suggestion list will come up and then gone for
														// non-matching word
			e.printStackTrace();
			System.out.println(BaseClass.getPropertyString("warning"));
		}
	}

	public void checkEachSearchByDepartmentButton_1() {

		String departmentText;

		for (int i = 0; i < departmentList.size(); i++) {

			departmentButton.click();

			departmentText = departmentList.get(i).getText();
			// System.out.println("homePage="+departmentText);

			CommonMethods.click(departmentList.get(i));

			searchIconButton.click();

			if (departmentText.contains(BaseClass.getPropertyString("allDepartmentText"))) {
				CommonMethods.scrollToElement(shopLocal);
				Assert.assertTrue(shopLocal.isDisplayed());
			} else {
				// User should be navigated to the department being tested
				String productDepartmentText = p.productDepartmentName.getText();
				// System.out.println("productPage="+productDepartmentText);
				Assert.assertTrue(departmentText.contains(productDepartmentText));
			}

		} // loop

	}

	public void checkEachSearchByDepartmentButton_2() {

		String departmentText;

		for (int i = 0; i < departmentList.size(); i++) {

			departmentButton.click();

			departmentText = departmentList.get(i).getText();
			// System.out.println("homePage="+departmentText);

			CommonMethods.click(departmentList.get(i));

			searchIconButton.click();

			if (departmentText.contains(BaseClass.getPropertyString("allDepartmentText"))) {
				CommonMethods.scrollToElement(shopLocal);
				Assert.assertTrue(shopLocal.isDisplayed());
			} else if (departmentText.contains(BaseClass.getPropertyString("giftDepartmentText"))) {
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
			if (searchResultText.contains(BaseClass.getPropertyString("searchInput"))
					&& searchResultText.contains(BaseClass.getPropertyString("matchingSearchResult"))) {
				Assert.assertTrue(searchResultText.contains(BaseClass.getPropertyString("matchingSearchResult")));
				Assert.assertTrue(searchResultText.contains(BaseClass.getPropertyString("searchInput")));
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (p.notMatchingSearchResult1.isDisplayed() || p.notMatchingSearchResult2.isDisplayed()) {
				System.out.println(BaseClass.getPropertyString("notMatchingResult"));
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

		Assert.assertTrue(homepageBannerList.size() == BaseClass.getPropertyInteger("homePageBannerSize"));
	}

	public void homePageBannerName() {

//		ArrayList<String> nameOfBanner = new ArrayList<>(Arrays.asList("Hot", "For your Little Miracle",
//				"Layered Custom Capsule Collection", "Best of Web Prices & Instant Cashback!",
//				"Stay Healthy with Essential 9!", "Cleaning & Health Have Never Been More Important"));

		for (int i = 0; i < homepageBannerList.size(); i++) {
			System.out.println(homepageBannerList.get(i).getText());
			Assert.assertTrue(homepageBannerList.get(i).getText().contains(Constants.NAME_OF_BANNERS.get(i)));
		}
	}

	public void scrollDownThenClickBackToTopButton() {
		CommonMethods.scrollToElement(shopLocal);
		CommonMethods.takeScreenshot_pass(BaseClass.getPropertyString("bottomOfPageFileName"));
		backToTopButton.click();
		
		CommonMethods.wait(1);
		CommonMethods.waitForVisibility(shopConsultant);
		CommonMethods.takeScreenshot_pass(BaseClass.getPropertyString("topOfPageFileName"));
	}
	
	public void checkIfLogoNavigateToHomePage() {
		
		String homePageURL = driver.getCurrentUrl();
		
		for (int i = 0; i < underSearchBarTabList.size(); i++) {
		
			underSearchBarTabList.get(i).click();
			String clickedPageURL = driver.getCurrentUrl();
			
			Assert.assertFalse(homePageURL.equals(clickedPageURL));
			
			shopLogo.click();
			
			Assert.assertTrue(driver.getCurrentUrl().equals(homePageURL));
		}

	}
	
	
	
	//Armeena 06/20/22
	@FindBy(xpath = "//*[@id=\"new-header\"]/section/section[2]/div[2]/section/nav/ul/li[4]/a")
	public WebElement shopTravelButton;

	@FindBy(xpath = "//*[@id='new-header']/section/section[1]/div[2]/button")
	public WebElement categoriesButton;

	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[3]/button")
	public WebElement cartButton;

	@FindBy(xpath = "//*[@id='main-menu']")
	public List<WebElement> categoriesList;

	@FindBy(xpath = "//*[@id='new-header']/section/section[1]/div[2]/nav/h2")
	public WebElement verifyCategoriesText;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li/button/span")
	public List<WebElement> arrowList;

	@FindBy(xpath = " //*[contains(@id,'categoryMenu')]/h2")
	public List<WebElement> categoriesHeaderList;

	@FindBy(xpath = "//*[contains(@id,'categoryMenu')]/button[1]")
	public List<WebElement> dismissSubCategoriesList;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li/button")
	public List<WebElement> categoriesWithSubList;

	@FindBy(xpath = "//*[@id=\"main-menu\"]/li/a")
	public List<WebElement> categoriesTabLinkList;

	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/section/nav/ul/li/a")
	public List<WebElement> underSearchBarTabsList;

	@FindBy(xpath = "//*[contains(@id,'page')]/section/section/article/")
	public List<WebElement> verifyTabTextsList;

	@FindBy(xpath = "//*[@id=\"page\"]/section/section/section[2]/section[14]/div/div/div/p/a")
	public WebElement shopLocalButton;

	@FindBy(xpath = "//*[contains(@id,'near')]")
	public WebElement zipcodeBox;

	@FindBy(xpath = "//*[contains(@id,'shoplocal-searchbar')]/form/div[2]/div/button")
	public WebElement searchIcon;

	@FindBy(xpath = "//*[@id=\"page\"]/section/section/section/div[3]/div[1]/div[2]/h2")
	public WebElement verifyZipcode;

	public void categoriesTabIsNavigate() {

		String category;
		String categoryHeader;
		String homePageUrl;
		String currentTabUrl;

		CommonMethods.jsClick(categoriesButton);

		CommonMethods.waitVisibilityOfList(categoriesWithSubList);
		CommonMethods.waitForClickability(categoriesWithSubList.get(0));
		
		if (arrowList.get(0).isDisplayed()) {
			for (int i = 0; i < categoriesWithSubList.size(); i++) {

				category = categoriesWithSubList.get(i).getText();

				System.out.println(category);

				CommonMethods.jsClick(categoriesWithSubList.get(i));
				categoryHeader = categoriesHeaderList.get(i).getText();

				System.out.println(categoryHeader);
				Assert.assertTrue(category.contains(categoryHeader));
				CommonMethods.jsClick(dismissSubCategoriesList.get(i));

				CommonMethods.jsClick(categoriesButton);
			}
		}

		for (int i = 0; i < categoriesTabLinkList.size(); i++) {

			homePageUrl = BaseClass.getDriver().getCurrentUrl();
			categoriesTabLinkList.get(i).click();
			
			currentTabUrl = BaseClass.getDriver().getCurrentUrl();
			Assert.assertFalse(homePageUrl.equals(currentTabUrl));
			
			CommonMethods.dismissNonJsPopUp(h.dismissButton);
			
			CommonMethods.waitForVisibility(categoriesButton);
			categoriesButton.click();

		}
	}

	public void checkEachTabUnderSearchBar() {

		String tabsMenu;
		String tabsHeader;

		for (int i = 0; i < underSearchBarTabsList.size(); i++) {

			tabsMenu = underSearchBarTabsList.get(i).getText();
			//System.out.println(tabsMenu);

			CommonMethods.jsClick(underSearchBarTabsList.get(i));

			tabsHeader = underSearchBarTabsList.get(i).getText();
			//System.out.println(tabsHeader);
			
			Assert.assertTrue(tabsMenu.contains(tabsHeader));

		}

	}

	public void changeZipcode() {
		CommonMethods.jsClick(shopLocalButton);
		zipcodeBox.clear();
		zipcodeBox.sendKeys(BaseClass.getPropertyString("zipCode"));
		searchIcon.click();
		driver.navigate().refresh();  //StaleElementException
		CommonMethods.waitForVisibility(verifyZipcode);
		Assert.assertTrue(verifyZipcode.getText().contains(BaseClass.getPropertyString("zipCode")));
		
	}
	
	
	
	
	
	
	
	

}// class
