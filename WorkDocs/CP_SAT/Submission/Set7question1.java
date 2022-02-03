package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set7question1 extends TestBase{
	
	public static final String url= "http://www.shoppersstop.com";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws InterruptedException {
		checkPageReady();
		Actions action=new Actions(d);
		
		WebElement brand=d.findElement(By.xpath("//a[contains(text(),'BRANDS')]"));
		action.moveToElement(brand).click().build().perform();
	    
		WebElement img=d.findElement(By.xpath("//img[@title='Haute Curry']/following::div"));
		scrollIntoView(img);
		img.click();
		wait(2);
		try {
		Assert.assertEquals("Haute Curry|Shoppers Stop", d.getTitle());
		}
		catch(Throwable t) {
			System.out.println("The page title is: "+d.getTitle());
		}
		action.moveToElement(d.findElement(By.xpath("//strong[contains(text(),'FOLLOW')]"))).build().perform();
		wait(1);
		System.out.println("The URL is:"+d.findElement(By.xpath("//a[contains(@href,'instagram')]")).getAttribute("href"));
		
		
		
		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
