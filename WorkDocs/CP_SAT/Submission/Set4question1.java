package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

import junit.framework.Assert;

public class Set4question1 extends TestBase{
	
	public static final String url= "http://www.cii.in";
	private static Actions act;
	
	@Before
	public void setUp() {
		init("Chrome",url);
		act= new Actions(d);
	}
	
	@Test
	public void test() throws InterruptedException {
		
		Set4question1POM pom= new Set4question1POM(d);
		pom.GotillAgriculture(act);
		checkPageReady();
		Assert.assertEquals(d.getTitle(), "Sectors");
		pom.SocialTitle();
		takeTheScreenShot("Set4Q1");
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
