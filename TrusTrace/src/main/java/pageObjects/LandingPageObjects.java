package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {

	@FindBy(id="user-name")
	public WebElement UserName;
	
	@FindBy(id="password")
	public WebElement PassWord;
		
	@FindBy(id="login-button")
	public WebElement LoginBtn;
		
	public LandingPageObjects(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
