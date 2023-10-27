package TestScript;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;



import Utilities.ExcelUtility;
import pages.LoginPage;
import pages.ManagePagesPage;

public class ManagePagesTest extends Base{
	@Test(description="Verify searchlist Functionality On ManagePages Page")
	public void verifySerachListFuctionality() {
		String loginAdminUserName = ExcelUtility.getString(0,1,"LoginPage");
		String loginAdminPassword = ExcelUtility.getString(1,1,"LoginPage");
		String searchListInputText=ExcelUtility.getString(0,1,"ManagePagesPage");
		ManagePagesPage managePagesPage = new ManagePagesPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(loginAdminUserName).enterPasswordOnPasswordField(loginAdminPassword).clickOnSignInButton();
		managePagesPage.clickOnManagePagesMoreInfo().clickOnListSearchButton().enterSearchDataonSearchTextFeild(searchListInputText).clickOnSearchButton();
		List <String> categoryList=managePagesPage.checkActualSearchisDisplayed();
		assertTrue(categoryList.contains(searchListInputText),"search item"+searchListInputText+" is not found and displayed");
			
	}

}
