package com.ordercreation.suite.QuickQuote;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ordercreation.suite.QuickQuote.TestSuiteBase;
import com.ordercreation.util.TestUtil;

public class StandardQ2O extends TestSuiteBase {

	String runmodes[]=null;
	static int count=-1;
	
	// run mode of test case in a suite
	
	@BeforeTest
	public void checkTestSkip()
	{
		if(!TestUtil.isTestCaseRunnable(suiteQuickQuoteXLs,this.getClass().getSimpleName()))
		{
			APP_LOGS.debug("test case "+ this.getClass().getSimpleName()+ " skipped");
			throw new SkipException("Skipping Test Case "+ this.getClass().getSimpleName()+ " as runmode is set to NO");
		}
		runmodes = TestUtil.getDataSetRunmodes(suiteQuickQuoteXLs, this.getClass().getSimpleName());
	}
	
	@Test(dataProvider="getTestData")
	public void testCaseB1(String col1,
			   String col2,
			   String col3,
			   String col4,
			   String col5,
			   String col6)
	{
		// test the runmode of current dataset
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y"))
		{
			throw new SkipException("Run mode of test data set to NO");
		}
		
		APP_LOGS.debug(this.getClass().getSimpleName());
		System.out.println("Test Case B1 ");
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		return TestUtil.getData(suiteQuickQuoteXLs,this.getClass().getSimpleName());
		
	}
	
}
