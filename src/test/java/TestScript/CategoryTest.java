package TestScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import Utilities.ExcelUtility;
import pages.CategoryPage;
import pages.LoginPage;

public class CategoryTest extends Base{
	@Test
	public void verifySearchFunctionalityOfSearchButtononInCategoryPage() {
		
		String inputUserName = ExcelUtility.getString(0,1,"CategoryPage");
		String inputPassword = ExcelUtility.getString(1,1,"CategoryPage");
		String categorySearchInputText=ExcelUtility.getString(2,1,"CategoryPage");
		
		CategoryPage categoryPage = new CategoryPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUserNameOnUserNameField(inputUserName).enterPasswordOnPasswordField(inputPassword).clickOnSignInButton();
		categoryPage.clickOnCategoryMoreInfo();
		categoryPage.clickOnSearchButton();
		categoryPage.enterSearchDataonSearchTextFeild(categorySearchInputText).clickOnCategorySearchButton();
		
		List <String> categoryList=categoryPage.checkActualSearchisDisplayed();
		assertTrue(categoryList.contains(categorySearchInputText),"Category search item"+categorySearchInputText+" is not found and displayed");
			
		
	}
	@Test
	public void verifyAddcategoryFunctionalityInCategoryPage() 
	{
		String inputValidUserName = ExcelUtility.getString(0,1,"LoginPage");
		String inputValidPassword = ExcelUtility.getString(0,1,"LoginPage");
		String category =ExcelUtility.getString(4,1,"CategoryPage");
		String expectedAlertMessage =ExcelUtility.getString(5,1,"CategoryPage");
		
		CategoryPage categoryPage = new CategoryPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUserNameOnUserNameField(inputValidUserName).enterPasswordOnPasswordField(inputValidPassword).clickOnSignInButton();
		categoryPage.clickOnCategoryMoreInfo().
		clickOnNewButton().
		enterCategoryOnCategoryEnterField(category).
		clickOnSelectGroupButton();
		categoryPage.uploadImageFile();
		//categoryPage.clickOnTopRadioButton().categoryPage.clickonLeftRadioButton();
		categoryPage.clickOnSaveButton();
		String actualAlertMessage= categoryPage.issuccsessAlertDiplayed();
		assertEquals(actualAlertMessage.contains(expectedAlertMessage)," Category not created!");
		
		
	}
	@Test
	public void verifyChangeStatusButtonFuctinalityActiveTOInactive() {
		String inputValidUserName = ExcelUtility.getString(0,1,"LoginPage");
		String inputValidPassword = ExcelUtility.getString(0,1,"LoginPage");
		//String expectedStatusText="Inactive";
		String expectedStatusText = ExcelUtility.getString(3,1,"CategoryPage");
		CategoryPage categoryPage = new CategoryPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterUserNameOnUserNameField(inputValidUserName).enterPasswordOnPasswordField(inputValidPassword).clickOnSignInButton();
		categoryPage.clickOnCategoryMoreInfo();
		categoryPage.clickonActiveStatusButton();
		String actuaStatusText=categoryPage.checkStatusHasChangedToInActive();
		assertEquals(actuaStatusText,expectedStatusText,"Not able to change Status ");
		
	}
	

	}
	
	
