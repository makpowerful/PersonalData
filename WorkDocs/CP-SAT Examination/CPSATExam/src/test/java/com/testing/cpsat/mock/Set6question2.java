package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set6question2 extends TestBase{
	
	public static final String url= "https://www.wikipedia.org/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		
		String a=d.findElement(By.xpath("//a[@id='js-link-box-en']/small")).getText();
		System.out.println("The number of articles in Engilsh are"+a);
		
		d.findElement(By.xpath("//strong[contains(text(),'English')]")).click();
		wait(2);
		
		d.findElement(By.xpath("//input[@name='search']")).sendKeys("Anna University");
		d.findElement(By.xpath("//input[@name='go']")).click();
		wait(2);
		
		WebElement b=d.findElement(By.xpath("//td[@class='infobox-data'][contains(text(),'Knowledge')]"));
		System.out.println(b.getText());
		
		Assert.assertTrue(b.getText().contains("Knowledge"));
		
		Assert.assertTrue(d.findElement(By.xpath("//a[contains(text(),'Ashwin')]")).getText().contains("Ravichandran"));
		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
