package Selenium;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenshotUsingRobot
{
	

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	public void startTest()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/Screenshot.html,true");
		test = report.startTest("ExtentDemo");

	}		

	public void verifygoogle() throws IOException
	{
		
		driver.navigate().to("https://www.google.co.in");
		if(driver.getTitle().equals("Google"))
		{
			test.log(LogStatus.PASS, "Navigated to the Google URL");
		}
		else
		{
			test.log(LogStatus.FAIL, " Google Test Failed");
			TakesScreenshot srcshot = ((TakesScreenshot)driver);
			File srcfile = srcshot.getScreenshotAs(OutputType.FILE);

			File destinationfile = new File("E:\\Screenshot\\verifygoogle.png");

			FileHandler.copy(srcfile, destinationfile);
		}
	}

	public void verifybing() throws IOException
	{
		driver.get("http://www.bing.com/");
		if(driver.getTitle().equals("Bing"))
		{
			test.log(LogStatus.PASS, "Navigated to the Bing URL");
		}
		else
		{
			test.log(LogStatus.FAIL, "Bing Test Failed");

			//take screenshot

			TakesScreenshot srcshot=(TakesScreenshot) driver;
			File srcshotfile = srcshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File("E:\\Screenshot\\verifybing.png");
			FileHandler.copy(srcshotfile, destinationFile);

		}
	}

	public void verifywikipidea() throws IOException, AWTException
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
			/*
			 * TakesScreenshot srcshot=(TakesScreenshot) driver; File srcshotfile =
//			 * srcshot.getScreenshotAs(OutputType.FILE); File destinationfile = new
//			 * File("E:\\screenshot\\verfiywikipedia.png"); FileHandler.copy(srcshotfile,
			 * destinationfile);
			 */
			Robot robot = new Robot();
			Dimension size =Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rectangle = new Rectangle(size);
			BufferedImage source =robot.createScreenCapture(rectangle);
			File destinationfile = new File("E:\\Screenshot\\robotverifybing.png");
			ImageIO.write(source, "png", destinationfile);
			
			
		}

	}

	public  void endTest()
	{
		report.endTest(test);
		report.flush();
		driver.close();
	}

	public static void  main(String[]args) throws IOException
	{
		ScreenshotExample obj = new ScreenshotExample();
		obj.startTest();
		obj.verifygoogle();
		obj.verifybing();
		obj.verifywikipidea();
		obj.endTest();

	}


}
