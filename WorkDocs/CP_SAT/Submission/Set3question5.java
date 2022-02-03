package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set3question5 extends TestBase{
	
	public static final String url= "http://www.onlineconversion.com/length_common.htm";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		int val=5;
		int i=200;
		String s=Integer.toString(i);
		wait(1);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys(Integer.toString(val));
		
		Select s1=new Select(d.findElement(By.xpath("//select[@name='from']")));
		s1.selectByVisibleText("feet");
		wait(1);
		
		Select s2=new Select(d.findElement(By.xpath("//select[@name='to']")));
		s2.selectByVisibleText("inch");
		wait(1);
		
		d.findElement(By.xpath("//input[@type='button']")).click();
		wait(1);
		String[] a= d.findElement(By.xpath("//input[@name='answer']")).getAttribute("value").trim().split(" ");
		
		System.out.println(a[3]);
		Assert.assertEquals(a[3],Integer.toString(val*12));
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
