/**
 * 
 */
package com.mystore.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.Baseclass;

/**
 * @author jayashreehemmige
 *
 */
public class AccountCreationPage extends Baseclass {
	
	
	
	
	
		@FindBy(xpath="//h3[text()='Your personal information']")
		WebElement personalInfo;
		
		
		@FindBy(xpath="//*[@id='id_gender1']")
		WebElement Male_genderTitle;
		
		@FindBy(xpath="//*[@id='id_gender2']")
		WebElement Female_genderTitle;
		
		
		@FindBy(xpath="//*[@id='customer_firstname']")
		WebElement firstName;
		
		@FindBy(xpath="//*[@id='customer_lastname']")
		WebElement lastName;
		
		@FindBy(xpath="//*[@id='passwd']")
		WebElement passWrd;
		
		@FindBy(xpath="//*[@id='days']")
		WebElement dob_date;
		
		@FindBy(xpath="//*[@id='months']")
		WebElement dob_month;
		
		@FindBy(xpath="//*[@id='years']")
		WebElement dob_year;
		
		
		
		
		
		@FindBy(xpath="//*[@name='firstname']")
		WebElement Address_fname;
		
		@FindBy(xpath="//*[@name='lastname']")
		WebElement Address_lname;
		
		@FindBy(xpath="//*[@name='company']")
		WebElement Address_company;
			
		@FindBy(xpath="//*[@name='address1']")
		WebElement Address_line1;
		
		@FindBy(xpath="//*[@name='city']")
		WebElement cityName;
		
		
		@FindBy(xpath="//*[@id='id_state']")
		WebElement stateName;
		
		
		@FindBy(xpath="//*[@id='postcode']")
		WebElement zipCode;
		
		@FindBy(xpath="//*[@id='other']")
		WebElement commentBox;
		
		@FindBy(xpath="//*[@id='phone']")
		WebElement homePhone;
		
		@FindBy(xpath="//*[@id='phone_mobile']")
		WebElement mobile_Phone;
		
		
		@FindBy(xpath="//*[@id='alias']")
		WebElement address_Alias;
		
		
		@FindBy(xpath="//*[@id='submitAccount']")
		WebElement registerBtn;
		
		
		
		
		
		public AccountCreationPage() {
			
			PageFactory.initElements(getDriver(), this);
			
			
		}
		
		
		
		public void accountRegistration(String Gender) {
			
			
			if (Gender.contains("Mr.")) {
				
				Male_genderTitle.click();
				
				
			}
			
			else if (Gender.contains("Mrs.")) {
				
				Female_genderTitle.click();
				
				
			}
			
			else {
				
				
				System.out.println("Cannot find Gender");
			}
				
		}
		
		
		public void sendFName_Lname(String Fname, String Lname) {
			
			firstName.clear();
			firstName.sendKeys(Fname);
			
			lastName.clear();
			lastName.sendKeys(Lname);
			
		}
		
		
		public void setPassword(String pass_word) {
			
			passWrd.clear();
			passWrd.sendKeys(pass_word);
			
			
		}
		
		
		public void setDoB(String date_value, String month_value, String year_value ) {
			
			dob_date.click();
			
			Select dropdown= new Select(dob_date);
			
			dropdown.selectByValue(date_value);
		
			dob_month.click();
			
			Select mdropdown= new Select(dob_month);
			
			mdropdown.selectByValue(month_value);
			
			dob_year.click();
			
			Select ydropdown= new Select(dob_year);
			
			ydropdown.selectByValue(year_value);
		}
				
				
		
		public void AddressSetUP(String ad_fname, String ad_lname,String ad_company, String Add_line1, String cName, String stateValue, String zipvalue ) {
			
			//Address_fname.clear();
			//Address_fname.sendKeys(ad_fname);
			
			//Address_lname.clear();
			Address_lname.sendKeys(ad_lname);
			
			Address_company.clear();
			Address_company.sendKeys(ad_company);

			Address_line1.clear();
			Address_line1.sendKeys(Add_line1);
			
			cityName.clear();
			cityName.sendKeys(cName);
			
			stateName.click();
			
			Select dropdownstateName= new Select(stateName);
			
			dropdownstateName.selectByValue(stateValue);
			
			zipCode.sendKeys(zipvalue);
		}
				
		
		
		public void setComments(String commentValue) {
			commentBox.clear();
			commentBox.sendKeys(commentValue);
			
			
		}
		
		
		
	
		
		public void setPhoneNumbers(String homePh, String MobilePhone) {
			homePhone.clear();
			homePhone.sendKeys(homePh);
			mobile_Phone.clear();
			mobile_Phone.sendKeys(MobilePhone);
			
			
			
		}
		
		
		public void setaddressAlias(String aliasValue) {
			address_Alias.clear();
			
			address_Alias.sendKeys(aliasValue);
			
			
		}
		
		
		
		public HomePage clickRegisterationbtn() {
			
			registerBtn.click();
			
			
			return  new HomePage();
			
			
		}
		
		
		public String personalinfoDisplay() {
			
			String pinfo=	personalInfo.getText();
			 
			 return pinfo;
				
			}
				
				
				
	
	

}
