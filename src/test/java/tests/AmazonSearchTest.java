package tests;

import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class AmazonSearchTest {
	
	AmazonHomePage amazonHP;
	
	
  @Test
  public void amazonSearchTest() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP = new AmazonHomePage();
	  amazonHP.searchBox.sendKeys("coffee mug");
	  amazonHP.searchButton.click();
	  Thread.sleep(4000);
  }
  
  @Test
  public void dropDownTest() {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP = new AmazonHomePage();
	  BrowserUtils.selectByVisibleText(amazonHP.departmentsDropdown, "Amazon Fresh");
  }
  
  @Test(dependsOnMethods = "amazonSearchTest")
  public void searchResultVerify() throws InterruptedException {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP = new AmazonHomePage();
	  amazonHP.searchBox.sendKeys("coffee mug");
	  amazonHP.searchButton.click();
	  Thread.sleep(3000);
	  System.out.println("Number of items : " + amazonHP.searchItemPrices.size());
	  
	  for (WebElement itemPrice : amazonHP.searchItemPrices) {
		String price = itemPrice.getText();
		  System.out.println(price);
	}
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
