package tests;

import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AmazonSearchTest {
	
	AmazonHomePage amazonHP = new AmazonHomePage();
	
	
  @Test
  public void amazonSearchTest() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP.searchBox.sendKeys("coffee mug");
	  amazonHP.searchButton.click();
	  Thread.sleep(4000);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  Driver.getDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  Driver.quitDriver();
  }

}
