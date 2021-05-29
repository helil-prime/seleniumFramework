package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SeleniumEasyAlertPage {
	
	public SeleniumEasyAlertPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//button[@onclick='myAlertFunction()']")
	public WebElement firstAlertBtn;
	
	@FindBy(xpath = "//button[@onclick='myConfirmFunction()']")
	public WebElement secondAlertBtn;
	
	@FindBy(xpath="//button[@onclick='myPromptFunction()']")
	public WebElement thirdAlertBtn;

}
