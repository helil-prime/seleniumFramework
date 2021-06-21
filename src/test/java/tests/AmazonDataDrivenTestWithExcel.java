package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AmazonHomePage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.ExcelUtils;
import utilities.PropertiesReader;

public class AmazonDataDrivenTestWithExcel {
	
//	go to amazon.com 
//	verify that you are on the home page
//	search {testdata} and click search
//	wait for the element to be visible - this could be any searched item or the any text unique to the search. 
//	get text of the search criteria text element 
//	verify it matches the search input
//	 TestData: 
//	                       coffee mug
//	                       pretty coffee mug                   
//	                        cool coffee mug
//	                       cute coffee mug
	
	
	AmazonHomePage amazonHP;
    BrowserUtils utils = new BrowserUtils();
    
    @Test(dataProvider = "myDataBucket")
    public void test(String input) {
  	  Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
  	  amazonHP = new AmazonHomePage();
  	  Assert.assertTrue(amazonHP.searchBox.isDisplayed());
  	  
  	  amazonHP.searchBox.sendKeys(input);	
  	  
  	  amazonHP.searchButton.click();
  	  utils.waitUntilElementVisible(amazonHP.searchResultText);
  	  String searchResultText = amazonHP.searchResultText.getText();
  	  String actualSubStringText = searchResultText.substring(1, searchResultText.length()-1);
  	  Assert.assertEquals(actualSubStringText, input);
    }
    
    @DataProvider
    public Object[] myDataBucket() {          // data provider needs to have object data return type - means not primitive
  	  //  step 1, load the excel file
  	  // step 2,  read the individual cell data and pass to array index
  	String [] mydata = ExcelUtils.getExcelDataInAColimn("C:\\Users\\lenovo\\eclipse-workspace\\seleniumFramework\\ExcelTest.xlsx", "primetech");
  	  
//  	  mydata[0] = "coffee mug";
//  	  mydata[1] = "pretty coffee mug";
//  	  mydata[2] = "cool coffee mug";
//  	  mydata[3] = "cute coffee mug";
//  	  mydata[4] = "ugly coffee mug";
  	  
  	  return mydata;
    }
    
    
    
    @BeforeMethod
    public void beforeMethod() {
      Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	  Driver.getDriver();
    }

    @AfterMethod
    public void afterMethod() {
  	  Driver.quitDriver();
    }

}
