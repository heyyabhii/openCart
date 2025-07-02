package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxes {
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().window().maximize();
		
		WebElement btnGSearch = driver.findElement(By.xpath("//input[@name='search']"));
		
		System.out.println("Google Search button displayed: " + btnGSearch.isDisplayed());
		
		WebElement btnSearch = driver.findElement(By.xpath("//input[@name='search']/following-sibling::span"));
		
		System.out.println("Google Search button displayed: " + btnSearch.isDisplayed());
		
		driver.quit();
	}

}
