package com.ordercreation.suite.QuickQuote;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ordercreation.suite.QuickQuote.TestSuiteBase;
import com.ordercreation.util.TestUtil;

public class TryAndBuy extends TestSuiteBase {

	@BeforeTest
	public void checkTestSkip()
	{
		if(!TestUtil.isTestCaseRunnable(suiteQuickQuoteXLs,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("test case "+ this.getClass().getSimpleName()+ " skipped");
			throw new SkipException("Skipping Test Case "+ this.getClass().getSimpleName()+ " as runmode is set to NO");
		}
	}
	
	@Test
	public void testCaseB2()
	{
		APP_LOGS.debug(this.getClass().getSimpleName());
		System.out.println("Test Case B2");
	}
}
