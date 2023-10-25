package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUploadUtility;
import Utilities.PageUtility;


	public class MobileSliderPage {
		public WebDriver driver;
			
			public MobileSliderPage(WebDriver driver) 
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider' and @class='small-box-footer']")WebElement MobileSliderMoreInfoLink;
			@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement addNewButton;
			@FindBy(xpath = "//select[@id='cat_id']")WebElement selectCategoryDropDownButton;
			@FindBy(xpath = "//input[@id='main_img']")WebElement chooseFileButton;
			@FindBy(xpath = "//button[@name='Create']")WebElement saveButton;
			@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement sliderCreatedSuccessAlertBox;
			
			public MobileSliderPage clickOnMobileSliderMoreInfolink() {
				MobileSliderMoreInfoLink.click();
				return this;
			}
			public MobileSliderPage clickOnAddNewButton() {
				addNewButton.click();
				return this;
			}
			public MobileSliderPage selectCategoryFromDropdown(String categoryType) {
				PageUtility.selectDropdownByText(driver, selectCategoryDropDownButton, categoryType);
				return this;
			}
			
			 public void uploadImageFile(String filepath )
			   {
				FileUploadUtility.fileUploadUsingSendKeys(chooseFileButton, filepath);
			   }
			public MobileSliderPage clickOnSaveButton() {
				saveButton.click();
				return this;
			}
			 public String issuccsessAlertDiplayed() {
				   String alertText= sliderCreatedSuccessAlertBox.getText();
				   return alertText;
				   
			   }
			
}
