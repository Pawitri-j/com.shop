package pageFactory;


import org.openqa.selenium.WebDriver;
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
	
	private WebDriver driver = BaseClass.getDriver();
	
	//Maria
	@FindBy(xpath="//a[contains(text(),'Sign In')]")public WebElement signInTab;


	@FindBy(xpath="//h1[normalize-space()='Sign in']")public WebElement signInPageHeader;


	@FindBy(xpath="//input[@placeholder='yourname@example.com']")public WebElement signInemailAddress;


	@FindBy(xpath="//input[@id='password']")public WebElement signInPassword;



	@FindBy(xpath="//button[@id='submit-button']")public WebElement signInsubmitButton;


	@FindBy(xpath="//span[@id='loginHeaderWelcome']")public WebElement welcomeHeaderLogin;

	@FindBy(xpath="//*[@id='recaptcha-anchor']/div[1]")public WebElement captcha;

	public void clicksigninTab() {

		CommonMethods.jsClick(signInTab);
		CommonMethods.getWaitObject();
		Assert.assertTrue(signInPageHeader.isDisplayed());
		System.out.println(signInPageHeader.getText());
	}

	public void enterEmailAddress() {
		CommonMethods.sendText(signInemailAddress, BaseClass.getPropertyString("validUserName"));}


	public void enterPassword() {
		CommonMethods.sendText(signInPassword, BaseClass.getPropertyString("validPassword"));}


	public void clickSignInSubmitBtn() {
		signInsubmitButton.click();

	}

	public void confirmLogin() {

		CommonMethods.waitForVisibility(welcomeHeaderLogin);
		Assert.assertTrue(welcomeHeaderLogin.isDisplayed());
		System.out.println(welcomeHeaderLogin.getText());
	}

	


	
	
	
	
	
}// class
