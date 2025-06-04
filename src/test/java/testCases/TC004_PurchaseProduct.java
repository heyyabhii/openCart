package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductPage;
import pageObjects.PurchaseItem;
import testBase.BaseClass;

public class TC004_PurchaseProduct extends BaseClass{
	@Test(groups="regression")
	public void purchaseProduct()
	{
		try
		{
		PurchaseItem pi = new PurchaseItem(driver);
		
		pi.clickOnItem();
		
		ProductPage pp = new ProductPage(driver);
		
		pp.clickOnAddBtn();
		
		boolean targetSuccessMsg=pp.isCartSuccessmsgVisible();
		Assert.assertEquals(targetSuccessMsg, true, "Not Visible");
		
		pp.clickOnTotalCartBtn();
		pp.clickOnCheckOut();
		
		
		
	}
		catch(Exception e)
		{
			Assert.fail();
		}

}
}
