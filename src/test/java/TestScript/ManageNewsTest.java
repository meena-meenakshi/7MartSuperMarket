package TestScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;



import Utilities.ExcelUtility;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base{

	@Test
	public void verifyAddNewNewsButtonFunctionalityOnManageNewsPage() {
		
		String loginAdminUserName = ExcelUtility.getString(0,1,"LoginPage");
		String loginAdminPassword = ExcelUtility.getString(1,1,"LoginPage");
		String newsText=ExcelUtility.getString(0,1,"ManageNewsPage");
		String expectedAlertMessage=ExcelUtility.getString(1,1,"ManageNewsPage");
		ManageNewsPage managenewsPage = new ManageNewsPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(loginAdminUserName).enterPasswordOnPasswordField(loginAdminPassword).clickOnSignInButton();
		managenewsPage.clickOnManageNewsMoreInfoLink().
		clickOnAddNewNewsButton().
		enterNewsOnEnterNewsTextFiled(newsText).
		clickOnSaveButton();
		String actualAlertMessage=managenewsPage.issuccsessAlertDiplayed();
		assertTrue(actualAlertMessage.contains(expectedAlertMessage)," News not created!");
	}
	
}
