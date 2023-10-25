package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUploadUtility;
import Utilities.PageUtility;


public class ManageOfferCodePage {
	
public WebDriver driver;
	
	public ManageOfferCodePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-offercode'and@class='small-box-footer']")WebElement ManageOfferCodeMoreInfoLink;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement createNewOfferButton;
	@FindBy(xpath = "//input[@id='offer_code']")WebElement enterOfferCodeTextFeild;
	@FindBy(xpath = "//input[@value='yes']")WebElement inputYesRadioButton;
	@FindBy(xpath = "//input[@placeholder='Percentage']")WebElement enterPercentageTextFeild;
	@FindBy(xpath = "//input[@placeholder='Amount']")WebElement enterAmountTextFeild;
	@FindBy(xpath = "//div[@role='textbox']")WebElement enterDiscriptionTextFeild;
	@FindBy(xpath = "//input[@id='main_img']")WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='create']")WebElement saveFileButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement offercodeCreatedSuccessAlertBox;
	public ManageOfferCodePage clickOnManageOfferCodeMoreInfoLink() {
		ManageOfferCodeMoreInfoLink.click();
		return this;
	}
	public ManageOfferCodePage clickOncreateNewOfferButton() {
		createNewOfferButton.click();
		return this;
	}
	
	public ManageOfferCodePage enterOfferCodeOnEnterOfferCodeTextFeild(String OfferCode) 
	{
		enterOfferCodeTextFeild.sendKeys(OfferCode);
		return this;
	}
	  public ManageOfferCodePage clickOnSelectUserRadioButton() {
		  PageUtility.javascriptExcecuterForClick(driver, inputYesRadioButton);
			 //inputYesRadioButton.click();
		  return this;
			  
		  }
		public ManageOfferCodePage enterPercentageonEnterPercentageTextFeild(String percentage) 
		{
			enterPercentageTextFeild.sendKeys(percentage);
			return this;
		}
		public ManageOfferCodePage enterAmountOnAmountTextFeild(String amount) 
		{
			enterAmountTextFeild.sendKeys(amount);
			return this;
		}
		public ManageOfferCodePage enterDiscriptionOnDiscriptionTextFeild(String discription) 
		{
			enterDiscriptionTextFeild.sendKeys(discription);
			return this;
		}
		
		 public ManageOfferCodePage uploadImageFile(String filepath )
		   {
			FileUploadUtility.fileUploadUsingSendKeys(chooseFileButton, filepath);
			return this;
		   }
		   public ManageOfferCodePage clickOnSaveButton() 
		  {
			PageUtility.javascriptExcecuterForClick(driver, saveFileButton);
			//WaitUtility.waitForElementTobeClickable(driver, saveFileButton);
			//saveFileButton.click();
			return this;
		  }
		   public String issuccsessAlertDiplayed() {
			   String alertText= offercodeCreatedSuccessAlertBox.getText();
			   return alertText;
			   
		   }
}
