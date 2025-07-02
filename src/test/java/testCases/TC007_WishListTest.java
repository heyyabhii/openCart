package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC007_WishListTest extends BaseClass{

	//@Test(groups = "regression")
	public void WishlistWithoutLogin()
	{
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickFirstProductWishList();
		String actualMsg = hp.getWishListAlertMessage();
		Assert.assertTrue(actualMsg.contains("You must login"), "Wishlist alert for non-logged-in user not shown properly. Actual: " + actualMsg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test failed due to: "+e.getMessage());
		}
	}
	
	@Test(groups = "regression")
	public void WishListWithLogin()
	{
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickmyAccount();
			Thread.sleep(1000);
			hp.clickLogin();

			
			LoginPage lp = new LoginPage(driver);
			lp.provideEmail("aa@asw.bn");
			lp.providePass("558kN6k#a6z5N7");
			lp.clickLogin();
			
			driver.get("https://tutorialsninja.com/demo/");
			hp.clickFirstProductWishList();
			
			MyAccountPage map = new MyAccountPage(driver);
			map.clickOnWishList();
			
			WishListPage wlp = new WishListPage(driver);
			boolean productFound = wlp.isProductWishListed("macbook");
			
			Assert.assertTrue(productFound, "Product not found in wishlist after login.");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test failed due to: "+e.getMessage());

		}
		
	}
	
}
