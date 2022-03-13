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
public class DeliveryAddressPage extends Baseclass {
	
	@FindBy (xpath="//*[@id='center_column']/form/p/button")
	WebElement clickProcheckoutBtn;

	@FindBy (xpath="//*[@id='ordermsg']/textarea")
	WebElement commentAreaonAddress;
	
	
	
	public DeliveryAddressPage() {
		
		
		PageFactory.initElements(getDriver(), this);
		
		
		
	}
	
	
	public void sendComments(String comment) {
		
		commentAreaonAddress.sendKeys(comment);
			
		
	}
	
	
	public shippingPage clickCBtnOnAddressPage() {
		
		clickProcheckoutBtn.click();
		
		return new shippingPage();
		
		
	}
	
	
	

}
