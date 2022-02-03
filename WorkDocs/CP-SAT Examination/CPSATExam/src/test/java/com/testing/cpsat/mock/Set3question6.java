package com.testing.cpsat.mock;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set3question6 extends TestBase{
	
	public static final String url= "https://en.wikipedia.org/wiki/Main_Page";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		
		d.findElement(By.xpath("//input[@name='search']")).sendKeys("Memento (film)");
		d.findElement(By.xpath("//input[@name='go']")).click();
		wait(2);
		String[] a= d.findElement(By.xpath("//tr[14]/td[@class='infobox-data']")).getText().trim().split(" ");
		int b= Integer.valueOf(a[0]);
		int hours = b / 60; //since both are ints, you get an int
		int minutes = b % 60;
		//System.out.printf("%d:%02d", hours, minutes);
		//System.out.println(hours+":"+minutes);
		
		Assert.assertEquals(hours+":"+minutes,"1:53");
		
		String name=d.findElement(By.xpath("//tr[3]/td[@class='infobox-data']/a")).getText();
		
		Assert.assertEquals(name, "Christopher Nolan");
		
		try {
			String BoxOffice=d.findElement(By.xpath("//tr[18]/td[@class='infobox-data']")).getText();
			Assert.assertEquals(BoxOffice, "$39.7 million");
		}
		catch(Throwable t) {
			System.out.println("The BoxOffice amount is not $39.7 million" );
		}
		
		ArrayList<String> cast1 = new ArrayList<String>();
		List<WebElement> lst1=d.findElements(By.xpath("//div[@class='div-col']/ul/li/a"));
		List<WebElement> lst2=d.findElements(By.xpath("//div[@class='div-col']/ul/li"));
		for(int i=0;i<lst1.size();i++) {
			
			System.out.println(lst2.get(i).getText());
			
		}
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
