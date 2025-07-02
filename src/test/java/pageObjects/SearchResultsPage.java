package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage{

	public SearchResultsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='product-thumb']")
	List<WebElement> results;
	
	@FindBy(xpath = "//p[contains(.,'There is no product that matches the search criteria.')]")
	WebElement noResults;
	
	public int getresultsCount()
	{
		return results.size();
	}
	
	public boolean isNoResultsMessageDisplayed()
	{
		try
		{
			return noResults.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
}
