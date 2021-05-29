package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonHomePage {
	
	public AmazonHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	// if you work with element id, we just create an element abstract object.
	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
	public WebElement searchButton;
	
	@FindBy(xpath = "//a[text()='Sign in securely']")
	public WebElement signInButton;


}
