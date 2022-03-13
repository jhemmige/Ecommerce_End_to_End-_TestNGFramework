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
public class ChoosePaymentMethodPage extends Baseclass {
	
	@FindBy (xpath="//*[@class='bankwire']")
	WebElement bankwireBtnclick;
	
	
public ChoosePaymentMethodPage() {
		
		
		PageFactory.initElements(getDriver(), this);
		
		
		
	}


public ConfirmYourOrderPage Click_On_Bank_Wire_Payment() {
	
	bankwireBtnclick.click();
	
	return new ConfirmYourOrderPage();
	
	
}
	
	

}
