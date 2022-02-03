package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set7question2 extends TestBase{
	
	public static final String url= "http://www.imdb.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws InterruptedException {
		checkPageReady();
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("Gangs of New York", Keys.ENTER);
		wait(2);
		d.findElement(By.xpath("//a[contains(text(),'Gangs of New York')][1]")).click();
		
		String[] time=d.findElement(By.xpath("//ul/li[3][@role='presentation']")).getText().trim().split("h ");
		System.out.println(time[0]);
		System.out.println(time[1].replaceAll("min",""));
		
		int min = Integer.valueOf(time[0])*60;
		//System.out.println(min);
		System.out.println(min + Integer.valueOf(time[1].replaceAll("min","")));
		Assert.assertTrue(min + Integer.valueOf(time[1].replaceAll("min",""))<180);
		scrollIntoView(d.findElement(By.xpath("//a[contains(text(),'Crime')]")));
		Assert.assertEquals(d.findElement(By.xpath("//a[contains(text(),'Crime')]")).getText(), "Crime");
		String MPAA= d.findElement(By.xpath("//li[@role='presentation']/span[@class='ipc-metadata-list-item__list-content-item'][contains(text(),'R')]")).getText();
		Assert.assertTrue(MPAA.contains("R"));
		System.out.println("The name of user review is: "+d.findElement(By.xpath("//li[@class='ipc-inline-list__item'][1]/a[contains(@href,'user')]")).getText());

		
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
