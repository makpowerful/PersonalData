package com.testing.cpsat.mock;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set2Bquestion3 extends TestBase{
	
	public static final String url= "https://www.premierleague.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws InterruptedException, AWTException {
		String Mainwin;
		wait(3);
		d.findElement(By.xpath("//div[@role='btn']")).click();
		Mainwin= d.getWindowHandle();
		d.findElement(By.xpath("//li[@data-nav-index='3']/a")).click();
		Actions action=new Actions(d);
		wait(2);
		WebElement Ars_link= d.findElement(By.xpath("//td[@class='team']/a/child::span[2][contains(text(),'Arsenal')]"));
		wait(2);
		action.moveToElement(Ars_link).build().perform();
		action.contextClick(Ars_link).build().perform();
		wait(1);
		
		Robot robot = new Robot();

		robot.delay(1500); 
		robot.keyPress(KeyEvent.VK_DOWN); 
		robot.keyRelease(KeyEvent.VK_DOWN); 
		robot.delay(1500); 
		robot.keyPress(KeyEvent.VK_DOWN); 
		robot.keyRelease(KeyEvent.VK_DOWN); 
		robot.delay(1500); 
		robot.keyPress(KeyEvent.VK_ENTER);	

		//action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		wait(3);
		switchWindow();
		
		System.out.println(d.findElement(By.xpath("//div[@class='website']/a")).getText());
		System.out.println(d.getTitle());
		
		d.switchTo().window(Mainwin);
		wait(1);
		System.out.println(d.getTitle());
		
	}
	
	@After
	public void tearDown() {
		/*
		 * if(d != null) { terminate(); }
		 */
	}

}
