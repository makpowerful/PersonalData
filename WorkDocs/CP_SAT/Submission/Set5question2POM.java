package com.testing.cpsat.mock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testing.base.TestBase;

public class Set5question2POM extends TestBase{
	
	private String Searchbar_xpath="//input[@id='searchboxinput']";
	private String Searchbtn_xpath= "//button[@id='searchbox-searchbutton']";
	private String Leftframe_xpath="//h1/span[1]";
	private String Rating_xpath="//span[@class='aMPvhf-fI6EEc-KVuj8d']";
	private String Review_xpath="//button[contains(text(),'reviews')]";
	private String link_xpath="//div[@class='QSFF4-text gm2-body-2'][contains(text(),'.com')]";
	private String Address_xpath="//div[@class='QSFF4-text gm2-body-2'][contains(text(),'Mankad')]";
	
	public  Set5question2POM(WebDriver driver) {
		
		this.d= driver;
	}
	
	public String EnterSearch(String name) {
		
		d.findElement(By.xpath(Searchbar_xpath)).sendKeys(name);
		return name;
		
	}
	
	public void ClickSearch() {
		wait(1);
		d.findElement(By.xpath(Searchbtn_xpath)).click();
	}
	
	public String Leftframe() {
		wait(1);
		String a= d.findElement(By.xpath(Leftframe_xpath)).getText();
		return a;
	}
	
	public String GetTitle() {
		
		String a = d.getTitle();
		return a;
		
	}
	
	public String RatingandReview(){
		
		String a=d.findElement(By.xpath(Rating_xpath)).getText();
		String b=d.findElement(By.xpath(Review_xpath)).getText();
		String c="Rating is: "+a+", and Review is: "+b;
		return c;
	}
	
	public String Linkpresent() {
		String a= d.findElement(By.xpath(link_xpath)).getText();
		return a;
	}
	
	public String Address() {
		String a= d.findElement(By.xpath(Address_xpath)).getText();
		return a;
	}

}
