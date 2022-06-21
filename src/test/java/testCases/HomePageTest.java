package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class HomePageTest extends CommonMethods {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		// open browser and get URL
		driver = BaseClass.openBrowserAndGetURL();

		// Dismiss the pop up
		CommonMethods.dismissNonJsPopUp(h.dismissButton);
	}

//	@AfterClass
//	public void destroy() {
//		BaseClass.tearDown();
//	}
	

	// Sumetta 6/18/2022
	@Test(priority = 1, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void homePage_HomePageCategoryBanners_1() {

		h.homePageBannerListSIze6();
		h.homePageBannerName();

	}

	@Test(priority = 2, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void homePage_BackTotopButton_2() {

		h.scrollDownThenClickBackToTopButton();

	}

	@Test(priority = 3, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void homePage_logoNavigatesToHomePage_3() {

		h.checkIfLogoNavigateToHomePage();
	}
	
	//Armeena 06/20/22
	
	@Test
	public void homePage_categoryTabFunctionality_1() {

		CommonMethods.dismissNonJsPopUp(h.dismissButton);
		h.categoriesTabIsNavigate();

	}
	
	@Test
	public void homePage_tabsUnderSearchBarFunctionality_2() {

		h.checkEachTabUnderSearchBar();

	}

	@Test
	public void homePage_categoryTabFunctionality_3() {

		h.changeZipcode();

	}
	
	
	
	

}// class
