package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtility;
import Utilities.FileUploadUtility;
import Utilities.GeneralUtility;
import Utilities.PageUtility;


public class CategoryPage {

	
	
public WebDriver driver;
	
	public CategoryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'and@class='small-box-footer']")WebElement CategoryMoreInfoLink;
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchButton;
	@FindBy(xpath = "//input[@placeholder='Category']") WebElement categorySearchTextFeild;
	@FindBy(xpath = "//button[@value='sr']")WebElement categorySearchButton;
	@FindAll(@FindBy(xpath = "//table[contains(@class,'table-sm')]//tr//td[1]")) List<WebElement> categoryList;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")WebElement categoryNewButton;
	@FindBy(xpath = "//input[@name='category']")WebElement enterCategoryTextFeild;
	@FindBy(xpath = "//input[@id='main_img']")WebElement chooseFileButton;
	@FindBy(xpath = "//li[contains(@id,'134-selectable')]")WebElement selectGroupButton;
	@FindBy(xpath = "//input[contains(@name,'top_menu') and @value='no']")WebElement ShowOnTopMenuRadioButton;
	@FindBy(xpath = "//input[contains(@name,'show_home') and @value='no']")WebElement ShowOnLeftMenuRadioButton;
	@FindBy(xpath = "//button[@name='create']")WebElement saveFileButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")WebElement categorySuccessAlertBox;
	@FindBy(xpath = "(//span[contains(@class,'bg-success')])[1]")WebElement activeStatusButton;
	@FindBy(xpath = "(//span[contains(@class,'badge bg-warning')])[1]")WebElement InactiveStatusButton;
	
	public CategoryPage clickOnCategoryMoreInfo() {
		CategoryMoreInfoLink.click();
		return this;
	}
	public CategoryPage clickOnSearchButton(){
		searchButton.click();
		return this;
	}
	
	public CategoryPage enterSearchDataonSearchTextFeild(String categorySearchText) {
		categorySearchTextFeild.sendKeys(categorySearchText);
		return this;
		
	}
	public CategoryPage clickOnCategorySearchButton(){
		categorySearchButton.click();
		return this;
	}
	
	public List<String> checkActualSearchisDisplayed() 
	{
		List < String> newcategoryList = new ArrayList<String>();
		for(WebElement category : categoryList) {
			WaitUtility.waitForvisibilityOfAllElements(driver, categoryList);
			newcategoryList.add(category.getText());
	}
	return newcategoryList;

}
	public CategoryPage clickOnNewButton() {
		categoryNewButton.click();
		return this;
	}
	
	public CategoryPage enterCategoryOnCategoryEnterField(String newCategoryItem) 
	{
		enterCategoryTextFeild.sendKeys(newCategoryItem);
		return this;
	}

	 public void clickOnSelectGroupButton() {
		 PageUtility.moveToAElement(selectGroupButton, driver);
		 selectGroupButton.click();
	 }
	  public void clickOnTopRadioButton() {
		 WaitUtility.waitForElementTobeClickable(driver, ShowOnTopMenuRadioButton);
		  ShowOnTopMenuRadioButton.click();
		  
	  }
	  public void clickonLeftRadioButton() {
		  WaitUtility.waitForElementTobeClickable(driver, ShowOnLeftMenuRadioButton);
		  ShowOnLeftMenuRadioButton.click();
	  }
    public void uploadImageFile()
   {
	String filepath = GeneralUtility.IMAGEFILE;
	FileUploadUtility.fileUploadUsingSendKeys(chooseFileButton, filepath);
   }
   public void clickOnSaveButton() 
  {
	PageUtility.javascriptExcecuterForClick(driver, saveFileButton);
	//WaitUtility.waitForElementTobeClickable(driver, saveFileButton);
	saveFileButton.click();
  }
   public String issuccsessAlertDiplayed() {
	   String alertText= categorySuccessAlertBox.getText();
	   return alertText;
	   
   }
 
	public void clickonActiveStatusButton() {
		activeStatusButton.click();
		
	}
	public String checkStatusHasChangedToInActive() {
	String status =	InactiveStatusButton.getText();
	return status;
		
	}
}


