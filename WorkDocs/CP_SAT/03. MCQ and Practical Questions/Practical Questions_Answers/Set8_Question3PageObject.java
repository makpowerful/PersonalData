package cpsatExamJunit;

import org.openqa.selenium.By;

import com.testing.base.TestBase;

public class Set8_Question3PageObject extends TestBase{

/*	Capturing the By locators for the following in the POM page
	1. BSE Index Value 
	2. NSE Index Value
	3. Enter company or MF (input field)*/

	
	public By getBSEIndex(){
		return By.xpath("//span[@id='bseindex']");
	}
	public By getNSEIndex(){
		return By.xpath("//span[@id='nseindex']");
	}
	public By companyInput(){
		return By.xpath("//input[@value='Enter company or MF']");
	}
	public By searchBtn(){
		return By.xpath("//input[@value='Enter company or MF']//following::input[@type='button']");
	}
	public By moneyFrame(){
		return By.xpath("//iframe[@id='moneyiframe']");
	}
	
}

