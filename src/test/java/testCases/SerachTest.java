package testCases;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;


public class SerachTest extends CommonMethods {

	@BeforeMethod
	public void setUp() {

		BaseClass.openBrowserAndGetURL();

		CommonMethods.dismissNonJsPopUp(h.dismissButton);
	}

	@AfterClass
	public void destroy() {
		BaseClass.tearDown();
	}

	// Pawitri 06/16/2022
	@Test(priority = 1)
	public void Search_DepartmentFunctionality_1_1() {

		h.checkEachSearchByDepartmentButton_1();

		CommonMethods.clickSpecificElementInListByText(h.departmentList, BaseClass.getPropertyString("allDepartmentText"));

	}

	@Test(priority = 2, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void Search_SuggestionFunctionality_2()  {

		CommonMethods.sendText(h.searchBar, BaseClass.getPropertyString("searchWord")+" "); // Add " " because Selenium will detect
																				// the letter before the word complete
																				// and will have different suggestion
		h.checkSuggestionList();

		h.searchBar.clear(); // clear Search bar
	}

	@Test(priority = 3, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void Search_SearchByInputItemFunctionality_3() {

		CommonMethods.sendText(h.searchBar, BaseClass.getPropertyString("searchInput"));

		h.searchIconButton.click();

		h.checkIfSearchResultmatching();

	}

	
//	@Test(priority = 4)
//	public void Search_DepartmentFunctionality_1_2() {
//
//		h.checkEachSearchByDepartmentButton_2();
//
//		// reset to All Department
//		CommonMethods.clickSpecificElementInListByText(h.departmentList, BaseClass.getPropertyString("allDepartmentText"));
//
//	}

}// class
