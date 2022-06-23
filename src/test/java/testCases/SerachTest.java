package testCases;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import utilities.BaseClass;
import utilities.CommonMethods;
import utilities.Constants;

public class SerachTest extends CommonMethods {

	public WebDriver driver;

	@BeforeMethod
	public void setUp() {

		driver = BaseClass.openBrowserAndGetURL();

		CommonMethods.dismissNonJsPopUp(h.dismissButton);
	}

	@AfterClass
	public void destroy() {
		BaseClass.tearDown();
	}

	// Pawitri 06/16/2022
	@Test(priority = 1)
	public void Serach_DepartmentFunctionality_1_1() {

		h.checkEachSearchByDepartmentButton1();

		CommonMethods.clickSpecificElementInListByText(h.departmentList, BaseClass.getPropertyString("allDepartmentText"));

	}

	@Test(priority = 2, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void Serach_SuggestionFunctionality_2()  {

		CommonMethods.sendText(h.searchBar, BaseClass.getPropertyString("searchWord")+" "); // Add " " because Selenium will detect
																				// the letter before the word complete
																				// and will have different suggestion
		h.checkSuggestionList();

		h.searchBar.clear(); // clear Search bar
	}

	@Test(priority = 3, retryAnalyzer = utilities.RetryAnalyzer.class)
	public void Serach_SearchByInputItemFunctionality_3() {

		CommonMethods.sendText(h.searchBar, BaseClass.getPropertyString("searchInput"));

		h.searchIconButton.click();

		h.checkIfSearchResultmatching();

	}

	@Test(priority = 4)
	public void Serach_DepartmentFunctionality_1_2() {

		h.checkEachSearchByDepartmentButton2();

		// reset to All Department
		CommonMethods.clickSpecificElementInListByText(h.departmentList, BaseClass.getPropertyString("allDepartmentText"));

	}

}// class
