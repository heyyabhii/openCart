package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC000_HomePageTest extends BaseClass{
	HomePage hp;
	@Test(groups = "regression")
	public void testCarousel()
	{
		 try {
	            hp = new HomePage(driver);
	            boolean isWorking = hp.isCarouselWorking();
	            Assert.assertTrue(isWorking, "❌ Carousel did not show all expected images.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            Assert.fail("❌ Test failed due to exception: " + e.getMessage());
	        }

	}
	@Test(groups = "regression")
	public void testBrokenImages()
	{
		try
		{
			hp = new HomePage(driver);
			boolean isImagesBroken = hp.checkBrokenImages();
			Assert.assertTrue(isImagesBroken);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test failed due to: "+e.getMessage());
		}
	}
	
	@Test(groups = "regression")
	public void testBrokenLinks()
	{
		try
		{
			hp = new HomePage(driver);
			boolean isLinkBroken = hp.checkBrokenLinks();
			Assert.assertTrue(isLinkBroken);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test failed due to: "+e.getMessage());
		}
	}
	
}
