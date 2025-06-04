package testCases;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MyAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_loginTest extends BaseClass{
	
	@Test(groups={"regression","Master"})
	public void verifyLogin() {
		
		logger.info("TC002_loginTest is started...");
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickmyAccount();
		hp.clickLogin();
		
		LoginPage login = new LoginPage(driver);
		
		login.provideEmail(p.getProperty("email"));
		login.providePass(p.getProperty("pass"));
		login.clickLogin();
		
		MyAccountPage myacc = new MyAccountPage(driver);
		
		boolean targetPage =myacc.isMyAccountdisplayed();
		Assert.assertEquals(targetPage, true, "LoginFailed...");
		}
		
		catch(Exception e) 
		{
			Assert.fail();
			logger.debug("TC002_loginTest is failed");
		}
		logger.info("TC002_loginTest is successful");
	}

}
