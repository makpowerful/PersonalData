package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set2Aquestion3 extends TestBase{
	
	public static final String url= "https://www.hometown.in/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		//d.switchTo().alert().accept();
		WebElement more=d.findElement(By.xpath("//div[contains(text(),'More')]"));
		Actions action=new Actions(d);
		action.moveToElement(more).build().perform();
		wait(1);
		d.findElement(By.xpath("//a[@title='Gifting Ideas']")).click();
		wait(3);
		WebElement color=d.findElement(By.xpath("//p[contains(text(),'Color')]"));
		action.moveToElement(color).build().perform();
		d.findElement(By.xpath("//label[contains(text(),'white')]")).click();
		wait(2);
		Assert.assertTrue(d.findElement(By.xpath("//div[@class='tags']/ul/li/p")).getText().contains("white"));
		Assert.assertTrue(d.findElement(By.xpath("//div[@class='child_flex'][1]/p[1]/a")).getText().contains("White"));
		
	}
	
	@After
	public void tearDown() {
		
		  if(d != null) { terminate(); }
		 
	}

}
