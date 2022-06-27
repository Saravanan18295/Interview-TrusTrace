package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPageObjects {

	@FindBy(xpath="//*[contains(@id,'sauce-labs-bike-light')]")
	public WebElement AddtoCartBikelight;
	
	@FindBy(id="shopping_cart_container")
	public WebElement CartIcon;
	//div[@class='cart_item']
	
	public InventoryPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
