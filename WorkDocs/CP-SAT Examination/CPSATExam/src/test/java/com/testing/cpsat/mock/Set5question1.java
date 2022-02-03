package com.testing.cpsat.mock;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Set5question1 extends TestBase{

	public static final String url = "http://www.meripustak.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}
	
	public void chckprice(String str) {
		
		d.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys(str,Keys.ENTER);
		wait(2);
		List<WebElement> Plist=d.findElements(By.xpath("//div[@class='our_tag_price right']"));
		List<WebElement> Pllist=d.findElements(By.xpath("//div[@class='tag_price left']"));
		int m=1;
		for(int i=0;i<10;i++) {
			
			String a=Plist.get(i).getText().replaceAll("/-", " ").replaceAll("Rs. ", " ").trim();
			String[] b=Pllist.get(i).getText().replaceAll("/-", " ").replaceAll("Rs. ", " ").trim().split("Rs.");
			//System.out.println("Value: "+a);
			//System.out.println("Value: "+b[1]);
			if(Integer.parseInt(a)<Integer.parseInt(b[1])) {
				System.out.println("The discounted price list for " +str+"book "+m+ " is :"+a);
				m++;
			}
			//System.out.println("The normal price list for " +str+ " is :"+b);
			
			
		}
		System.out.println("***********************");
		wait(1);
		d.navigate().back();
		d.findElement(By.xpath("//input[@id='txtsearch']")).clear();
		wait(1);
	}

	@Test
	public void test() throws IOException, Exception {
	
		for(int i=0;i<getRowCount("src\\test\\resources\\TestData\\TestData.xlsx", "Set5Q1");i++){
			
		chckprice(readData("src\\test\\resources\\TestData\\TestData.xlsx", "Set5Q1", i, 0));
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
