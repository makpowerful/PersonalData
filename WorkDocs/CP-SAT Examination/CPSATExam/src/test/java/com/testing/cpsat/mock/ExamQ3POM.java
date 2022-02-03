package com.testing.cpsat.mock;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

import junit.framework.Assert;

public class ExamQ3POM extends TestBase {
	
	//Please capture the By locators for the following in the POM page
	private String frame_xpath="//iframe";
	private String BSE_xpath="//span[@id='bseindex']";
	private String NSE_xpath="//span[@id='nseindex']";
	private String Comp_xpath="//input[@id='query']";
	private String Mainwin;
	
	ExamQ3POM(WebDriver driver){
		this.d=driver;
	}
	
	//BSE Index Value
	public void BSEIndex() {
		WebElement frame=d.findElement(By.xpath(frame_xpath));
		d.switchTo().frame(frame);
		d.findElement(By.xpath(BSE_xpath)).getText();
	}
	
	///NSE Index Value
	public void NSEIndex() {
		d.findElement(By.xpath(NSE_xpath)).getText();
	}
	
	//Enter company or MF (input field)
	//Using the POM class create a Junit Test for printing the BSE Index Value, NSE Index Value and Enter company “Reliance Industries” in the company or MF Input field
	//Above step will open a new window, please assert that the title of this new window has “Reliance” in it
	//Using Selenium switch back to the previous window and assert that the title of that window has “Rediff.com:” in it
	public void EnterCompany() throws InterruptedException{
		Mainwin = d.getWindowHandle();
		d.findElement(By.xpath(Comp_xpath)).sendKeys("Reliance Industries", Keys.ENTER);
		wait(1);
		switchWindow();
		Assert.assertTrue(d.getTitle().contains("RELIANCE"));
		d.switchTo().window(Mainwin);
		Assert.assertTrue(d.getTitle().contains("Rediff.com:"));
		
	}
	
	
	
	
	
	
	

}
