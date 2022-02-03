package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Mock1question3 extends TestBase{
	
	public static final String url= "https://mockexam1cpsat.agiletestingalliance.org/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		
		Mock1question3POM pom= new Mock1question3POM(d);
		pom.ClickHam();
		pom.Scroll_Click_Partimenu();
		pom.ListNames();
		pom.ListDesNames();
		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
