package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@id=\"input-firstname\"]")
	WebElement txtfirstName;
	
	@FindBy(xpath ="//*[@id=\"input-lastname\"]")
	WebElement txtlastName;
	
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement txtemail;
	
	@FindBy(xpath="//*[@id=\"input-telephone\"]")
	WebElement txtphone;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	WebElement txtpassword;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]")
	WebElement txtconfpassword;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	WebElement chkBox;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement ctnButton;

	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		
		txtfirstName.sendKeys(fname);
	}
	
	public void setlastName(String lname) {
		
		txtlastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		
		txtemail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtphone.sendKeys(tel);
	}
	
	public void setPassword(String pass) {
		
	 	txtpassword.sendKeys(pass);
	}

	public void setConfirmPassword(String pwd) {
		txtconfpassword.sendKeys(pwd);

	}
	
	public void clickCheckBox() {
		
		chkBox.click();
	}
	
	public void clickContinueButton() {
		
		ctnButton.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return (e.getMessage());
		}
		
	}
}
