package TestScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import org.testng.annotations.Test;



import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import pages.CategoryPage;
import pages.LoginPage;

public class CategoryTest extends Base{
	@Test(description="Verify search category functionality of categorypage")
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
	@Test(description="Verify add new category functionality of categorypage")
	public void verifyAddcategoryFunctionalityInCategoryPage() 
	{
		String inputValidUserName = ExcelUtility.getString(0,1,"LoginPage");
		String inputValidPassword = ExcelUtility.getString(0,1,"LoginPage");
		String category =ExcelUtility.getString(4,1,"CategoryPage");
		String expectedAlertMessage =ExcelUtility.getString(5,1,"CategoryPage");
		String filepath = GeneralUtility.CATEGORYIMAGEFILE;
		CategoryPage categoryPage = new CategoryPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(inputValidUserName).enterPasswordOnPasswordField(inputValidPassword).clickOnSignInButton();
		categoryPage.clickOnCategoryMoreInfo().clickOnNewButton().enterCategoryOnCategoryEnterField(category).clickOnSelectGroupButton().uploadImageFile(filepath);
		categoryPage.clickOnTopRadioButton().clickonLeftRadioButton().clickOnSaveButton();
		String actualAlertMessage= categoryPage.issuccsessAlertDiplayed();
		assertTrue(actualAlertMessage.contains(expectedAlertMessage)," Category not created!");
		
		
	}
	@Test(description="Verify change status functionality of categorypage")
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
	
	
