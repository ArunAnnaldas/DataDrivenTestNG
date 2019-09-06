package com.ordercreation.suite.StandAloneOrders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ordercreation.util.TestUtil;

//@SuppressWarnings("unused")
public class StandAloneGovOrders extends TestSuiteBase {

	String runmodes[] = null;
	static int count = -1;
	static boolean pass = false;
	static boolean fail = false;
	static boolean skip = false;
	static boolean isTestPass = true;
	static String webOrderID = null;
	static String failMessage = null;

	// run mode of test case in a suite

	@BeforeTest
	public void checkTestSkip() {
		if (!TestUtil.isTestCaseRunnable(suiteStandAloneOrdersBackupXLs, this.getClass().getSimpleName())) {
			APP_LOGS.debug("test case " + this.getClass().getSimpleName() + " skipped");
			throw new SkipException(
					"Skipping Test Case " + this.getClass().getSimpleName() + " as runmode is set to NO");
		}
		runmodes = TestUtil.getDataSetRunmodes(suiteStandAloneOrdersBackupXLs, this.getClass().getSimpleName());
	}

	@Test(dataProvider = "getTestData")
	public void testCaseA1(String Requirement_ID, String Operating_Unit, String Order_Source, String Order_Type,
			String CCW_User_Name, String Intended_Use, String Shipment_Routing, String Shipping_Service_Level,
			String Ship_to_Location, String Bill_to_Location, String Notes_on_Customer_Info,
			String Intermediate_Order_Status, String Holds_Information, String Bill_to_Department_ID,
			String Serial_Number, String Reference_SO, String Line_Number, String Product_Name, String Spare,
			String Configuration_Details, String Quantity, String Warehouse, String Shipset, String Line_Notes,
			String Priority) throws Throwable {
		// test the runmode of current dataset
		fail = false;

		System.out.println("Operating_Unit : " + Operating_Unit);
		System.out.println("CCW_User_Name : " + CCW_User_Name);

		count++;
		if (!runmodes[count].equalsIgnoreCase("Y")) {
			skip = true;
			throw new SkipException("Run mode of test data set to NO");
		}

		APP_LOGS.debug(" Executing " + this.getClass().getSimpleName());

		/**************
		 * Browser Open
		 ***************************************************/

		if (openBrowser()) {
		}

		else {
			fail = true;
			APP_LOGS.debug("Browser invocation failed.");
			failMessage = "Browser invocation failed.";
		}

		/*************** Login Handling **********************************************/

		if (fail == false) {
			try {

				// navgiation to URL
				driver.get(CONFIG.getProperty("testSiteName"));

				// checking username field presence
				if (TestUtil.checkforelementavailability(driver, OR.getProperty("LoginUsername"))) {
					if (CCW_User_Name.trim().equalsIgnoreCase("any") || CCW_User_Name.trim().equals("")) {
						driver.findElement(By.xpath(OR.getProperty("LoginUsername")))
								.sendKeys(Keys.chord(Keys.ALT, Keys.SPACE, Keys.ARROW_UP, Keys.ARROW_UP, Keys.ENTER));
						driver.findElement(By.xpath(OR.getProperty("LoginUsername")))
								.sendKeys(CONFIG.getProperty("UserName1"));
					} else {
						driver.findElement(By.xpath(OR.getProperty("LoginUsername"))).sendKeys(CCW_User_Name.trim());
					}
				} else {
					fail = true;
					APP_LOGS.debug("Login UserName failed.");
					failMessage = "Login UserName failed.";
				}

				// checking password field presence

				if (fail == false) {
					if (TestUtil.checkforelementavailability(driver, OR.getProperty("LoginPassword"))) {
						driver.findElement(By.xpath(OR.getProperty("LoginPassword")))
								.sendKeys(CONFIG.getProperty("Password"));
					} else {
						fail = true;
						APP_LOGS.debug("Login Password Failed");
						failMessage = "Login Password Failed.";
					}
				}

				// checking continue field presence

				if (fail == false) {
					if (TestUtil.checkforelementavailability(driver, OR.getProperty("LoginEnter"))) {
						driver.findElement(By.xpath(OR.getProperty("LoginEnter"))).click();
					} else {
						fail = true;
						APP_LOGS.debug("Login Enter Button Failed");
						failMessage = "Login Enter Button Failed.";
					}
				}
			} catch (Exception e) {
				fail = true;
				APP_LOGS.debug("Login failed.");
				failMessage = "Login failed.";
			}
		}
	}

	@AfterMethod
	public void reportDataSetResult() {

		if (skip)
			TestUtil.reportDataSetResult(suiteStandAloneOrdersBackupXLs, this.getClass().getSimpleName(), count + 2,
					"SKIP");
		else if (fail) {
			isTestPass = false;
			TestUtil.reportDataSetResult(suiteStandAloneOrdersBackupXLs, this.getClass().getSimpleName(), count + 2,
					"FAIL");
			suiteStandAloneOrdersBackupXLs.setCellData("StandAloneSimpleOrders", "ERROR", count + 2, failMessage);
		} else {
			suiteStandAloneOrdersBackupXLs.setCellData("StandAloneGovOrders", "WebOrderID", count + 2, webOrderID);
			TestUtil.reportDataSetResult(suiteStandAloneOrdersBackupXLs, this.getClass().getSimpleName(), count + 2,
					"PASS");
		}
		skip = false;
		fail = false;
	}

	@AfterTest
	public void reportTestResult() {
		if (isTestPass)
			TestUtil.reportDataSetResult(suiteStandAloneOrdersBackupXLs, "testcases",
					TestUtil.getRowNum(suiteStandAloneOrdersBackupXLs, this.getClass().getSimpleName()), "PASS");
		else {
			TestUtil.reportDataSetResult(suiteStandAloneOrdersBackupXLs, "testcases",
					TestUtil.getRowNum(suiteStandAloneOrdersBackupXLs, this.getClass().getSimpleName()), "FAIL");
		}
	}

	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getData(suiteStandAloneOrdersBackupXLs, this.getClass().getSimpleName());
	}
}
