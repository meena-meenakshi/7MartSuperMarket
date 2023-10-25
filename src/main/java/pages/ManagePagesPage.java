package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtility;

public class ManagePagesPage {
public WebDriver driver;
	
	public ManagePagesPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page' and @class='small-box-footer']")WebElement ManagePagesMoreInfoLink;
	@FindBy(xpath = "//a[@onclick='click_button(2)']") WebElement searchListButton;
	@FindBy(xpath = "//input[@placeholder='Title']") WebElement searchTitleTextFiled;
	@FindBy(xpath = "//button[@name='Search']")WebElement searchButton;
	@FindAll(@FindBy(xpath = "//table[contains(@class,'table-sm')]//tr//td[1]")) List<WebElement> ListItems;

	public ManagePagesPage clickOnManagePagesMoreInfo() {
		ManagePagesMoreInfoLink.click();
		return this;
	}
	public ManagePagesPage clickOnListSearchButton(){
		searchListButton.click();
		return this;
	}
	
	public ManagePagesPage enterSearchDataonSearchTextFeild(String categorySearchText) {
		searchTitleTextFiled.sendKeys(categorySearchText);
		return this;
		
	}
	public ManagePagesPage clickOnSearchButton(){
		searchButton.click();
		return this;
	}
	public List<String> checkActualSearchisDisplayed() 
	{
		List < String> newItemList = new ArrayList<String>();
		for(WebElement category : ListItems) {
			WaitUtility.waitForvisibilityOfAllElements(driver, ListItems);
			newItemList.add(category.getText());
	}
	return newItemList;

}
}
