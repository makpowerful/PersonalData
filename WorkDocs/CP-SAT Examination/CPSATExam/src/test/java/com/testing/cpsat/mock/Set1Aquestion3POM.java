package com.testing.cpsat.mock;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set1Aquestion3POM extends TestBase {
	private String iframe_xpath =  "//iframe";
	private String BSE_xpath ="//span[@id='bseindex']";
	private String NSE_xpath ="//span[@id='nseindex']";
	private String MFinput_xpath = "//input[@class='getquoteinput']";
	private String MFsearch_xpath="//input[@class='getqbtn']";
	
	public String Mainwin;
	
	public Set1Aquestion3POM(WebDriver driver) {
		
		this.d=driver;
	}
	
	
	public String GetBSEvalue() {
		
		d.switchTo().frame(d.findElement(By.xpath(iframe_xpath)));
		String a= d.findElement(By.xpath(BSE_xpath)).getText();
		System.out.println("BSE value is :" +a);
		return a;
	}

	public String GetNSEvalue() {
		
		
		String a= d.findElement(By.xpath(NSE_xpath)).getText();
		System.out.println("NSE value is :" +a);
		return a;
	}
	
	public void EnterMFvalue() {
		
		Mainwin= d.getWindowHandle();
		d.findElement(By.xpath(MFinput_xpath)).sendKeys("Reliance Industries",Keys.ENTER);
		wait(1);
		//d.findElement(By.xpath(MFsearch_xpath)).click();
	}
	
	public String Newwindowtitle() throws InterruptedException {
		
		/*
		 * wait(1); Set<String> tab=d.getWindowHandles(); Iterator<String>
		 * it=tab.iterator(); String firsttab= it.next(); String secndtab= it.next();
		 * d.switchTo().window(secndtab); d.getTitle();
		 */
		
		switchWindow();
		String a = d.getTitle();
		return a;
	}
	
    public String Oldwindowtitle() throws InterruptedException {
		
		/*
		 * wait(1); Set<String> tab=d.getWindowHandles(); Iterator<String>
		 * it=tab.iterator(); String firsttab= it.next(); String secndtab= it.next();
		 * d.switchTo().window(secndtab); d.getTitle();
		 */
		
		d.switchTo().window(Mainwin);
		String a = d.getTitle();
		return a;
	}
	
}
