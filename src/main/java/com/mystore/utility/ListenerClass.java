/**
 * 
 */
package com.mystore.utility;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondriver.ActionsClass;
import com.mystore.base.Baseclass;


/**
 * @author jayashreehemmige
 *
 */
public class ListenerClass extends ExtentManager implements ITestListener {
	
	ActionsClass action = new ActionsClass();
	
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass Test case is: " + result.getName());
		}
	}

	public void onTestFailure(ITestResult result) {
		
		Log.info("Your Test Failed - " + result.getName());
		
	/**	test=extent.createTest(result.getName());
		
		test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String screenshotPath=System.getProperty("user.dir")+"/ScreenShots1/"+result.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		test.fail("Screenshot is below:" + test.addScreenCaptureFromPath(screenshotPath));
		}
		else {
			
			System.out.println("couldnot capture screenshot");
			
		}**/
		
		
		
		
		if (result.getStatus() == result.FAILURE) {
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String imgPath = action.screenShot(action.getDriver(),result.getName());
			
			 test.fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			
			
			
		}
		
	}
	

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
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


