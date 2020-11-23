
package PageObjectTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;
import PageObjects.UpdatePageObjects;

public class UpdateTestCase 
{
	WebDriver driver;
	@BeforeTest
	public void beforetest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		 driver = new FirefoxDriver();
		driver.navigate().to("http://www.testyou.in/Login.aspx");
		driver.manage().window().maximize();
	}
	@Test
	public void update() throws InterruptedException
	{
        PageFactory.initElements(driver, LoginPageObjects.class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPageObjects.username.sendKeys("rrajidivi4499@gmail.com");
		LoginPageObjects.password.sendKeys("rajidivi@4499");
		LoginPageObjects.loginbtn.click();
		
		PageFactory.initElements(driver, UpdatePageObjects.class);
		
		UpdatePageObjects.editbtn.click();
		UpdatePageObjects.firstname.clear();
		UpdatePageObjects.firstname.sendKeys("Rajesh");
		//UpdatePageObjects.DOB(driver);
		UpdatePageObjects.mobilenumber.sendKeys("9884363887");;
		UpdatePageObjects.gender.click();
		
		WebElement dropdown=UpdatePageObjects.securityquestion;
		Select select = new Select(dropdown);
		select.selectByIndex(1);
		
		UpdatePageObjects.securityanswer.sendKeys("RajiDivi");
		UpdatePageObjects.updatebtn.click();
		
	}

}
