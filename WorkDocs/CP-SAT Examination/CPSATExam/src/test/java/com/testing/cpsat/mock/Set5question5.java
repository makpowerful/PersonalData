package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set5question5 extends TestBase{
	
	public static final String url= "http://ata123456789123456789.appspot.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		int a=7;
		int b=4;
		d.findElement(By.id("ID_nameField1")).sendKeys("7");
		d.findElement(By.id("ID_nameField2")).sendKeys("4");
		
		d.findElement(By.id("gwt-uid-7")).click();
		d.findElement(By.xpath("//button[contains(text(),'Calculate')]")).click();
		String res=d.findElement(By.id("ID_nameField3")).getAttribute("value");
		int c=a*a-2*(a*b)+b*b;
		Assert.assertEquals(res,Integer.toString(c));
		
	}	
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
