package com.pom.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import javax.xml.crypto.Data;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class DataUtil {

	public static ExcelReader excel = null;
	public static String filepath = null;
	public static String testcasesheetname = null;
	public static String testdatasheetname = null;

	public static void DataConfiguration(Method mname) {

		metadata annot = mname.getAnnotation(metadata.class);
		try {

			filepath = ((!annot.filepath().equals("")) ? annot.filepath()
					: (String) metadata.class.getMethod("filepath").getDefaultValue());
			testcasesheetname = ((!annot.testcasesheet().equals("")) ? annot.testcasesheet()
					: (String) metadata.class.getMethod("testcasesheet").getDefaultValue());
			testdatasheetname = ((!annot.testdatasheet().equals("")) ? annot.testdatasheet()
					: (String) metadata.class.getMethod("testdatasheet").getDefaultValue());

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		excel = new ExcelReader(filepath);

	}

	public static boolean IsTestExecutable(String tcname) {

		String RunMode = "N";
		int rowcount = excel.getRowCount(testcasesheetname);
		for (int rownum = 2; rownum <= rowcount; rownum++) {

			String testcase = excel.getCellData(testcasesheetname, Constants.TESTCASECOL, rownum);
		
			if (testcase.equalsIgnoreCase(tcname)) {
				RunMode = (excel.getCellData(testcasesheetname, Constants.RUNMODE_COL, rownum)).trim();
				break;
			}

		}
	
		if (RunMode.equalsIgnoreCase(Constants.RUNMODE_YES)) {
			return true;
		} else {
			return false;
		}

	}

	@DataProvider(name = "datagenerator")
	public static Object[][] getdata(Method m) {
		String testcasename = m.getName();
		//total rows
		int rows = excel.getRowCount(testdatasheetname);
		int rownum;
		//Row where test case exists
		for (rownum = 2; rownum <= rows; rownum++) {
			if (excel.getCellData(testdatasheetname, 0, rownum).equals(testcasename))
				break;
		}
		int testcaserownum = rownum;
		// find no of rows of test data for the test case.
		int tempval = testcaserownum;
		
		while (!(excel.getCellData(testdatasheetname, 0, tempval).trim()).equalsIgnoreCase("TestCaseName")) {
			tempval++;
		}
		int endrownum = tempval - 1;

		// find data end column
		int colnum = 1;
		boolean a = true;
		while (a) {
			if (excel.getCellData(testdatasheetname, colnum, testcaserownum - 1).equals(""))
				break;
			else
				colnum++;
		}
		int endcolnum = colnum - 1;
		int noofrowswithyes=0;
		for (int row = testcaserownum; row <= endrownum; row++) {
			boolean tdrunmode = (excel.getCellData(testdatasheetname, 1, row).trim())
					.equalsIgnoreCase((Constants.RUNMODE_YES).trim());
			if (tdrunmode) noofrowswithyes++;}
				Object[][] data = new Object[noofrowswithyes][1];
		
		int i = 0;
	
		for (int row = testcaserownum; row <= endrownum; row++) {
			Hashtable<String, String> table = new Hashtable<String, String>();
			System.out.println(excel.getCellData(testdatasheetname, 1, row));
			boolean tdrunmode = (excel.getCellData(testdatasheetname, 1, row).trim())
					.equalsIgnoreCase((Constants.RUNMODE_YES).trim());
			if (tdrunmode) {
				for (int col = 2; col <= endcolnum; col++) {
					String colname = excel.getCellData(testdatasheetname, col, testcaserownum - 1).trim();
					String colvalue = excel.getCellData(testdatasheetname, col, row).trim();
					table.put(colname, colvalue);
				}
		
				if (!(table.isEmpty()))
				data[i][0] = table;
				i++;
			}
			
		}

		

		return data;

	}
}
