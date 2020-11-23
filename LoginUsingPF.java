package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginUsingPF 
{

	WebDriver driver;
	
	@FindBy(how=How.NAME,using="ctl00$CPHContainer$txtUserLogin")
	WebElement username;
	
	@FindBy(how=How.NAME,using="ctl00$CPHContainer$txtPassword")
	WebElement password;

	@FindBy(how=How.NAME,using="ctl00$CPHContainer$btnLoginn")
	WebElement loginbtn;
	
	public LoginUsingPF(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifylogin(String uname,String pword)
	{
		username.sendKeys(uname);
		password.sendKeys(pword);
		loginbtn.click();
	}

}
