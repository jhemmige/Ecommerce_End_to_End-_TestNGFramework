package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionsClass;
import com.mystore.base.Baseclass;

public class IndexPage extends Baseclass {

	@FindBy(xpath = "//*[@class='logo img-responsive']")
	private WebElement mystorelogo;

	@FindBy(xpath = "//*[@class='login']")
	private WebElement signInlink;

	@FindBy(xpath = "//*[@id='search_query_top']")
	private WebElement searchField;

	@FindBy(xpath = "//*[@id='searchbox']/button")
	private WebElement searchBtn;

	public IndexPage() {

		PageFactory.initElements(getDriver(), this);

	}

	public boolean storelogoDisplay() {

		
		return ActionsClass.isDisplayed(getDriver(), mystorelogo);

	}
	
	
	public String storeTitleDisplay() {
		
	return	getDriver().getTitle();
		
	}

	public SignInPage signintoStore() {
		

		//driver.findElement(signInlink);

		ActionsClass.moveToElement(getDriver(), signInlink);
		ActionsClass.click(getDriver(), signInlink);

		return new SignInPage();

	}

	public SearchResultsPage enterSearchtxt(String value) {

		ActionsClass.moveToElement(getDriver(), searchField);
		ActionsClass.type(searchField, value);
		ActionsClass.click(getDriver(), searchBtn);

		return new SearchResultsPage();

	}

	

}
