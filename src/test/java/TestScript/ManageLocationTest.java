package TestScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;



import Utilities.ExcelUtility;
import pages.LoginPage;
import pages.ManageLocationPage;


public class ManageLocationTest extends Base {
	@Test(description="Verify edit delivery charge functionality of managelocationpage")
	
	public void verifyEditdeliverychargeTextfeildFunctionalityOnManageLocationPage() {
		String loginAdminUserName = ExcelUtility.getString(0,1,"LoginPage");
		String loginAdminPassword = ExcelUtility.getString(1,1,"LoginPage");
		String deliveryCharge = ExcelUtility.getNumeric(3, 1, "ManageLocationPage");
		String expectedAlertMessage = ExcelUtility.getString(4,1,"ManageLocationPage");
		ManageLocationPage managelocationPage = new ManageLocationPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(loginAdminUserName).enterPasswordOnPasswordField(loginAdminPassword).clickOnSignInButton();
		managelocationPage.
		clickOnManageLocatioMoreInfolink().
		clickOneditLocationButton().
		enterDelivyChargeOnDeliveryChargeTextFeild(deliveryCharge).
		clickOnUpdateButton();
		String actualAlertMessage=managelocationPage.issuccsessAlertDiplayed();
		assertTrue(actualAlertMessage.contains(expectedAlertMessage)," not able to Update");
		
		
	}

}
