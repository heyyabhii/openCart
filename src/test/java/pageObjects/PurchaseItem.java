package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseItem extends BasePage {
	
	public PurchaseItem (WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/div/div[1]/a/img")
	WebElement imgIphone;
	
	public boolean isPurchaseItemVisible()
	{
		try {
			return(imgIphone.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickOnItem()
	{
		imgIphone.click();
	}

}
