package helperClass;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;
import pageObjects.CartPageObjects;
import pageObjects.CheckoutPageObjects;
import pageObjects.InventoryPageObjects;
import pageObjects.LandingPageObjects;
import testscripts.TestSwagLabs;
import utils.BaseClass;
import utils.CommonLibraries;

public class Libraries extends BaseClass{
	static Logger log = LogManager.getLogger(Libraries.class);
	CommonLibraries commonlibraries = new CommonLibraries();
	LandingPageObjects landingpageobjects;
	InventoryPageObjects inventorypageobjects;
	CartPageObjects cartpageobjects;
	CheckoutPageObjects checkoutpageobjects;

	@Test
	public void Login() throws InterruptedException, InvalidFormatException, IOException{
		try{
		landingpageobjects = new LandingPageObjects(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		commonlibraries.getpagetitle();
		commonlibraries.explicitWait(landingpageobjects.UserName);
		commonlibraries.sendKeys(landingpageobjects.UserName, Username);
		commonlibraries.explicitWait(landingpageobjects.PassWord);
		commonlibraries.sendKeys(landingpageobjects.PassWord, Password);
		commonlibraries.clickElement(landingpageobjects.LoginBtn, "Login Button");
		test.log(LogStatus.PASS, "Succesfully Logged in to the application");
		commonlibraries.takeScreenShotForPass();
	}
	catch(Exception e) {
		test.log(LogStatus.SKIP,"Test Skipped");
		commonlibraries.takeScreenShotForFail();
		Assert.fail("failed to login due to the exception "+ e.getMessage());
		}
	}
}