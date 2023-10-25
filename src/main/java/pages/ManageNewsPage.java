package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement ManageNewsMoreInfoLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement addNewsNewButton;
	@FindBy(xpath = "//textarea[@id='news']") WebElement enterNewsTextFiled;
	@FindBy(xpath = "//button[@name='create']")WebElement newsSaveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement newsCreatedSuccessAlertBox;
	
	public ManageNewsPage clickOnManageNewsMoreInfoLink() {
		PageUtility.javascriptExcecuterForClick(driver, ManageNewsMoreInfoLink);
		//ManageNewsMoreInfoLink.click();
		return this;
	}
	
	public ManageNewsPage clickOnAddNewNewsButton() {
		PageUtility.javascriptExcecuterForClick(driver, addNewsNewButton);
		//addNewsNewButton.click();
		return this;
	}
	public ManageNewsPage enterNewsOnEnterNewsTextFiled(String newsText) {
		enterNewsTextFiled.sendKeys(newsText);
		return this;
	}
	public void clickOnSaveButton() {
		PageUtility.javascriptExcecuterForClick(driver, newsSaveButton);
		//newsSaveButton.click();
	}
	 public String issuccsessAlertDiplayed() {
		   String alertText= newsCreatedSuccessAlertBox.getText();
		   return alertText;
		   
	   }
}
