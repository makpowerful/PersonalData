package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set1Bquestion3 extends TestBase{
	
	public static final String url= "https://www.rediff.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws Throwable {
		checkPageReady();
		Set1Bquestion3POM pom= new Set1Bquestion3POM(d);
		pom.BSEIndexValue();
		pom.NSEIndexValue();
		pom.MFInput();
		switchWindow();
		wait(3);
		System.out.println(d.getTitle());
		Assert.assertTrue(d.getTitle().contains("KOTAK MAHINDRA BANK LTD."));
		d.switchTo().window(pom.Mainwin);
		wait(2);
		Assert.assertTrue(d.getTitle().contains("Rediff.com:"));
		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
