package TestScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import pages.LoginPage;
import pages.MobileSliderPage;


public class MobileSliderTest extends Base {
	@Test(description="Verify Add Newslider Functionality On MobilesliderPage")
	public void verifyMobileSliderAddnewFunction() {
		String loginAdminUserName = ExcelUtility.getString(0,1,"LoginPage");
		String loginAdminPassword = ExcelUtility.getString(1,1,"LoginPage");
		String categoryType=ExcelUtility.getString(0,1,"MobileSliderPage");
		String filepath = GeneralUtility.MOBILESLIDERIMAGEFILE;
		String expectedAlertMessage=ExcelUtility.getString(1,1,"MobileSliderPage");
		LoginPage loginPage = new LoginPage(driver);
		MobileSliderPage mobileslider = new MobileSliderPage(driver);
		loginPage.enterUserNameOnUserNameField(loginAdminUserName).enterPasswordOnPasswordField(loginAdminPassword).clickOnSignInButton();
		mobileslider.clickOnMobileSliderMoreInfolink().clickOnAddNewButton().selectCategoryFromDropdown(categoryType).
		uploadImageFile(filepath);
		mobileslider.clickOnSaveButton();
		String actualAlertMessage=mobileslider.issuccsessAlertDiplayed();
		assertTrue(actualAlertMessage.contains(expectedAlertMessage)," Slider not created!");
		
	}

}
