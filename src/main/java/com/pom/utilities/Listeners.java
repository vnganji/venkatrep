package com.pom.utilities;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;



public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		String testcasename=result.getName();
		
		boolean res = DataUtil.IsTestExecutable(testcasename);
		if (Constants.REGRESSION_RUNMODE.equalsIgnoreCase("N")) {
			throw new SkipException("Test Case "+testcasename+" doesnt run as the suite runmode set to No");
		}
		else if (!res) {
			throw new SkipException("Skipping Testcase");
			
		}
	
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
