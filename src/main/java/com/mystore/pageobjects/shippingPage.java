/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

/**
 * @author jayashreehemmige
 *
 */
public class shippingPage extends Baseclass{
	
	
	@FindBy (xpath="//*[@id='cgv']")
	WebElement chkBox;
	
	@FindBy (xpath="//*[@id='form']/p/button")
	WebElement clickProcheckoutBtn_onShipPage;

	
	
public shippingPage() {
		
		
		PageFactory.initElements(getDriver(), this);
		
		
		
	}



public ChoosePaymentMethodPage Proceed_to_Checkout_Shipping_Page() {
	
	chkBox.click();
	clickProcheckoutBtn_onShipPage.click();
	
	return new ChoosePaymentMethodPage();
	
	
}
		
		
		


	

}
