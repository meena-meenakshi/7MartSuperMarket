package TestScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import Utilities.ExcelUtility;
import Utilities.GeneralUtility;
import pages.LoginPage;
import pages.ManageSliderPage;


public class ManageSliderTest extends Base{
@Test
	public void verifyAddNewSliderFunctinality() {
		
		String loginAdminUserName = ExcelUtility.getString(0,1,"LoginPage");
		String loginAdminPassword = ExcelUtility.getString(1,1,"LoginPage");
		String sliderLink =ExcelUtility.getString(0,1,"ManageSliderPage");
		String expectedAlertMessage=ExcelUtility.getString(1,1,"ManageSliderPage");
		String filepath = GeneralUtility.IMAGEFILE;
		ManageSliderPage managesliderPage = new ManageSliderPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(loginAdminUserName).enterPasswordOnPasswordField(loginAdminPassword).clickOnSignInButton();
		managesliderPage.clickOnManageSliderMoreInfoLink().clickOnAddNewSliderButton().uploadImageFile(filepath);
		managesliderPage.enterSliderLinkOnEnterSliderTextFiled(sliderLink).clickOnSaveButton();

		String actualAlertMessage=managesliderPage.issuccsessAlertDiplayed();
		assertTrue(actualAlertMessage.contains(expectedAlertMessage)," Slider not created!");
		
	}
}
