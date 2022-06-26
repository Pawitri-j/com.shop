package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;

public class HomePageTest extends CommonMethods {

	@BeforeMethod
	public void setUp() {

		// open browser and get URL
		BaseClass.openBrowserAndGetURL();

		// Dismiss the pop up
		CommonMethods.dismissNonJsPopUp(h.dismissButton);
	}

	@AfterClass
	public void destroy() {
		BaseClass.tearDown();
	}
	

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
	@Test(priority = 4, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void homePage_categoryTabFunctionality_4() {

		h.categoriesTabIsNavigate();

	}
	
	@Test(priority = 5, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void homePage_tabsUnderSearchBarFunctionality_5() {

		h.checkEachTabUnderSearchBar();

	}

	@Test(priority = 6, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void homePage_categoryTabFunctionality_6() {

		h.changeZipcode();

	}
	
	
	
	

}// class
