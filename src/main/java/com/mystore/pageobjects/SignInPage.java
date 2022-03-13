/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionsClass;
import com.mystore.base.Baseclass;

/**
 * @author jayashreehemmige
 *
 */
public class SignInPage extends Baseclass{
	
	
	@FindBy(xpath= "//*[@id='email']")
	WebElement emailidField;
	
	
	@FindBy(xpath= "//*[@id='passwd']")
	WebElement pwdField;
	
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement submitBtn;
	
	@FindBy(xpath="//*[@id='email_create']")
	WebElement createAccount;
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	WebElement submitCreateAccountBtn;
	
	
	public SignInPage() {
		
	PageFactory.initElements(getDriver(), this);	
		
	}
	
	public HomePage signInclick(String UserID, String Pswd) {
		
		emailidField.sendKeys(UserID);
		pwdField.sendKeys(Pswd);
		submitBtn.click();
		//ActionsClass.implicitWait(getDriver(), 10);
		
		return new HomePage();
		
		
	}
	
	
	public AccountCreationPage  createNewAccount(String emailID) throws InterruptedException {
		
		createAccount.clear();
		
		ActionsClass.moveToElement(getDriver(), createAccount);
		ActionsClass.click(getDriver(), createAccount);
		//ActionsClass.type(createAccount, emailID);
		createAccount.sendKeys(emailID);
		
		//ActionsClass.click(getDriver(), submitCreateAccountBtn);
		submitCreateAccountBtn.click();
		
		ActionsClass.implicitWait(getDriver(),5);
		
		//Thread.sleep(10);
		
		return new AccountCreationPage();
		
		
	}
	
	

	
	

}
