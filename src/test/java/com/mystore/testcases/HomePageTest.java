package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SignInPage;

public class HomePageTest extends Baseclass {
	
	
	IndexPage indexPage;
	SignInPage signinpage;
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
	
	@Test (groups="Smoke")
	public void wishlist_and_orderHistory_Display() {
		
	indexPage= new IndexPage();
		
	signinpage=	indexPage.signintoStore();
	homePage= signinpage.signInclick(prop.getProperty("username"), prop.getProperty("password"));
	
	
	boolean wishlistTitleDisplay= homePage.wishListtitlesDisplay();
	boolean orderhisTitleDisplay= homePage.OrderhisttitlesDisplay();
	
	AssertJUnit.assertTrue(wishlistTitleDisplay);
	AssertJUnit.assertTrue(orderhisTitleDisplay);
	
	
	}
	
	

}
