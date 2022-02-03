package com.testing.cpsat.mock;

import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set1Aquestion3 extends TestBase{
	
	public static final String url= "https://www.rediff.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws InterruptedException {
		
		Set1Aquestion3POM pom= new Set1Aquestion3POM(d);
		wait(1);
		pom.GetBSEvalue();
		pom.GetNSEvalue();
		pom.EnterMFvalue();
		pom.Newwindowtitle();
		assertTrue(pom.Newwindowtitle().contains("RELIANCE"));
		
		assertTrue(pom.Oldwindowtitle().contains("Rediff.com:"));
     	
	}
	
	@After
	public void tearDown() {
		if(d != null) {
		terminate();
		}
	}

}
