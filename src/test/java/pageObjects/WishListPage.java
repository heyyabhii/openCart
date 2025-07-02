package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage{
	
	public WishListPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover']//td[2]/a")
	List<WebElement> WishListedProduct;
	
	public boolean isProductWishListed(String expectedProduct)
	{
		try
		{
			for(WebElement product : WishListedProduct)
			{
				if(product.getText().equalsIgnoreCase(expectedProduct))
				{
				return true;
				}
			}
		}
		catch(Exception e)
		{
			
		}
		return false;
	}

}
