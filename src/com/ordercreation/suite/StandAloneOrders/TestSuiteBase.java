package com.ordercreation.suite.StandAloneOrders;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import com.ordercreation.base.TestBase;
import com.ordercreation.util.TestUtil;
import com.ordercreation.util.Xls_Reader;

@SuppressWarnings("unused")
public class TestSuiteBase extends TestBase {

	// to check whether the suite execution is to be skipped or not
	@BeforeSuite
	public void checkSuiteSkip_1() throws IOException
	{
		initialize();
		APP_LOGS.debug("Checking Runmode of Suite " + this.getClass().getSimpleName());
		if(!TestUtil.isSuiteRunnable(suiteXLs,"StandAloneOrdersBackup"))
		{
			APP_LOGS.debug("Skip Suite StandAloneOrdersBackup test cases");
			throw new SkipException("Run mode of Suite StandAloneOrdersBackup is set to No... hence skipping all tests in Suite StandAloneOrdersBackup");
		}
		else
		{
			APP_LOGS.debug("StandAloneOrdersBackup RUNMODE = Y");
		}
	}
}