package TestScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import pages.AdminUsersPage;
import pages.LoginPage;

public class AdminUsersTest extends Base {
	@Test
	public void verifyAddUserFunctionalityOnAdminUsersPage() {
		String loginAdminUserName = ExcelUtility.getString(0,1,"LoginPage");
		String loginAdminPassword = ExcelUtility.getString(1,1,"LoginPage");
		String inputUserName = ExcelUtility.getString(0,1,"AdminUserPage");
		String inputUserPassword = ExcelUtility.getString(1,1,"AdminUserPage");
		String userType= ExcelUtility.getString(2,1,"AdminUserPage");
		//String expectedAlertMessage="User Created Successfully";
		String expectedAlertMessage = ExcelUtility.getString(4,1,"AdminUserPage");
		
		AdminUsersPage adminuserPage = new AdminUsersPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	loginPage.enterUserNameOnUserNameField(loginAdminUserName).enterPasswordOnPasswordField(loginAdminPassword).clickOnSignInButton();
	adminuserPage.clickOnAdminUsersMoreInfolink().clickOnAddNewButton();
	adminuserPage.enterUsernameOnUsernameFeild(inputUserName).
	enterPasswordOnPasswordFeild(inputUserPassword).
	selectUsertype(userType).
	clickOnSaveButton();
	String actualAlertMessage= adminuserPage.issuccsessAlertDiplayed();
	assertTrue(actualAlertMessage.contains(expectedAlertMessage)," not able to acreate new user");
	}

}
