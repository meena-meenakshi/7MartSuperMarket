package com.obsqura.martSuperMarket;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import Utilities.ScreenShotUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public ScreenShotUtility scrshot;
	public WebDriver driver;
	@BeforeMethod
	public void initilizeBrowser() {
		driver=WebDriverManager.chromedriver().create();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aruna\\eclipse-workspace\\7martSuperMarket\\src\\main\\java\\com\\obsqura\\martSuperMarket\\Resources\\chromedriver.exe" );
		driver = new ChromeDriver();
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
