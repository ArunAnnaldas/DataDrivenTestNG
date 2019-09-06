package com.ordercreation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class TestUtil {

	// finds whether the suite is runnable
	public static boolean isSuiteRunnable(Xls_Reader xls, String suiteName)
	{
		boolean isexecutable = false;
		for(int i=2; i<=xls.getRowCount("Suites");i++)
		{
			String suite = xls.getCellData("Suites","TCID", i);
			String runmode = xls.getCellData("Suites","RUNMODE", i);
			
			if(suite.equalsIgnoreCase(suiteName))
			{
				if(runmode.equalsIgnoreCase("y"))
				{
					isexecutable = true;
				}
				else
				{
					isexecutable = false;
				}
			}
		}
		xls=null;
		return isexecutable;
	}

	// returns true if runmode of the test is equal to yes
	public static boolean isTestCaseRunnable(Xls_Reader xls, String testCaseName)
	{	
		boolean isExecutable = false;
		for(int i = 2; i<=xls.getRowCount("testcases");i++)
		{
			String tcid = xls.getCellData("testcases", "TCID", i);
			String runmode = xls.getCellData("testcases", "RUNMODE", i);
			
			
			if(tcid.equalsIgnoreCase(testCaseName))
			{
				if(runmode.equalsIgnoreCase("y"))
				{
					isExecutable = true;
				}					
				else
				{
					isExecutable = false;
				}
			}
		}
		xls=null;
		return isExecutable;
	}

	//return test data from a test in a two dimensional array
	public static Object[][] getData(Xls_Reader xls, String testCaseName)
	{
		//if sheet is not present
		if(!xls.isSheetExist(testCaseName))
		{
			xls=null;
			return new Object[1][0];
		}
		
		int rows = xls.getRowCount(testCaseName);
		int cols = xls.getColumnCount(testCaseName);
//		System.out.println("rows are -- " + rows);
//		System.out.println("cols are -- " + cols);
				
		Object[][] data = new Object[rows-1][cols-4];
		for(int rowno=2; rowno<=rows; rowno++)
		{
			for(int colno = 0; colno<cols-4;colno++)
			{
				//System.out.print(xls.getCellData(testCaseName, colno, rowno)+ " -- ");
				data[rowno-2][colno]=xls.getCellData(testCaseName, colno, rowno);
				
			}
			//System.out.println();
		}
		
		
		return data;
		
	}

	//updates results of a particular dataset
	public static void reportDataSetResult(Xls_Reader xls, String testCaseName, int rowNum, String result)
	{
		xls.setCellData(testCaseName, "RESULTS", rowNum, result);
	}

	// checks RUnmode for dataSet
	public static String[] getDataSetRunmodes(Xls_Reader xlsFile,String sheetName){
		String[] runmodes=null;
		if(!xlsFile.isSheetExist(sheetName)){
			xlsFile=null;
			sheetName=null;
			runmodes = new String[1];
			runmodes[0]="Y";
			xlsFile=null;
			sheetName=null;
			return runmodes;
		}
		runmodes = new String[xlsFile.getRowCount(sheetName)-1];
		for(int i=2;i<=runmodes.length+1;i++){
			runmodes[i-2]=xlsFile.getCellData(sheetName, "RUNMODE", i);
		}
		xlsFile=null;
		sheetName=null;
		return runmodes;
		
	}

	// return the row num for a test
	public static int getRowNum(Xls_Reader xls, String id){
		for(int i=2; i<= xls.getRowCount("testcases") ; i++){
			String tcid=xls.getCellData("testcases", "TCID", i);
			
			if(tcid.equals(id)){
				xls=null;
				return i;
			}
		}
		return -1;
	}

	public static boolean checkforelementavailability(WebDriver driver, String Xpath) throws Throwable
	{
		for (int second = 0;; second++) 
		{
			if (second >= 120) 
			{
				//Assert.fail("timeout");
				return false;
			}
			try 
			{ 
				if(isElementPresent(driver ,By.xpath(Xpath))) 
				{
					break; 
				}
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			waitFunction1(1000);
		}	
		return true;
		
	}	

	public static boolean isElementPresent(WebDriver driver, By by) 
	{
		try 
		{
			driver.findElement(by);
			return true;
		} 
		catch(NoSuchElementException e) 
		{
			return false;
		}
	}

	// wait function
	public static void waitFunction1(int time)
	{
		long stoptime = System.currentTimeMillis()+time;
		while(System.currentTimeMillis()<stoptime)
		{}
	}
}
