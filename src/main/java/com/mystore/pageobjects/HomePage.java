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
public class HomePage extends Baseclass{
	
	
	@FindBy(xpath="//*[@id='center_column']/div/div[2]/ul/li/a/span")
	WebElement WishlistTitle;		
	
	@FindBy (xpath="//*[@id='center_column']/div/div[1]/ul/li[1]/a/span")
	WebElement OrderHistoryDetailsDisplay;
	
	@FindBy (xpath= "//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement signoutlink;
	
	@FindBy(xpath="//*[text()='Welcome to your account. Here you can manage all of your personal information and orders.']")
	WebElement welcometxt;
	
	@FindBy(xpath= "//*[@id='search_query_top']")
	WebElement SearchInputField;
	
	@FindBy(xpath="//*[@name='submit_search']")
	WebElement submitsearchBtn;
	
public HomePage() {
	
	PageFactory.initElements(getDriver(), this);
	
}
	
	public boolean wishListtitlesDisplay() {
		
		return WishlistTitle.isDisplayed();
		
		
	}
	
	
	public boolean OrderhisttitlesDisplay() {
		     
		
		//ordertxt= OrderHistoryDetailsDisplay.getText();
		
		return OrderHistoryDetailsDisplay.isDisplayed();
		
	}
	
	
	public SignInPage clickSignOut() {
		
		signoutlink.click();
		
		return new SignInPage();
		
	}
	
	
	public String welcometxtdisplay() {
		
		
		String welcometext= welcometxt.getText();
		
		return welcometext;
		
	}
	
	
	public SearchResultsPage Input_Search_Value(String query) {
		
		
		SearchInputField.click();
		
		SearchInputField.sendKeys(query);
		
		submitsearchBtn.click();
		
		return new SearchResultsPage();
		
		
		
	}

}
