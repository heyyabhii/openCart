package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement txtpass;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement btnLogin;
	
	public void provideEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void providePass(String pass) {
		txtpass.sendKeys(pass);
	}
	public void clickLogin( ) {
		btnLogin.click();
	}

}
