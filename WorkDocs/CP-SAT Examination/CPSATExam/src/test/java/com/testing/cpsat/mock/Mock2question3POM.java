package com.testing.cpsat.mock;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.testing.base.TestBase;

public class Mock2question3POM extends TestBase{
	
	private String CloseInitialpopup_xpath="//i[@class='eicon-close']";
	private String AboutClick_xpath="//ul[@id='menu-main-1']/li/a[contains(text(),'About')]";
	private String InputfieldLOC_xpath="//input[@type='text']";
	
	public Mock2question3POM(WebDriver driver) {
		
		this.d=driver;
	}
	
	public void Navi_Inputfield() throws InterruptedException {
		
		d.findElement(By.xpath(CloseInitialpopup_xpath)).click();
		wait(1);
		d.findElement(By.xpath(AboutClick_xpath)).click();
		wait(1);
		scrollIntoView(d.findElement(By.xpath(InputfieldLOC_xpath)));
		wait(1);
		Scrollup();
	}

	public void Entervalue(String value) {
		
		d.findElement(By.xpath(InputfieldLOC_xpath)).sendKeys(value, Keys.ENTER);
		wait(2);
		
	}
}
