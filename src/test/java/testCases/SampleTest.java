package testCases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest {
	
	public WebDriver driver;

	 @Test
	    public void demoTest() {
	        driver = new ChromeDriver();
	        
	        driver.get("https://tutorialsninja.com/demo");
	        
	        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	        
	        for(WebElement links: allLinks)
	        {
	        	String url = links.getAttribute("href");
	        	
	        	if(url!= null&&!url.isEmpty())
	        	{
	        		try
	        		{
	        			HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
	        			connection.setRequestMethod("HEAD");
	        			connection.connect();
	        			int responseCode=connection.getResponseCode();
	        			
	        			if(responseCode >= 400) {
	        				System.out.println(url+ "is a broken link");
	        			}else {
	        				System.out.println(url+"is valid");
	        			}
	        		}catch(Exception e)
	        		{
	        			System.out.println(url+ "is broken link");
	        		}
	        	}
	        }
	        
	    }
}
