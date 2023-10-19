package com.obsqura.martSuperMarket;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login extends Base {
@Test

	public void verifyUserLoginwithValidCredentials() {
		String inputUserName = "admin";
		String inputPassword = "admin";
		//String expectedUsername = "admin";
		//String expectedPssword ="admin";
		
		WebElement userNameFeild=driver.findElement(By.name("username"));
		userNameFeild.sendKeys(inputUserName);
		
		WebElement passwordFeild=driver.findElement(By.name("password"));
		passwordFeild.sendKeys(inputPassword);
		
		WebElement SignInButton=driver.findElement(By.xpath("//button[text()='Sign In']"));
		SignInButton.click();
		
		WebElement ManagePageInHome= driver.findElement(By.xpath("//div[@class='inner']//child::p[text()='Manage Pages']"));
		boolean value=ManagePageInHome.isDisplayed();
		assertTrue(value,"User is unabled to login with valid credentials ");
		
	}
}
