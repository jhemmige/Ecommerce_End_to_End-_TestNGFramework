/**
 * 
 */
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
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SignInPage;

/**
 * @author jayashreehemmige
 *
 */
public class NewAccountCreation extends Baseclass {

	IndexPage indexPage;

	SignInPage signIn;

	AccountCreationPage acp;

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
	 

	@Test (groups={"Smoke", "Regression"})

	public void newAccountRegistration() throws InterruptedException {

		indexPage = new IndexPage();

		signIn = indexPage.signintoStore();

		String randomnemail = createRandomString() + "@gmail.com";
		String randomnFname = createRandomString();
		String randomnlname = createRandomString();

		acp = signIn.createNewAccount(randomnemail);
		

		acp.accountRegistration("Mrs.");
		acp.sendFName_Lname("Jane", "Fonda");
		acp.setPassword(randomnFname);

		acp.setDoB("2", "6", "1950");
		acp.AddressSetUP(randomnFname, randomnlname, "infographics", "Abc ahth", "voorhees", "20", "08043");
		acp.setComments(randomnlname);

		acp.setPhoneNumbers("123-333-2343", "1234445555");

		acp.setaddressAlias("myaddress");

		homePage = acp.clickRegisterationbtn();

		String ActhomePageWelcometxt = homePage.welcometxtdisplay();
		
		//we are validating here with the text that's displayed on the Home Page with the text that's actually returned from script
		AssertJUnit.assertEquals(ActhomePageWelcometxt, prop.get("HomePagewelcomeText"));

		homePage.clickSignOut();

	}

}
