package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set2Aquestion5 extends TestBase{
	
	public static final String url= "https://www.premierleague.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws InterruptedException {
		
		checkPageReady();
		d.findElement(By.xpath("//div[contains(text(),'I accept cookies from this site')]")).click();
		d.findElement(By.xpath("//ul[@class='showMoreEnabled']/li[4]/a[contains(text(),'Tables')]")).click();
		wait(3);
		//Actions action=new Actions(d);
		//action.moveToElement(d.findElement(By.xpath("//td[@class='team']/a/following::span[@class='long'][contains(text(),'Everton')]"))).sendKeys(Keys.CONTROL).click().build().perform();
		wait(3);
		WebElement link= d.findElement(By.xpath("//td[@class='team']/a/following::span[@class='long'][contains(text(),'Everton')]"));
		
		Scrollpagedown();
		link.click();
		wait(2);
		System.out.println(d.findElement(By.xpath("//div[@class='website'][1]/span[@class='label'][1]/following::a[1]")).getText());
		System.out.println(d.getTitle());
	}
	
	@After
	public void tearDown() {
		/*
		 * if(d != null) { terminate(); }
		 */
	}

}
