package pages;

import java.util.List;

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
	
	@FindBy (id = "searchDropdownBox")
	public WebElement departmentsDropdown;
	
	@FindBy (xpath="//div[@data-component-type='s-search-result']//span[@class='a-price-whole']")
	public List<WebElement> searchItemPrices;
	



}
