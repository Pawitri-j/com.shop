package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class HomePage {

	public HomePage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id='promo-new-session']/button") public WebElement dismissButton;
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[1]/button")public WebElement signInIcon;
	
	
}// class
