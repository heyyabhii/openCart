package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_accountRegistrationTest extends BaseClass{

	
	@Test(groups="sanity")
	public void verify_account_registration() {
		
		try {
		logger.info("Starting TC001_accountRegistrationTest...");
		
		HomePage hp=new HomePage(driver);
		
		hp.clickmyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details..");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setlastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeAlphanumeric());
		String password=randomeAlphanumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.clickCheckBox();
		regpage.clickContinueButton();
		
		
		
		
		logger.info("Confirming message");
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		
		catch(Exception e) {
			
			logger.error("Test Failed...");
			logger.debug("Debug logs..");
			Assert.fail();
		
	}
	}
	
}
