package TestNGLearning;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDemo
{
	 WebDriver driver;
	 ExtentTest test;
	 ExtentReports report;
	//static ExtentHtmlReporter htmlreporter;
	@BeforeTest
	public  void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html,true");
	test = report.startTest("ExtentDemo");
	System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
	 driver = new FirefoxDriver();
	
	}
	@Test
	public void verifygoogle() throws IOException
	{
	//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
	//WebDriver driver = new FirefoxDriver();
	driver.get("https://www.google.co.in");
	if(driver.getTitle().equals("Google"))
	{
	test.log(LogStatus.PASS, "Navigated to the Google URL");
	}
	else
	{
	test.log(LogStatus.FAIL, " Google Test Failed");
		}
	}
	
	@Test
	public void verifybing() throws IOException
	{
	//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
	//WebDriver driver = new FirefoxDriver();
	driver.get("http://www.bing.com/");
	if(driver.getTitle().equals("Bing"))
	{
	test.log(LogStatus.PASS, "Navigated to the Bing URL");
	}
	else
	{
	test.log(LogStatus.FAIL, "Bing Test Failed");
	}
	}
	
	@Test
	public void verifywikipidea() throws IOException
	{
	//System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
	//WebDriver driver = new FirefoxDriver();
	driver.get("https://www.wikipedia.org/");
	if(driver.getTitle().equals("wikiedia"))
	{
	test.log(LogStatus.PASS, "Navigated to the Wikipedia URL");
	}
	else
	{
	test.log(LogStatus.FAIL, "Wikipedia Test Failed");
	}
	
	}
	@AfterTest
	public  void endTest()
	{
	report.endTest(test);
	report.flush();
	}

}
