package tests;

import org.testng.annotations.Test;

import utilities.Driver;

public class AmazonItemPurchaseTest {
  @Test
  public void f() {
	  System.out.println("This is purchase item test on Thread : " + Thread.currentThread().getId());
	  Driver.getDriver().get("https://indeed.com");
  }
}
