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
public class ConfirmYourOrderPage extends Baseclass {
	
	@FindBy (xpath="//button[@class='button btn btn-default button-medium']")
	WebElement orderConfirmBtn;
	
	
public ConfirmYourOrderPage() {
		
		
		PageFactory.initElements(getDriver(), this);
		
		
		
	}


public OrderConfirmationPage Order_Confirmation() {
	
	orderConfirmBtn.click();
	
	return  new OrderConfirmationPage();
	
}

}
