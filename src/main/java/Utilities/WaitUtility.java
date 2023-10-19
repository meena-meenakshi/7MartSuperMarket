package Utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	public static final long IMPLICIT_WAIT = 10;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 100;
	
	public static void waitForElement(WebDriver driver, WebElement target) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void waitForElementTobeClickable(WebDriver driver, WebElement target) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	
	public static void waitForvisibilityOfAllElements(WebDriver driver, List<WebElement> target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfAllElements(target));
		
	}
	public static void waitForAlertIsPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	public static void waitForframeToBeAvailableAndSwitchToIt(WebDriver driver,WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(target));
	
	}

}
