package pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement lnkRegister;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement lnkLogin;
	
	@FindBy(xpath="//div[@class='swiper-slide text-center swiper-slide-duplicate swiper-slide-active']//img[@alt='iPhone 6']")
	WebElement activeSlide;
	
	@FindBy(xpath="//div[@class='swiper-slide text-center swiper-slide-active']//img[@alt='MacBookAir']")
	WebElement nextSlide;
	
	@FindBy(xpath = "//div[@id='slideshow0']//div[contains(@class,'swiper-slide')]//img")
	List<WebElement> allSlideElements;
	
	@FindBy(xpath = "//div[@id='slideshow0']//div[contains(@class,'swiper-slide-active')]//img")
	WebElement currentVisibleSlide;
	
	@FindBy(tagName = "img")
	List<WebElement> allImages;
	
	@FindBy(tagName = "a")
	List<WebElement> allLinks;
	
	@FindBy(name = "search")
	WebElement txtSearchBar;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement msgAlert;
	
	@FindBy(xpath = "//div[@id='content']//div[1]//div[1]//div[3]//button[2]//i[1]")
	WebElement btnFavorite;
	
	@FindBy(css = "div.alert-success")
	WebElement wishlistLoginAlert;
	
	@FindBy(xpath = "//span[contains(text(),'Wish List (0)')]")
	WebElement btnWishList;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav']//li")
	List<WebElement> topMenuCategories;
	
	@FindBy(xpath = ".//li/a")
	List<WebElement> sublinks;
	
	public void clickOnWishList()
	{
		btnWishList.click();
	}
	
	public void clickFirstProductWishList()
	{
		btnFavorite.click();
	}
	
	public String getWishListAlertMessage() 
	{
	    try 
	    {
	        return wishlistLoginAlert.getText();
	    }
	    catch (Exception e) 
	    {
	        return null;
	    }
	}
	
	public void searchProduct(String searchText)
	{
		txtSearchBar.clear();
		txtSearchBar.sendKeys(searchText);
		
	}
	
	public void clickSearchButton() {
	    btnSearch.click();
	}
	
	public boolean isCarouselWorking() throws InterruptedException
	{
		Set<String> expectedImagesSrcs = new HashSet<>();
		
		for(WebElement slide : allSlideElements)
		{
			expectedImagesSrcs.add(slide.getAttribute("src"));
		}
		
		Set<String> observedImagesSrcs = new HashSet<>();
		int maxWait = 10;
		
		for(int i = 0; i< maxWait && observedImagesSrcs.size() < expectedImagesSrcs.size(); i++)
		{
			try {
				String currentSrc = currentVisibleSlide.getAttribute("src");
			observedImagesSrcs.add(currentSrc);
			}
			catch(Exception e)
			{
				
			}
			Thread.sleep(3000);
		}
		
		return observedImagesSrcs.containsAll(expectedImagesSrcs);
	}
	
	public boolean checkBrokenLinks()
	{
		int brokenCount = 0;
		for(WebElement link : allLinks)
		{
			String url = link.getAttribute("src");
			if(url!=null && !url.isEmpty())
			{
				try
				{
				HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
				connection.setRequestMethod("HEAD");
				connection.connect();
				int responseCode = connection.getResponseCode();
				
				if(responseCode>=400)
				{
					brokenCount++;
				}
				}
				catch(Exception e)
				{
					
				}
			}
		}
		return brokenCount == 0;
	}
	
	public boolean checkBrokenImages()
	{
		int brokenCount=0;
		for(WebElement srcs : allImages)
		{
			String url = srcs.getAttribute("src");
			
			if(url != null && !url.isEmpty())
			{
				try {
				HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
				connection.setRequestMethod("HEAD");
				connection.connect();
				int responseCode = connection.getResponseCode();
				
				if(responseCode>=400)
				{
					brokenCount++;
				}
				}
				catch(Exception e)
				{
					
				}
			}
		}
		return brokenCount == 0;
	}

	public void clickmyAccount() {
		
		lnkMyAccount.click();
	}
	
	public void clickRegister() {
		
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void clickCategoryOrDropdown(String categoryName)
	{
		for(WebElement category : topMenuCategories)
		{
			String text = category.getText().split("\n")[0].trim();
			
			if(text.equalsIgnoreCase(categoryName))
			{
				try
				{
					category.click();
				}
				catch(Exception e )
				{
	                System.out.println("Direct click failed, trying hover...");
	                
	                Actions action = new Actions(driver);
	                action.moveToElement(category).perform();
	                List<WebElement> subLinks=category.findElements(By.xpath("//li/a"));
	                if(!subLinks.isEmpty())
	                {
	                	subLinks.get(0).click();
	                }
				}
				break;
			}
		}
	}
}
