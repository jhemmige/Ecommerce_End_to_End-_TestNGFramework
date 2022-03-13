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
import com.mystore.pageobjects.AddtoCartPage;
import com.mystore.pageobjects.ChoosePaymentMethodPage;
import com.mystore.pageobjects.ConfirmYourOrderPage;
import com.mystore.pageobjects.DeliveryAddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.SearchResultsPage;
import com.mystore.pageobjects.ShoppingCartPage;
import com.mystore.pageobjects.SignInPage;
import com.mystore.pageobjects.shippingPage;
import com.mystore.utility.Log;

/**
 * @author jayashreehemmige
 *
 */
public class EndtoEnd_Purchase_flow extends Baseclass {

	IndexPage indexpage;
	SignInPage signIn;
	HomePage homepage;
	SearchResultsPage searchResults;
	AddtoCartPage addtocart;
	ShoppingCartPage shoppingcart;
	DeliveryAddressPage DelAddPage;
	shippingPage shipPage;
	ChoosePaymentMethodPage choosepayment;
	ConfirmYourOrderPage confirmyourorder;
	OrderConfirmationPage orderconfirm;

	// Launches Chrome browser
	@Parameters("browser")
	@BeforeMethod (groups={"Regression","Smoke"})
	
	public void setup(String browser) {

		launchapp(browser);

	}

	// quits the current sesssion of the browser after the test is complete

	@AfterMethod (groups={"Regression","Smoke"})
	public void teardown() {

		getDriver().quit();

	}

	@Test (groups="Regression")
	public void placeOrder() {

		// Launches the URL
		
		Log.startTestCase("placeOrder");
		indexpage = new IndexPage();
		
		Log.info("Clicks on SignIn link of the landingpage");
		// Clicks on SignIn link of the landingpage
		signIn = indexpage.signintoStore();

		Log.info("User enters UserID /Password/Clicks on Signin button");
		// User enters UserID /Password/Clicks on Signin button
		homepage = signIn.signInclick(prop.get("username").toString(), prop.get("password").toString());

		Log.info("User enters t-shirt as the search query in the search input box");
		// User enters t-shirt as the search query in the search input box
		searchResults = homepage.Input_Search_Value("t-shirt");

		Log.info("Search Results page displaying the product");
		// Search Results page displaying the product
		addtocart = searchResults.productDisplay();
		
		Log.info("Adding the item to cart (quantity and size selection) and proceeding to checkout");
		// Adding the item to cart (quantity and size selection) and proceeding to checkout
		addtocart.Add_To_Cart_Button_Click();
		addtocart.Increase_Quantity();
		addtocart.Select_Size("3");
		shoppingcart = addtocart.Proceed_To_Checkout_Button_Click();

		Log.info("Continuing the checkout process on the shoppingcart page");
		// Continuing the checkout process on the shoppingcart page
		DelAddPage = shoppingcart.clickProceedtochkout_on_ShoppingCart_Page();
		
		Log.info("Continuing the checkout process on the Deliverydetails page");
		// Continuing the checkout process on the Deliverydetails page
		DelAddPage.sendComments("please deliver shipment carefully");
		
		Log.info("Continuing wthe checkout process on the ShippingDetails page");

		// Continuing wthe checkout process on the ShippingDetails page
		shipPage = DelAddPage.clickCBtnOnAddressPage();
		choosepayment = shipPage.Proceed_to_Checkout_Shipping_Page();

		Log.info("Choosing the payment method here");
		// Choosing the payment method here
		confirmyourorder = choosepayment.Click_On_Bank_Wire_Payment();

		Log.info("Confirming the order and Order Completion");
		// Confirming the order and Order Completion
		orderconfirm = confirmyourorder.Order_Confirmation();
		String ActualorderCompletetxt = orderconfirm.ordercompletetxtDisplay();

		Log.info("We are validating the Ordercomplete actual header retuned against the expected result");
		// We are validating the Ordercomplete actual header retuned against the expected result

		AssertJUnit.assertEquals(ActualorderCompletetxt, "Your order on My Store is complete.");
		
		Log.endTestCase("placeOrder()");
		Log.info(" End to End Purchase flow completed Successfully");

	}

}
