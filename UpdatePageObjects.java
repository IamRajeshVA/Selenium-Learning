package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeTest;

public class UpdatePageObjects 
{
	@FindBy(xpath="//div[@class='edit_link']")
	public static WebElement editbtn;
	
	@FindBy(name="ctl00$CPHContainer$txtFirstName")
	public static WebElement firstname;
	
	@FindBy(name="ctl00$CPHContainer$rdoGender")
	public static WebElement gender;
	
	@FindBy(name="ctl00_CPHContainer_Picker2_dateInput_text")
	public static WebElement DOB;
	
	@FindBy(name="ctl00$CPHContainer$txtPhone")
	public static WebElement mobilenumber;
	
	@FindBy(id="ctl00_CPHContainer_btnUpdateProfile")
	public static WebElement updatebtn;
	
	@FindBy(xpath ="//select[@id='ctl00_CPHContainer_ddlSecurityQuestion']")
	public static WebElement securityquestion;
	
	@FindBy(id="ctl00_CPHContainer_txtSecurtityAnswer")
	public static WebElement securityanswer;
	
	
	
	
	
	
	/*
	 * public static WebElement editbtn(WebDriver driver) { return
	 * driver.findElement(By.className("edit_link")); } public static WebElement
	 * firstname(WebDriver driver) { return
	 * driver.findElement(By.name("ctl00$CPHContainer$txtFirstName")); } public
	 * static WebElement gender(WebDriver driver) { return
	 * driver.findElement(By.name("ctl00$CPHContainer$rdoGender")); } public static
	 * WebElement DOB(WebDriver driver) { return
	 * driver.findElement(By.name("ctl00_CPHContainer_Picker2_dateInput_text")); }
	 * public static WebElement mobilenumber(WebDriver driver) { return
	 * driver.findElement(By.name("ctl00$CPHContainer$txtPhone")); } public static
	 * WebElement updatebtn(WebDriver driver) { return
	 * driver.findElement(By.id("ctl00_CPHContainer_btnUpdateProfile"));
	 * 
	 * } public static WebElement securityquestion(WebDriver driver) { return
	 * driver.findElement(By.xpath(
	 * "//*[@id='ctl00_CPHContainer_ddlSecurityQuestion']/div/input[1]")); } public
	 * static WebElement securityAnser(WebDriver driver) { return
	 * driver.findElement(By.id("ctl00_CPHContainer_txtSecurtityAnswer")); }
	 * 
	 * 
	 */
}
