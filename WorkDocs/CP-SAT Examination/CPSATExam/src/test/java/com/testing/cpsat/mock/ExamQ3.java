package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class ExamQ3 extends TestBase{
	
	public static final String url= "https://www.rediff.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws InterruptedException {
		
		ExamQ3POM pom= new ExamQ3POM(d);
		
		pom.BSEIndex();
		pom.NSEIndex();
		pom.EnterCompany();
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
