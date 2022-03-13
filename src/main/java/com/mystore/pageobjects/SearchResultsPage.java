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
public class SearchResultsPage extends Baseclass{
	
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[2]/h5/a")
	WebElement productTitle;
	
	
	
	public SearchResultsPage() {
		
		PageFactory.initElements(getDriver(), this);
		
	}
	
	public AddtoCartPage productDisplay() {
		
		
	productTitle.click();
	
	return new AddtoCartPage();
		
		
	}

}
