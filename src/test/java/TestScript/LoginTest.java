package TestScript;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import Utilities.ExcelUtility;
import pages.LoginPage;

public class LoginTest extends Base{
	@Test
	public void verifyUserLoginwithValidCredentials() {
		String inputValidUserName = ExcelUtility.getString(0,1,"LoginPage");
		String inputValidPassword = ExcelUtility.getString(1,1,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(inputValidUserName).enterPasswordOnPasswordField(inputValidPassword).clickOnSignInButton();
		boolean isHomePageAvailable=loginPage.isHomePageDisplayed();
		assertTrue(isHomePageAvailable, "user unable to login!with valid credentials");
	}
	@Test
	public void verifyUserLoginwithInValidCredentials() {
		String inputInvalidUserName = ExcelUtility.getString(2, 1, "LoginPage");
		String inputInvalidPassword = ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(inputInvalidUserName).enterPasswordOnPasswordField(inputInvalidPassword).clickOnSignInButton();
		boolean isHomePageAvailable=loginPage.isHomePageDisplayed();
		assertFalse(isHomePageAvailable, "user unable to login!In valid username or password");
	}
	@Test
	public void verifyUserLoginwithValidUsernameandInvalidPassword() {
		String inputValidUserName = ExcelUtility.getString(4, 1, "LoginPage");
		String inputInvalidPassword = ExcelUtility.getString(5, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(inputValidUserName).enterPasswordOnPasswordField(inputInvalidPassword).clickOnSignInButton();
		boolean isHomePageAvailable=loginPage.isHomePageDisplayed();
		assertFalse(isHomePageAvailable, "user unable to login!In valid username or password");
	}
	@Test
	public void verifyUserLoginwithInValidUsernameAndValidPassword() {
		String inputInvalidUserName = ExcelUtility.getString(6, 1, "LoginPage");
		String inputValidPassword = ExcelUtility.getString(7, 1, "LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(inputInvalidUserName).enterPasswordOnPasswordField(inputValidPassword).clickOnSignInButton();
		boolean isHomePageAvailable=loginPage.isHomePageDisplayed();
		assertFalse(isHomePageAvailable, "user unable to login!In valid username or password");
	}
	

}
