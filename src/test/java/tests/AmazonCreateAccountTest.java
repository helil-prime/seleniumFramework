package tests;

import org.testng.annotations.Test;

public class AmazonCreateAccountTest {
  @Test
  public void f() {
	 System.out.println("This is create account tests on Thread : " + Thread.currentThread().getId());
	  Driver.getDriver().get("https://amazon.com");
  }
  
  
  @Test
  public void test() {
	 System.out.println("This is create account tests on Thread : " + Thread.currentThread().getId());
	  Driver.getDriver().get("https://google.com");
  }
}
