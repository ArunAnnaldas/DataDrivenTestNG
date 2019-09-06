package com.ordercreation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import com.ordercreation.util.Xls_Reader;

//@SuppressWarnings("unused")
public class TestBase {

	public static Logger APP_LOGS= null;
	public static Properties CONFIG= null; 
	public static Properties OR= null;
	public static Xls_Reader suiteXLs = null;
	public static Xls_Reader suiteStandAloneOrdersBackupXLs = null;
	public static Xls_Reader suiteQuickQuoteXLs = null;
	public static boolean isInitialized = false;
	public static WebDriver driver = null;
	public static boolean isBrowserInvoked = false;
	//public static boolean fail = false;

	// initializing the tests
	public void initialize() throws IOException
	{
		// initialize logs,
		if (!isInitialized)
		{
			APP_LOGS = Logger.getLogger("devpinoyLogger");
			//config
			APP_LOGS.debug("Loading Property Files");
			CONFIG = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\ordercreation\\config\\config.properties");
			CONFIG.load(ip);
			//System.out.println(CONFIG.get("screenshotpath"));

			OR = new Properties();
			ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\ordercreation\\config\\OR.properties");
			OR.load(ip);
			//System.out.println(OR.getProperty("login_link"));
			APP_LOGS.debug("Loaded Property Files successfully");

			// xls file
			APP_LOGS.debug("Loading xls files ");
			suiteStandAloneOrdersBackupXLs = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\ordercreation\\xls\\StandAloneOrdersBackup.xlsx");
			suiteQuickQuoteXLs = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\ordercreation\\xls\\QuickQuote.xlsx");
			suiteXLs  = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\ordercreation\\xls\\SuiteBackup.xlsx");
			APP_LOGS.debug("Loaded xls files successfully");
			isInitialized = true;
		}
	}

	public boolean openBrowser() {

		try
		{
			if(CONFIG.getProperty("browserType").equals("Mozilla"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//exe/geckodriver.exe");
				driver = new FirefoxDriver();
			}	
			else if(CONFIG.getProperty("browserType").equals("IE"))
			{
				driver = new InternetExplorerDriver();
			}
			else if(CONFIG.getProperty("browserType").equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//exe/chromedriver.exe");
				driver = new ChromeDriver();
			}
			APP_LOGS.debug("Browser instance created successfully");
		}
		catch(Exception e)
		{

			return false;
		}

		//isBrowserInvoked = true;
		return true;
	}	

	public boolean closeBrowser()
	{
		try
		{
		driver.quit();
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	public boolean compareTitle(String expectedValue)
	{
		try
		{
			Assert.assertEquals(driver.getTitle(),expectedValue);
		}
		catch(Throwable t)
		{
//			ErrorUtil.addVerificationFailure(t);
			APP_LOGS.debug("Expected Title is : " + expectedValue + 
					"but found title as " + driver.getTitle());
			return false;
		}
		return true;
	}

	public boolean compareNumbers(int expectedNumber, int actualNumber)
	{
		try
		{
			Assert.assertEquals(expectedNumber,actualNumber);
		}		
		catch(Throwable t)
		{
//			ErrorUtil.addVerificationFailure(t);
			APP_LOGS.debug("Expected Number is " + expectedNumber + " but found " + actualNumber);
			return false;			
		}
		return true;
	}

	public void waitFunction(int time)
	{
		long stoptime = System.currentTimeMillis()+time;
		while(System.currentTimeMillis()<stoptime)
		{}
	}

}


