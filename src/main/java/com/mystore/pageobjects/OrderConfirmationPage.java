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
public class OrderConfirmationPage extends Baseclass {
	
	@FindBy (xpath="//strong[text()='Your order on My Store is complete.']")
	WebElement ordercompletetxt;
	
	
	@FindBy (xpath="//*[@id='center_column']/p/a")
	WebElement backToOrderslink;
	
	@FindBy (xpath="//*[@id='center_column']/div/text()[6]")
	WebElement ordertxt;
	
	
public OrderConfirmationPage() {
		
		
		PageFactory.initElements(getDriver(), this);
		
		
		
	}

public String ordercompletetxtDisplay() {
	
String orderCompletetxt= ordercompletetxt.getText();
	
	return orderCompletetxt;
}



public OrderHistoryPage Click_Back_to_Orders() {
	
	backToOrderslink.click();
	
	
	return new OrderHistoryPage();
	
	
	
}

public String Get_Order_txt() {
	
//ordertxt.getText().toString();
	
return ordertxt.getTagName().toString();
	
	
}



}
