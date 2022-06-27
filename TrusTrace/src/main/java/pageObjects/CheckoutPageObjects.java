package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageObjects {

	@FindBy(id="first-name")
	public WebElement FirstName;

	@FindBy(id="last-name")
	public WebElement LastName;
	
	@FindBy(id="postal-code")
	public WebElement PostalCode;
	
	@FindBy(id="continue")
	public WebElement ContinueBtn;
	
	@FindBy(id="finish")
	public WebElement FinishBtn;
	
	@FindBy(id="checkout_complete_container")
	public WebElement SuccessMessage;
	
	public CheckoutPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
