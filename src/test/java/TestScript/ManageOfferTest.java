package TestScript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import Utilities.ExcelUtility;
import pages.LoginPage;
import pages.ManageOfferCodePage;

public class ManageOfferTest extends Base{
	@Test
	public void verifyAddNewOfferFunctionalityOnManageOfferCodePage() {
		String loginAdminUserName = ExcelUtility.getString(0,1,"LoginPage");
		String loginAdminPassword = ExcelUtility.getString(1,1,"LoginPage");
		String OfferCode=ExcelUtility.getString(0,1,"ManageOfferCodePage");
		String percentage=ExcelUtility.getNumeric(1,1,"ManageOfferCodePage");
		String amount=ExcelUtility.getNumeric(2,1,"ManageOfferCodePage");
		String discription=ExcelUtility.getString(3,1,"ManageOfferCodePage");
		String expectedAlertMessage =ExcelUtility.getString(4,1,"ManageOfferCodePage");
		ManageOfferCodePage manageoffercode = new ManageOfferCodePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameField(loginAdminUserName).enterPasswordOnPasswordField(loginAdminPassword).clickOnSignInButton();
		manageoffercode.clickOnManageOfferCodeMoreInfoLink().clickOncreateNewOfferButton().
		enterOfferCodeOnEnterOfferCodeTextFeild(OfferCode).
		clickOnSelectUserRadioButton().
		enterPercentageonEnterPercentageTextFeild(percentage).
		enterAmountOnAmountTextFeild(amount).
		enterDiscriptionOnDiscriptionTextFeild(discription).
		clickOnSaveButton();
		String actualAlertMessage= manageoffercode.issuccsessAlertDiplayed();
		assertTrue(actualAlertMessage.contains(expectedAlertMessage)," Offer code not created!");
	}

}
