package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class JunitTemplate extends TestBase{
	
	public static final String url= "";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
