package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

import junit.framework.Assert;


public class Set9question1 extends TestBase{

	public static final String url = "https://www.ndtv.com/business";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() throws InterruptedException {
	
		Set9question1POM pom=new Set9question1POM(d);
		checkPageReady();
		String a= pom.AllTopLoc();
		Scrollend();
		wait(2);
		String b= pom.AllBottomLoc();
		
		Assert.assertEquals(a, b);
			
		
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
