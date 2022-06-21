package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer{
	
	public static WebDriver driver = BaseClass.getDriver();
	
	// send text to webElement
	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);

	}

	// click the Radio button or Static checkBox
	public static void clickRadioOrCheckbox(List<WebElement> radioOrCheckbox, String value) {

		String actualValue;

		for (WebElement el : radioOrCheckbox) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}
	}
	

	// select StaticdropDown value
	public static void selectDropDownValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);

			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	// select Static drop Down by index
	public static void selectDropDownIndex(WebElement element, int indexValue) {

		try {
			Select select = new Select(element);

			int size = select.getOptions().size();

			if (size > indexValue) {
				select.selectByIndex(indexValue);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	//Dismisses alerts and   catches exception if alert is not present
	public static void dismissAlert() {

		try {

			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}


	//Capture text of alert    and catches exception if alert is not present
	// return type has to be String
	public static String getAlertText() {

		String alertText = null;

		try {

			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	// Accept Alert
	public static void acceptAlert() {

		try {

			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	// Sends text to alertBox then accept
	public static void sendAlertText(String str) {

		try {

			Alert alert = driver.switchTo().alert();
			alert.sendKeys(str);
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	// iFrame switch to frame
	public static void switchToFrame(String nameOrIDofFrame) {

		try {
			driver.switchTo().frame(nameOrIDofFrame);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// iFrame switch to frame by WebElement
	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// iFrame switch to frame by index
	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	// Handle windows by switching to child Window
	public static void switchToChildWindow() {

		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String eachWindow : windows) {

			if (!eachWindow.equals(mainWindow)) {
				driver.switchTo().window(eachWindow);
				break;
			}

		}

	}

	//Wait
	public static WebDriverWait getWaitObject() {

		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);

		return wait;
	}

	
	
	//waitForClickability
	public static WebElement waitForClickability(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	//waitForVisibility
	public static WebElement waitForVisibility(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	//click
	public static void click(WebElement element) {
		waitForVisibility(element).click();
	}

	// JS executer
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	//jsClick
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	// JS scrollToElement
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// JS scrollToElement by pixel 
	public static void ScrollByPixel(int pixel) {
		// scroll down positive
		// scroll up negative

		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");

	}

	
	//time stamp
	public static String getTimeStamp() {

		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date.getTime());
	}

	
	
	//ScreenShot
	public static byte[] takeScreenshot(String filename) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + BaseClass.getPropertyString("screenShotsFileType");

			
		try {
			FileUtils.copyFile(file, new File(destinationFile));
		} catch (Exception ex) {
			System.out.println("Cannot take screenshot!");
		}

		return picBytes;
	}

	
	
	//Thread sleep wait
	public static void wait(int second) {

		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//selectCalendarDate
	public static void selectCalendarDate(List<WebElement> element, String text) {
		for (WebElement pickDate : element) {
			if (pickDate.isEnabled()) {
				if (pickDate.getText().equals(text)) {
					pickDate.click();
					break;
				}
			}
		}
	}
	
	//Created by Alip
	//select value from list
	public static void selectValueFromListByText(List<WebElement> element, String text) {
		for (WebElement value : element) {
			if (value.isDisplayed()) {
				if (value.getText().contains(text)) {
					value.click();
					break;
				}
			}
		}
	}
	
	
	
	
	
	//hover over
	public static void hover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	//dragAndDrop
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	//doubleClick
	public static void doubleClick(WebElement source) {
		Actions actions = new Actions(driver);
		actions.doubleClick(source).perform();
	}
	
	
	/**
	 * return a list of string from a list of elements ignores any element with no
	 * text
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<String>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
