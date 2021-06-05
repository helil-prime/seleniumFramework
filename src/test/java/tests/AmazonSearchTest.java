package tests;

import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.apache.commons.io.output.BrokenWriter;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonSearchTest {
	
	AmazonHomePage amazonHP;
	BrowserUtils utils = new BrowserUtils();
	
	
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
	  System.out.println("Thread id " + Thread.currentThread().getId());
  }
  
 // scenario:  go to amazon and perform a series of search tests based on the search criteria provided. 
 // verify the search criteria is displayed on the search result page. 
  
  
  @Test(dataProvider = "searchTestData")
  public void searchTest(String input) {
	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	  amazonHP = new AmazonHomePage();
	  Assert.assertTrue(amazonHP.searchBox.isDisplayed());
	  amazonHP.searchBox.sendKeys(input);
	  amazonHP.searchButton.click();
	  utils.waitUntilElementIsVisible(amazonHP.searchCriteriaText);
	  String searchText = amazonHP.searchCriteriaText.getText();
	  System.out.println(searchText);
	  String afterSubString = input.substring(0, input.length());
	  Assert.assertEquals(afterSubString, input);
	  System.out.println("Thread id " + Thread.currentThread().getId());
  }
  
  
  @DataProvider
  public String[] searchTestData(){
	  String[] testData = new String[4];
	  
	  testData[0] = "Coffee mug";
	  testData[1] = "Pretty Coffee mug";
	  testData[2] = "Cool Coffee mug";
	  testData[3] = "Amazing Coffee mug";
	  
//	  testData[0][0] = "Coffee mug";
//	  testData[0][0] = "Coffee mug";
//	  testData[0][0] = "Coffee mug";
//	  testData[0][0] = "Coffee mug";
	  
	  return testData;
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
