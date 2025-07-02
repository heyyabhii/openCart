package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{
	
	public ProductPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div[1]/ul[1]/li[1]/a")
	WebElement productImage;
	
	@FindBy(xpath="//*[@id=\"tab-description\"]/p")
	WebElement productDesc;
	
	@FindBy(xpath="//*[@id=\"button-cart\"]")
	WebElement btnCart;
	
	@FindBy(xpath="//*[@id=\"product-product\"]/div[1]")
	WebElement msgCart;
	
	@FindBy(xpath="//*[@id=\"cart-total\"]")
	WebElement btnTotalCart;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")
	WebElement btnCheckOut;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[2]/a")
	WebElement btnBuy;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement btnRight;
	
		

	
	
	
	public boolean isProductAvailable()
	{
		try {
			return(productImage.isDisplayed());
		}catch (Exception e)
		{
			return false;
					
		}
	}
	
	public boolean isProductDescAvailable()
	{
		try {
			return(productDesc.isDisplayed());
		}catch (Exception e)
		{
			return false;
					
		}
	}
	
	public void clickOnAddBtn()
	{
		btnCart.click();
	}
	
	public boolean isCartSuccessmsgVisible()
	{
		try
		{
		return(	msgCart.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickOnTotalCartBtn()
	{
		btnTotalCart.click();
	}
	
	public void clickOnCheckOut()
	{
		btnCheckOut.click();
	}
	
	public void clickOnBuy()
	{
		btnBuy.click();
	}
}
