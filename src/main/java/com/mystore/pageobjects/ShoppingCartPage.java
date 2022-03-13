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
public class ShoppingCartPage extends Baseclass {
	
	@FindBy (xpath="//*[@id='center_column']/p[2]/a[1]")
	WebElement clickProcheckoutBtn;
	
	
	public ShoppingCartPage() {
		
		
		PageFactory.initElements(getDriver(), this);
	}

	
	public DeliveryAddressPage clickProceedtochkout_on_ShoppingCart_Page() {
		
		clickProcheckoutBtn.click();
		
		
		return new DeliveryAddressPage();
		
		
	}
	
	
	
}
