package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import Utilities.ExcelUtility;
import Utilities.PageUtility;

public class ManageLocationPage {
public WebDriver driver;
	
	public ManageLocationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location' and @class='small-box-footer']")WebElement ManageLocationMoreInfoLink;
	@FindBy(xpath = "(//a[contains(@class,'btncss')])[1]") WebElement editLocationButton;
	
	@FindBy(xpath = "//select[@id='country_id']") WebElement selectCountryDropdown;
	@FindBy(xpath = "//select[@id='st_id']") WebElement selectStateDropDown;
	@FindBy(xpath = "//input[@id='location']")WebElement enterLocationTextFeild;
	@FindBy(xpath = "//input[@id='delivery']")WebElement enterDelivyChargeTextFeild;
	@FindBy(xpath = "//button[@name='update']")WebElement updateButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement updateLocationAlertBox;

	public ManageLocationPage clickOnManageLocatioMoreInfolink() {
		ManageLocationMoreInfoLink.click();
		return this;
	}
	public ManageLocationPage clickOneditLocationButton() {
		editLocationButton.click();
		return this;
	}
	public ManageLocationPage selectCountryFromDropdown(String country) {
		//String country= "United Kingdom";
		//ExcelUtility.getString(2,1,"AdminUserPage");
		PageUtility.selectDropdownByText(driver, selectCountryDropdown, country);
		return this;
	}
	public ManageLocationPage selectStateFromDropDown(String state) {
		//String state="Bedfordshire" ;
		//ExcelUtility.getString(2,1,"AdminUserPage");
		PageUtility.selectDropdownByText(driver, selectStateDropDown, state);
		return this;
	}
	public ManageLocationPage enterLocationOnLocationTextFeild(String location) {
		enterLocationTextFeild.sendKeys(location);
		return this;
	}
	public ManageLocationPage enterDelivyChargeOnDeliveryChargeTextFeild(String deliveryCharge ) {
		enterDelivyChargeTextFeild.clear();
		//String deliveryChargeInString= Integer.toString(deliveryCharge);
		enterDelivyChargeTextFeild.sendKeys(deliveryCharge);
		return this;
	}
	
	public ManageLocationPage clickOnUpdateButton() {
		PageUtility.javascriptExcecuterForClick(driver, updateButton);
		
		return this;
	}
	 public String issuccsessAlertDiplayed() {
		   String alertText= updateLocationAlertBox.getText();
		   return alertText;
		   
	   }
}
