package com.testing.cpsat.mock;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set1Bquestion3POM extends TestBase{
	
	
	private String frame_xpath= "//iframe";
	private String bse_xpath="//span[@id='bseindex']";
	private String nse_xpath="//span[@id='nseindex']";
	private String MF_xpath="//input[@class='getquoteinput']";
	public String Mainwin;
	
	public Set1Bquestion3POM (WebDriver d){
		this.d=d;
	}
	
	public void BSEIndexValue() {
		d.switchTo().frame(d.findElement(By.xpath(frame_xpath)));
		Mainwin=d.getWindowHandle();
		System.out.println(d.findElement(By.xpath(bse_xpath)).getText());
		
	}
	
	public void NSEIndexValue() {
		System.out.println(d.findElement(By.xpath(nse_xpath)).getText());
		
	}
	
	public void MFInput() {
		d.findElement(By.xpath(MF_xpath)).sendKeys("Kotak Mahindra Bank Ltd.", Keys.ENTER);
		wait(3);
		
	}

}
