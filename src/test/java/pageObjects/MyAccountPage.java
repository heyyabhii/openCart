package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
	WebElement msgHeading;
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	WebElement btnLogout;
	
	@FindBy(xpath="//span[contains(.,'Wish List (1)')]")
	WebElement btnMyWishList;
	
	public boolean isMyAccountdisplayed() {
		
		try {
			return (msgHeading.isDisplayed());
		}
		catch(Exception e){
			return false;
			
		}
		
		
	}
	public void clickLogout() {
		
		btnLogout.click();
	}
	
	public void clickOnWishList()
	{
		btnMyWishList.click();
	}
	
}
