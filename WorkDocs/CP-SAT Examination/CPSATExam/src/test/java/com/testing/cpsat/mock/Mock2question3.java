package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Mock2question3 extends TestBase{
	
	public static final String url= "https://mockexam2cpsat.agiletestingalliance.org/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws InterruptedException {
		
		Mock2question3POM pom=  new Mock2question3POM(d);
		pom.Navi_Inputfield();
		pom.Entervalue("199");
		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
