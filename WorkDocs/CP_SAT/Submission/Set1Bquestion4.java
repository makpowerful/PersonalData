package com.testing.cpsat.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set1Bquestion4 extends TestBase{
	
	public static final String url= "https://www.rediff.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws Exception {
		
		List<WebElement> lst = d.findElements(By.xpath("//div[@id='topdiv_0']/h2/a"));
		for(int i=0;i<lst.size();i++) {
			
			String a= lst.get(i).getAttribute("href");
			setData("src\\test\\resources\\TestData\\TestData.xlsx", "Set1bQ4", i, 0, a);
			
		}
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
