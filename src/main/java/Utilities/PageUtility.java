package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public static void clickAndHoldOnElement(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
		
	}
  public static void contextClickonElement(WebElement element, WebDriver driver) 
  {
	Actions actions = new Actions(driver);
	actions.contextClick(element).build().perform();
   }

  public static void moveToAElement(WebElement element, WebDriver driver) 
  {
	Actions actions = new Actions(driver);
	actions.moveToElement(element).build().perform();
	
   }
  public static void drangAndDropAnElement(WebElement source,WebElement element, WebDriver driver) 
  {
	Actions actions = new Actions(driver);
	actions.dragAndDrop(source, element).build().perform();
	
   }

  public static void doubleClickOnElement(WebElement element, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.doubleClick(element).build().perform();
  }
  public static void SwitchtoAlertGetText(WebDriver driver) {
	  driver.switchTo().alert().getText();
  }
  public static void SwitchtoAlertAndDissmiss(WebDriver driver) {
	  driver.switchTo().alert().dismiss();;
  }
  public static void SwitchtoAlertAndAccept(WebDriver driver) {
	  driver.switchTo().alert().accept();;
  }
  public static void SwitchtoAlertAndSendkeys(WebDriver driver,String value) {
	  driver.switchTo().alert().sendKeys(value);;
  }
  public static void selectDropdownByValue(WebDriver driver,WebElement element, String value) {
	  Select select =new Select(element);
	  select.selectByValue(value);
	  }
  public static void selectDropdownByText(WebDriver driver,WebElement element, String value) {
	  Select select =new Select(element);
	  select.selectByVisibleText(value);
	  }
  public static void selectDropdownByIndex(WebDriver driver,WebElement element, int value) {
	  Select select =new Select(element);
	  select.selectByIndex(value);
	  }
  public static void javascriptExcecuterForClick(WebDriver driver, WebElement element) {
	  JavascriptExecutor excecutor = (JavascriptExecutor)driver;
	  excecutor.executeScript("arguments[0].click()", element);
  }
  
  
}
