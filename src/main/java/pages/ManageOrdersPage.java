package pages;

//import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

	public class ManageOrdersPage {
		public WebDriver driver;
			
			public ManageOrdersPage(WebDriver driver) 
			{
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}
			@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order' and @class='small-box-footer']")WebElement ManageOrdersMoreInfoLink;
			@FindBy(xpath = "(//a[contains(@class,'btn-primary btn-sm')])[1]") WebElement changeDeliverDateButton;
			@FindBy(xpath = "(//input[@type='date'])[3]") WebElement datepickerFeild;
			@FindBy(xpath = "(//input[@name='timepicker-one'])[1]")WebElement enterAmTimePicker;
			@FindBy(xpath = "(//input[@name='timepicker-two'])[1]")WebElement enterPMTimePicker;
			@FindBy(xpath = "(//button[@name='Update_st'])[2]")WebElement updateButton;
			//@FindAll(@FindBy(xpath = "//table[contains(@class,'table-sm')]//tr//td[1]")) List<WebElement> ListItems;
			@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement deliveryDateupdatedSuccessAlertBox;
			public ManageOrdersPage clickOnManageOrdersMoreInfo() {
				ManageOrdersMoreInfoLink.click();
				return this;
			}
			public ManageOrdersPage clickOnchangeDeliverDateButton(){
				changeDeliverDateButton.click();
				return this;
			}
			
			public ManageOrdersPage enterDeliveryDateondatepickerFeild(String date) {
				datepickerFeild.sendKeys(date);
				return this;
				
			}
			public ManageOrdersPage enterDeliveryTimeinAMonTimePicker(String AmTime) {
				enterAmTimePicker.clear();
				enterAmTimePicker.sendKeys(AmTime);
				return this;
				
			}
			public ManageOrdersPage enterDeliveryTimeinPMonTimePicker(String PmTime) {
				enterPMTimePicker.clear();
				enterPMTimePicker.sendKeys(PmTime);
				return this;
				
			}
			public ManageOrdersPage clickOnupdateButton(){
				PageUtility.javascriptExcecuterForClick(driver, updateButton);
				//updateButton.click();
				return this;
			}
			 public String issuccsessAlertDiplayed() {
				   String alertText= deliveryDateupdatedSuccessAlertBox.getText();
				   return alertText;
				   
			   }

}
