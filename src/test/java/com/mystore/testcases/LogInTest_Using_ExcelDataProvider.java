/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.ActionsClass;
import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SignInPage;
import com.mystore.utility.Log;

/**
 * @author jayashreehemmige
 *
 */
public class LogInTest_Using_ExcelDataProvider extends Baseclass {

	IndexPage indexPage;
	SignInPage signIn;
	HomePage homePage;

	@Parameters("browser")
	@BeforeMethod (groups={"Regression","Smoke"})
	
	public void setup(String browser) {

		launchapp(browser);

	}

	@AfterMethod (groups={"Regression","Smoke"})
	public void teardown() {

		getDriver().quit();

	}

	@Test(dataProvider = "Credentials", dataProviderClass = DataProviders.class,groups="Smoke")
	public void UserLogin_with_DataDriven(String Uname, String Password) {

		Log.startTestCase("UserLogin_with_DataDriven");
		Log.info("URL is launched");
		indexPage = new IndexPage();
		Log.info("User clicks on Signin Link on landing page ");
		signIn = indexPage.signintoStore();
		Log.info("User enters UserID and Password ");
		homePage = signIn.signInclick(Uname, Password);
		
		
		String actualpageTitle = getDriver().getTitle();

		Log.info("Validing the page title from testscript to actual page title ");

		AssertJUnit.assertEquals(actualpageTitle, "My account - My Store");

		Log.endTestCase("UserLogin_with_DataDriven");

		Log.info("Login functionality passed successfully ");
		
		System.out.println("Test1 Thread ID is : " + Thread.currentThread().getId());

	}
	
	
	

}
