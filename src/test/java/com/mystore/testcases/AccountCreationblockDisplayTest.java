package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SignInPage;


public class AccountCreationblockDisplayTest extends Baseclass {
	
	
	IndexPage indexpage;
	SignInPage signinPage;
	AccountCreationPage accountcreationPage;
	
	@BeforeMethod (groups={"Regression","Smoke"})
	@Parameters("browser")
	public void setup(String browser) {

		launchapp(browser);

	}

	@AfterMethod (groups={"Regression","Smoke"})
	public void teardown() {

		getDriver().quit();

	}
	
	@Test(groups="Smoke")
	public void createaccountBlockDisplay() throws InterruptedException {
		
		
		indexpage= new IndexPage();
		signinPage=	indexpage.signintoStore();
		
		String randomnemail=createRandomString() +"@gmail.com";
		System.out.println(randomnemail);
		
		accountcreationPage=signinPage.createNewAccount(randomnemail);
		
		String pinfo1= accountcreationPage.personalinfoDisplay();
		
		System.out.println(pinfo1.trim());
		
		AssertJUnit.assertEquals(pinfo1, prop.get("AccounttextDisplay"));
		
		
	}
	

}
