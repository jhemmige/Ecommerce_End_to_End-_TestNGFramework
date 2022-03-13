package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.ActionsClass;
import com.mystore.base.Baseclass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SignInPage;

public class LoginPageTest extends Baseclass {

	IndexPage indexPage;
	SignInPage signIn;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups={"Regression","Smoke"})
	public void setup(String browser) {

		launchapp(browser);

	}

	@AfterMethod (groups={"Regression","Smoke"})
	public void teardown() {

		getDriver().quit();

	}

	@Test (groups="Smoke")
	public void UserLogin() {

		indexPage = new IndexPage();
		signIn=indexPage.signintoStore();
		homePage= signIn.signInclick(prop.getProperty("username"), prop.getProperty("password"));
		String actualpageTitle = getDriver().getTitle();
		AssertJUnit.assertEquals(actualpageTitle, "My account - My Store");

	}

}
