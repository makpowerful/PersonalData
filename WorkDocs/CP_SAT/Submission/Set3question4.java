package com.testing.cpsat.mock;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set3question4 extends TestBase{
	
	public static final String url= "http://www.mptourism.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	public void Entervalues(String val) {
		
		d.findElement(By.xpath("//a[contains(text(),'Search')]")).click();
		d.findElement(By.xpath("//input[@type='text']")).clear();
		d.findElement(By.xpath("//input[@type='text']")).sendKeys(val, Keys.ENTER);
		wait(2);
		takeTheScreenShot("Set3Q4");
		d.navigate().back();
		wait(1);
		
	}
	@Test
	public void test() throws Throwable {
		
		for(int i=0;i<getRowCount("src\\test\\resources\\TestData\\TestData.xlsx","Set3Q4");i++)
		{
			Entervalues(readData("src\\test\\resources\\TestData\\TestData.xlsx","Set3Q4",i,0));
			
		}

		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
