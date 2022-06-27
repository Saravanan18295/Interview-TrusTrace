package testscripts;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cucumber.listener.ExtentProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.tools.javac.util.Assert;
import helperClass.Libraries;
import junit.framework.AssertionFailedError;
import pageObjects.CartPageObjects;
import pageObjects.CheckoutPageObjects;
import pageObjects.InventoryPageObjects;
import pageObjects.LandingPageObjects;
import utils.BaseClass;
import utils.CommonLibraries;
import utils.ExcelReader;

public class TestSwagLabs extends Libraries {
	static Logger log = LogManager.getLogger(TestSwagLabs.class);
	CommonLibraries commonlibraries = new CommonLibraries();
	LandingPageObjects landingpageobjects;
	InventoryPageObjects inventorypageobjects;
	CartPageObjects cartpageobjects;
	CheckoutPageObjects checkoutpageobjects;

	@BeforeTest
	public void report() throws InterruptedException{
		report = new ExtentReports(System.getProperty("user.dir")+".reports/ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_h_mm_ss a");
		String formattedDate = sdf.format(date);
		formattedDate = formattedDate.replace("-", "").replace(" ", "");
		File mainFolder = new File("./report");
		if (!mainFolder.exists()) {
			mainFolder.mkdirs();
		}
		String projectname = "TrusTrace";
		File ResPathFolder = new File("./report");
		File PathFolderOuter = new File(
				ResPathFolder.getAbsolutePath() + "\\Result_" + projectname + "_" + formattedDate);
		File f = PathFolderOuter.getAbsoluteFile();
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath(f + "/" + projectname + "_" + formattedDate + ".html");
}

	@Test
	public void OrderProduct(){
		inventorypageobjects = new InventoryPageObjects(driver);
		cartpageobjects = new CartPageObjects(driver);
		checkoutpageobjects = new CheckoutPageObjects(driver);
		report = new ExtentReports(System.getProperty("user.dir")+"ExtentReportResults.html");
		test = report.startTest("ExtentDemo");

		try {
		//Click on Add to Cart
		commonlibraries.explicitWait(inventorypageobjects.AddtoCartBikelight);
		String text = inventorypageobjects.AddtoCartBikelight.getText();
		log.info(text);
		if(text.contains("ADD TO CART")) {
		commonlibraries.clickElement(inventorypageobjects.AddtoCartBikelight, "Add to Cart");
		}
		
		//Click on Cart
		commonlibraries.explicitWait(inventorypageobjects.CartIcon);
		commonlibraries.clickElement(inventorypageobjects.CartIcon, "Cart Icon");
	
		//CheckOut
		commonlibraries.explicitWait(cartpageobjects.CheckoutBtn);
		commonlibraries.clickElement(cartpageobjects.CheckoutBtn, "Check Out");
		
		//Verify current URL
		CurrentURL = driver.getCurrentUrl();
		log.info(CurrentURL);
		assertTrue(CurrentURL.contains("checkout-step-one"));

		//Enter the details to checkout
		commonlibraries.explicitWait(checkoutpageobjects.FirstName);
		commonlibraries.sendKeys(checkoutpageobjects.FirstName, FirstName);
		commonlibraries.explicitWait(checkoutpageobjects.LastName);
		commonlibraries.sendKeys(checkoutpageobjects.LastName, LastName);
		commonlibraries.explicitWait(checkoutpageobjects.PostalCode);
		commonlibraries.sendKeys(checkoutpageobjects.PostalCode, PostalCode);

		//Click on Continue
		commonlibraries.explicitWait(checkoutpageobjects.ContinueBtn);
		commonlibraries.clickElement(checkoutpageobjects.ContinueBtn, "Continue");
		
		//Verify current URL
		CurrentURL = driver.getCurrentUrl();
		log.info(CurrentURL);
		assertTrue(CurrentURL.contains("checkout-step-two"));
	
		//Click on Finish button
		commonlibraries.explicitWait(checkoutpageobjects.FinishBtn);
		commonlibraries.clickElement(checkoutpageobjects.FinishBtn, "Finish");
	
		String ExpectedThanksMessage = "THANK YOU FOR YOUR ORDER";
		//Verify the success Message
		commonlibraries.verifyElementToBeVisible(checkoutpageobjects.SuccessMessage, "Finish Button");
		if(checkoutpageobjects.SuccessMessage.getText().contains(ExpectedThanksMessage)) {
		log.info("Execution Completed Successfully");
		test.log(LogStatus.PASS, "Order a product");
		}
		else if(!checkoutpageobjects.SuccessMessage.getText().contains(ExpectedThanksMessage)) {
		test.log(LogStatus.FAIL, "Order a product");
		}}
		catch(Exception e) {
		test.log(LogStatus.FAIL, "Order a product");
		log.info("Execution Completed Successfully "+ e.getMessage());
		}
	}
		
	static ExtentTest test;
	static ExtentReports report;
	@AfterTest
	public void Teardown() throws InterruptedException{
			try {
				Thread.sleep(10);
				report.endTest(test);
				report.flush();
				} catch (Exception e) {
				log.info("Failed in createReport method due to exception: " + e.getMessage());
			}
		driver.quit();
	}
}