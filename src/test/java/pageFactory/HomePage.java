package pageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class HomePage {

	public HomePage() {

		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@id='promo-new-session']/button") 
	public WebElement dismissButton;
	
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[1]/button")
	public WebElement signInIcon;
	
	@FindBy(xpath = "//*[@id=\"new-header\"]/section/section[2]/div[2]/section/nav/ul/li[4]/a")
	public WebElement shopTravelButton;
	
	@FindBy(xpath = "//*[@id='new-header']/section/section[1]/div[2]/button")
	public WebElement categoriesButton;
	
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[3]/button")
	public WebElement cartButton;
	
	@FindBy(xpath = "//*[@id='new-header']/section/section[2]/div[2]/div/div[3]/section/section/section[2]/a")
	public WebElement paymentUnderCartButton;
	
	@FindBy(xpath = "//*[@id='main-menu']/li/button")
	public List<WebElement> categoriesList;
	
	@FindBy(xpath = "//*[contains (@class, 'header-subnav__item-link')]")
	public List<WebElement> bigCategoriesList;
	
	
	
	
}// class
