package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Utilities.PageUtility;

public class AdminUsersPage {
public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement AdminUsersyMoreInfoLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement adminUserNewButton;
	
	@FindBy(xpath = "//input[@id='username']") WebElement userNameFiled;
	@FindBy(xpath = "//input[@id='password']") WebElement passwordFiled;
	@FindBy(xpath = "//select[@id='user_type']")WebElement selectUserTypeButton;
	@FindBy(xpath = "//button[@name='Create']")WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement NewUserAddedSuccessAlertBox;
	
	
	public AdminUsersPage clickOnAdminUsersMoreInfolink() {
		AdminUsersyMoreInfoLink.click();
		return this;
	}
	
	public AdminUsersPage clickOnAddNewButton() {
		adminUserNewButton.click();
		return this;
	}
	public AdminUsersPage enterUsernameOnUsernameFeild(String username) {
		userNameFiled.sendKeys(username);
		return this;
	}
	public AdminUsersPage enterPasswordOnPasswordFeild(String password) {
		passwordFiled.sendKeys(password);
		return this;
	}
	
	public AdminUsersPage selectUsertype(String userType) {
		PageUtility.selectDropdownByText(driver, selectUserTypeButton, userType);
		return this;
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	 public String issuccsessAlertDiplayed() {
		   String alertText= NewUserAddedSuccessAlertBox.getText();
		   return alertText;
		   
	   }
	
}
