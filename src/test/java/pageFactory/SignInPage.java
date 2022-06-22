package pageFactory;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.BaseClass;
import utilities.CommonMethods;

public class SignInPage extends CommonMethods{

	
	public SignInPage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
////////////////////Mariaaaaa///////////////////////////
	@FindBy(xpath="//a[contains(text(),'Sign In')]")public WebElement signInTab;


	@FindBy(xpath="//h1[normalize-space()='Sign in']")public WebElement signInPageHeader;


	@FindBy(xpath="//input[@placeholder='yourname@example.com']")public WebElement signInemailAddress;


	@FindBy(xpath="//input[@id='password']")public WebElement signInPassword;



	@FindBy(xpath="//button[@id='submit-button']")public WebElement signInsubmitButton;


	@FindBy(xpath="//span[@id='loginHeaderWelcome']")public WebElement welcomeHeaderLogin;

	@FindBy(xpath="//*[@id='recaptcha-anchor']/div[1]")public WebElement captcha;

	String validUserName = "kapow1@gmail.com";
	String validPassword="123abcd";

	public void clicksigninTab() {

		CommonMethods.jsClick(signInTab);
		CommonMethods.getWaitObject();
		Assert.assertTrue(signInPageHeader.isDisplayed());
		System.out.println(signInPageHeader.getText());
	}

	public void enterEmailAddress() {
		CommonMethods.sendText(signInemailAddress, validUserName);}


	public void enterPassword() {
		CommonMethods.sendText(signInPassword, validPassword);}


	public void clickSignInSubmitBtn() {
		signInsubmitButton.click();

	}

	public void confirmLogin() {

		CommonMethods.waitForVisibility(welcomeHeaderLogin);
		Assert.assertTrue(welcomeHeaderLogin.isDisplayed());
		System.out.println(welcomeHeaderLogin.getText());
	}

	
	
////////////////////Mariaaaaa///////////////////////////

	
	
	
	
	
}// class
