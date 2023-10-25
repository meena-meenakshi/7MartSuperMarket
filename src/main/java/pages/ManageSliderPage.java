package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUploadUtility;
import Utilities.PageUtility;

public class ManageSliderPage {
	public WebDriver driver;
	public ManageSliderPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider' and @class='small-box-footer']")WebElement ManageSliderMoreInfoLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement addSliderNewButton;
	@FindBy(xpath = "//input[@id='main_img']")WebElement chooseFileButton;
	@FindBy(xpath = "////input[@id='link']") WebElement enterLinkTextFiled;
	@FindBy(xpath = "//button[@name='create']")WebElement sliderSaveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement sliderCreatedSuccessAlertBox;
	
	public ManageSliderPage clickOnManageSliderMoreInfoLink() {
		PageUtility.javascriptExcecuterForClick(driver, ManageSliderMoreInfoLink);
		//ManageNewsMoreInfoLink.click();
		return this;
	}
	
	public ManageSliderPage clickOnAddNewSliderButton() {
		PageUtility.javascriptExcecuterForClick(driver, addSliderNewButton);
		//addNewsNewButton.click();
		return this;
	}
	 public void uploadImageFile(String filepath)
	   {
		FileUploadUtility.fileUploadUsingSendKeys(chooseFileButton, filepath);
	   }
	public ManageSliderPage enterSliderLinkOnEnterSliderTextFiled(String sliderLink) {
		enterLinkTextFiled.sendKeys(sliderLink);
		return this;
	}
	public ManageSliderPage clickOnSaveButton() {
		PageUtility.javascriptExcecuterForClick(driver, sliderSaveButton);
		//newsSaveButton.click();
		return this;
	}
	 public String issuccsessAlertDiplayed() {
		   String alertText= sliderCreatedSuccessAlertBox.getText();
		   return alertText;
		   
	   }
}
