package com.testing.cpsat.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set1Aquestion4 extends TestBase{
	
	public static final String url= "https://www.rediff.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws Exception {
		
		Set1Aquestion4POM pom = new Set1Aquestion4POM(d);
		wait(2);
		//pom.ElementList();
		List<WebElement> list=d.findElements(By.xpath("//div[@id='topdiv_0']/h2/a"));
		for(int i=0;i<list.size();i++) {
			
			System.out.println(list.get(i).getAttribute("href"));
			
			setData("src\\test\\resources\\TestData\\TestData.xlsx", "Question4", i, 0, list.get(i).getAttribute("href"));
	}}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
