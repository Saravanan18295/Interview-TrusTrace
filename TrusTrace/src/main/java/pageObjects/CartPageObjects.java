package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageObjects {
	
	
	@FindBy(id="checkout")
	public WebElement CheckoutBtn;
	
	public CartPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
