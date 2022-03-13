/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.actiondriver.ActionsClass;
import com.mystore.base.Baseclass;

/**
 * @author jayashreehemmige
 *
 */
public class AddtoCartPage extends Baseclass {
	
@FindBy(xpath="//i[@class='icon-plus']")
WebElement increasequantity;

@FindBy(xpath="//*[@id='group_1']")
WebElement selectsize;
	
@FindBy(xpath="//*[@id='add_to_cart']/button/span")
WebElement AddtocartBtn;

@FindBy(xpath="//a[@title='Proceed to checkout']")
WebElement proceedcheckoutBtn;



public AddtoCartPage() {
	
	PageFactory.initElements(getDriver(), this);
	
	
}

public void Add_To_Cart_Button_Click() {
	
	AddtocartBtn.click();
	
	
}

public void Increase_Quantity() {
	
	for (int i=0;i<5; i++) {
		
		
		increasequantity.click();
	}
	
	
}


public void Select_Size(String sizeValue) {
	
	selectsize.click();
	Select dropdown= new Select(selectsize);
	dropdown.selectByValue(sizeValue);
	
	
}


public ShoppingCartPage Proceed_To_Checkout_Button_Click() {
	
	proceedcheckoutBtn.click();
	
	//ActionsClass.fluentWait(driver, proceedcheckoutBtn, 20);
	
	ActionsClass.implicitWait(getDriver(), 20);
	
	return new ShoppingCartPage();
	
}



}
