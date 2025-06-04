package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass=DataProviders.class, groups="datadriven")
	public void verifyLoginDDT(String email, String pass, String exp) {
		logger.info("***** stating TC_003_LoginDDT ******");
		
		try {
			
		HomePage hp = new HomePage(driver);
		
		hp.clickmyAccount();
		hp.clickLogin();
		
		LoginPage login = new LoginPage(driver);
		
		login.provideEmail(email);
		login.providePass(pass);
		login.clickLogin();
		
		MyAccountPage myacc = new MyAccountPage(driver);
		
		boolean targetPage =myacc.isMyAccountdisplayed();
		
		if(exp.equalsIgnoreCase("valid")) {
			
			if(targetPage==true) {
				myacc.clickLogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				myacc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC_003_LoginDDT ******");
		
	}
}
