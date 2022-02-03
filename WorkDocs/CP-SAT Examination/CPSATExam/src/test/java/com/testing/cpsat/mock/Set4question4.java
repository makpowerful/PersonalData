package com.testing.cpsat.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set4question4 extends TestBase{
	
	public static final String url= "https://www.shoppersstop.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	public void checkVal(String str) {
		
		wait(3);
		d.findElement(By.xpath("//input[@id='js-site-search-input']")).sendKeys(str, Keys.ENTER);
		wait(3);
		List<WebElement> listbeforeSort=d.findElements(By.xpath("//div[@class='price_div']/ul/li/meta"));
		for(WebElement e: listbeforeSort)
		{
			String a=e.getAttribute("content");
			System.out.println("Price value before unsorted: "+str+" "+a);
		}
		d.findElement(By.xpath("//li[contains(text(),'High')]")).click();
		wait(2);
		List<WebElement> listafterSort=d.findElements(By.xpath("//div[@class='price_div']"));
		for(WebElement f: listafterSort)
		{
			System.out.println("Price value after sorted: "+str+" "+f.getText().trim());
		}
		
	}
	
	@Test
	public void test() throws Exception {
		
		checkVal(readData("src\\test\\resources\\TestData\\TestData.xlsx","Set2aQ4",1,0));
		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
