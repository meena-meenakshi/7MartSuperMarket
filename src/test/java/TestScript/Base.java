package TestScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ScreenShotUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public ScreenShotUtility scrshot;
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initilizeBrowser(String browser) throws Throwable {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=WebDriverManager.chromedriver().create();
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=WebDriverManager.firefoxdriver().create();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=WebDriverManager.edgedriver().create();
		}
		else {
			throw new Exception("Browser is not correct");
		}
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void driverClose(ITestResult iTestResult) throws IOException {
	if (iTestResult.getStatus() == ITestResult.FAILURE)
	{
		scrshot = new ScreenShotUtility();
		scrshot.getScreenShot(driver, iTestResult.getName());
	}
			
			driver.quit();
			
	}	   

}
