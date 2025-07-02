package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC008_VerifyTopMenuNavigation extends BaseClass{

	@Test(groups="regression")
	public void verifyTopMenuNavigation()
	{
		try
		{
			HomePage hp = new HomePage(driver);
			
			String[] topCategories = {"Desktops", "Laptops & Notebooks", "Components", "MP3 Players", "Tablets", "Software", "Phones & PDAs", "Cameras"};
			
			for(String category : topCategories)
			{
				hp.clickCategoryOrDropdown(category);
				Thread.sleep(1000);
				driver.navigate().back();
			}
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		        Assert.fail("Navigation Test failed: " + e.getMessage());
		}
	}
	
}
