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

import com.mystore.base.Baseclass;
import com.mystore.pageobjects.IndexPage;

/**
 * @author jayashreehemmige
 *
 */
@Test
public class IndexPageTest extends Baseclass {

	IndexPage ip;

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
	public void testingIndexPage() {

		ip = new IndexPage();
		boolean storeLogoDisplay = ip.storelogoDisplay();

		AssertJUnit.assertTrue(storeLogoDisplay);

	}
	
	@Test (groups="Smoke")
	public void validateStoreTitleDisplay() {
		
	String ActstoreTitle=	ip.storeTitleDisplay();
	String ExpectedStoreTitle= "My Store";

	Assert.assertEquals(ActstoreTitle, prop.get("storetitle"));
		
		
	}
	
	
	
	

}
