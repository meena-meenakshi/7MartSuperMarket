package TestScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Retry.Retry;
import Utilities.ExcelUtility;
import pages.LoginPage;

public class LoginTest extends Base{
	@Test(groups = {"regression"},description="Verify whether user is able to login using valid username and password")
	public void verifyUserLoginwithValidCredentials() {
		String inputValidUserName = ExcelUtility.getString(0,1,"LoginPage");
		String inputValidPassword = ExcelUtility.getString(1,1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(inputValidUserName).enterPasswordOnPasswordField(inputValidPassword).clickOnSignInButton();
		boolean isHomePageAvailable=loginPage.isHomePageDisplayed();
		assertTrue(isHomePageAvailable, "user unable to login!with valid credentials");
	}
	@Test(groups = {"regression"},description="Verify whether user is able to login using invalid username and password",retryAnalyzer = Retry.class)
	public void verifyUserLoginwithInValidCredentials() {
		String inputInvalidUserName = ExcelUtility.getString(2, 1, "LoginPage");
		String inputInvalidPassword = ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(inputInvalidUserName).enterPasswordOnPasswordField(inputInvalidPassword).clickOnSignInButton();
		boolean isAlertmessageAvailable= loginPage.isAlertDiplayed();
		assertTrue(isAlertmessageAvailable," user able to login!with Invalid credentials");
	}
	@Test(groups = {"smoke"},description="Verify whether user is able to login using valid valid username and Invalidpassword")
	public void verifyUserLoginwithValidUsernameandInvalidPassword() {
		String inputValidUserName = ExcelUtility.getString(4, 1, "LoginPage");
		String inputInvalidPassword = ExcelUtility.getString(5, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(inputValidUserName).enterPasswordOnPasswordField(inputInvalidPassword).clickOnSignInButton();
		boolean isAlertmessageAvailable= loginPage.isAlertDiplayed();
		assertTrue(isAlertmessageAvailable," user able to login!with Invalid credentials");
	}
	@Test(dataProvider = "LoginProvider",groups = {"regression","smoke"},description="Verify whether user is able to login using Invalid username and valid password")
	public void verifyUserLoginwithInValidUsernameAndValidPassword(String inputInvalidUserName,String inputValidPassword) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(inputInvalidUserName).enterPasswordOnPasswordField(inputValidPassword).clickOnSignInButton();
		boolean isAlertmessageAvailable= loginPage.isAlertDiplayed();
		assertTrue(isAlertmessageAvailable," user able to login!with Invalid credentials");
	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(6, 1, "LoginPage"), ExcelUtility.getString(7, 1, "LoginPage") },

		};
	}
}
