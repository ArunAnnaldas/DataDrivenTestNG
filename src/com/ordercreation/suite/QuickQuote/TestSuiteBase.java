package com.ordercreation.suite.QuickQuote;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.ordercreation.base.TestBase;
import com.ordercreation.util.TestUtil;

public class TestSuiteBase extends TestBase {

	@BeforeSuite
	public void checkSuiteSkip_2() throws IOException
	{
		initialize();
		APP_LOGS.debug("Checking Runmode of Suite QuickQuote " +  this.getClass().getSimpleName());
		if(!TestUtil.isSuiteRunnable(suiteXLs,"QuickQuote"))
		{
			APP_LOGS.debug("Skip Suite QuickQuote test cases");
			throw new SkipException("Run mode of Suite QuickQuote is set to No... hence skipping all tests in Suite QuickQuote");
		}
	}
}
