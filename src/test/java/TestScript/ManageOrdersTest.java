package TestScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;



import Utilities.ExcelUtility;
import pages.LoginPage;
import pages.ManageOrdersPage;

public class ManageOrdersTest extends Base{
	@Test(description="Verify change delivery date  Functionality On ManageOrdersPage")
	public void verifyChangeDeliveryDateButtonFunctionality() {
		String loginAdminUserName = ExcelUtility.getString(0,1,"LoginPage");
		String loginAdminPassword = ExcelUtility.getString(1,1,"LoginPage");
		String  date = ExcelUtility.getNumeric(0, 1, "ManageOrdersPage");
		String amTime =ExcelUtility.getNumeric(1, 1, "ManageOrdersPage");;
		String pmTime =ExcelUtility.getNumeric(2, 1, "ManageOrdersPage");;
		String expectedAlertMessage=ExcelUtility.getString(3, 1, "ManageOrdersPage");
		ManageOrdersPage manageorderpage = new ManageOrdersPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(loginAdminUserName).enterPasswordOnPasswordField(loginAdminPassword).clickOnSignInButton();
		manageorderpage.
		clickOnManageOrdersMoreInfo().
		clickOnchangeDeliverDateButton().
		enterDeliveryDateondatepickerFeild(date).
		enterDeliveryTimeinAMonTimePicker(amTime).
		enterDeliveryTimeinPMonTimePicker(pmTime).
		clickOnupdateButton();
		String actualAlertMessage=manageorderpage.issuccsessAlertDiplayed();
		assertTrue(actualAlertMessage.contains(expectedAlertMessage)," unable to update deliverydate!");
	}

}
