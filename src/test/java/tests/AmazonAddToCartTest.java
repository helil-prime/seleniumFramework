package tests;

import org.testng.annotations.Test;


public class AmazonAddToCartTest {
	
	
  @Test
  public void f() {
	  System.out.println("This is add to cart tests on Thread: " + Thread.currentThread().getId());
	  
  }
  
  @Test
  public void test() {
	  System.out.println("This is add to cart tests on Thread: " + Thread.currentThread().getId());
	  
  }
}
