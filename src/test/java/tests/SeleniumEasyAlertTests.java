package tests;

import org.testng.annotations.Test;
import pages.SeleniumEasyAlertPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SeleniumEasyAlertTests {
	
	SeleniumEasyAlertPage alertPage;
	BrowserUtils utils = new BrowserUtils();
	
	
  @Test(priority=2, description="This is first Alert accept test.")
  public void firstAlertTest() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertUrl"));
	  alertPage = new SeleniumEasyAlertPage();
	  alertPage.firstAlertBtn.click(); 
	  // calling the swithToAlert function
	  utils.switchToAlert();
	  utils.waitUntilAlertIsPresent();
	  String expectedMessage = "I am an alert box!";
	  String actualMessage = utils.alertGetText();
	  Assert.assertEquals(actualMessage, expectedMessage);
	  Thread.sleep(3000);
	  utils.alertAccept();
	  System.out.println("Thread id " + Thread.currentThread().getId());
  }
  
  @Test(priority=1, description="This is second Alert dismiss test.")
  public void secondAlertTest() throws InterruptedException {
	  String expectedMessage = "Press a button!";
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertUrl"));
	  alertPage = new SeleniumEasyAlertPage();
	  alertPage.secondAlertBtn.click();
	  utils.switchToAlert();
	  utils.waitUntilAlertIsPresent();
	  String actualMessage = utils.alertGetText();
	  Assert.assertEquals(actualMessage, expectedMessage);
	  Thread.sleep(3000);
	  utils.alertDismiss();
	  System.out.println("Thread id " + Thread.currentThread().getId());
  }
  
  @Test(priority=3, description="This is the Third Alert enter name test.")
  public void thirdAlertTest() throws InterruptedException {
	  String expectedMessage = "Please enter your name";
	  Driver.getDriver().get(PropertiesReader.getProperty("seleniumEasyAlertUrl"));
	  alertPage = new SeleniumEasyAlertPage();
	  alertPage.thirdAlertBtn.click();
	 
	  utils.switchToAlert();
	  String actualMessage = utils.alertGetText();
	  Assert.assertEquals(actualMessage, expectedMessage);
	  
	  utils.sendKeysOnAlert("John");
	  Thread.sleep(3000);
	  utils.alertAccept();
	  Thread.sleep(3000);
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterTest() {
	  Driver.quitDriver();
  }

}
