package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtility;

public class LoginPage {

	
public WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='username']") WebElement userNameFiled;
	@FindBy(xpath = "//input[@name='password']") WebElement passwordFiled;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement SignInButton;
	@FindBy(xpath = "//div[@class='inner']//child::p[text()='Manage Pages']")WebElement ManagePageInHome;
	
	
public LoginPage clickOnSignInButton() {
	WaitUtility.waitForElementTobeClickable(driver, SignInButton);
	SignInButton.click();
	return this;
		}
	
public LoginPage enterPasswordOnPasswordField(String password) {
		
	passwordFiled.sendKeys(password);
		return this;
		
	}
	
	public LoginPage enterUserNameOnUserNameField(String userName) {
		
		userNameFiled.sendKeys(userName);
		return this;
		
	}
	public boolean isHomePageDisplayed() {
		return ManagePageInHome.isDisplayed();
	}
	
	
}
