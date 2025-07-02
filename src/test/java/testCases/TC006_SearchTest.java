package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC006_SearchTest extends BaseClass {
	
	HomePage hp;
	SearchResultsPage srp;
	@Test(priority = 1, groups = "regression")
	public void SearchValidPRoduct()
	{
		try 
		{
		hp = new HomePage(driver);
		hp.searchProduct("macbook");
		hp.clickSearchButton();
		
		srp = new SearchResultsPage(driver);
		Assert.assertTrue(srp.getresultsCount() > 0, "No search results found for valid product");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test Failed due to: "+e.getMessage());
		}
	}
	
	@Test(priority = 2,groups = "regression")
	public void searchInvalidProduct()
	{
		try
		{
		hp = new HomePage(driver);
		hp.searchProduct("Time Machine");
		hp.clickSearchButton();
		
		srp = new SearchResultsPage(driver);
		Assert.assertTrue(srp.isNoResultsMessageDisplayed(), "'There is no product that matches the search criteria.' is not displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test Failed due to: "+e.getMessage());
		}
		
	}
	
	@Test(priority = 3,groups = "regression")
	public void searchWithEmptyInput()
	{
		try
		{
			hp = new HomePage(driver);
			hp.searchProduct("");
			hp.clickSearchButton();
			
			srp = new SearchResultsPage(driver);
			Assert.assertTrue(srp.isNoResultsMessageDisplayed(), "'There is no product that matches the search criteria.' is not displayed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail("Test Failed due to: "+e.getMessage());
		}
	}

}
