package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Set2Aquestion1 extends TestBase{

	public static final String url = "https://www.meripustak.com";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() {
		
		System.out.println("The height of the log is: "+d.findElement(By.xpath("//img[@class='img-responsive']")).getSize().getHeight());
		System.out.println("The width of the log is: "+d.findElement(By.xpath("//img[@class='img-responsive']")).getSize().getWidth());
		
		System.out.println("The pinterest target URL is : "+d.findElement(By.xpath("//div[@class='social links_right']/a[4]")).getAttribute("href"));
	
		d.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).click();
		wait(3);
		Assert.assertEquals(d.findElement(By.xpath("//table/tbody/following::tr[2]/td/h4")).getText().trim(),"No Item is Added In Cart yet.Cart is Empty!!!");
		
		d.findElement(By.xpath("//input[@name='search']")).sendKeys("cricket",Keys.ENTER);
		wait(3);
		scrollIntoView(d.findElement(By.xpath("//p[@class='btn-add'][1]")));
		d.findElement(By.xpath("//p[@class='btn-add'][1]")).click();
		wait(2);
		d.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).click();
		try {
			Assert.assertEquals(d.findElement(By.xpath("//table/tbody/following::tr[2]/td/h4")).getText().trim(),"No Item is Added In Cart yet.Cart is Empty!!!");
			
		}
		catch(Throwable t) {
			
			System.out.println("No Item is Added In Cart yet.Cart is Empty!!! wording is  not present");
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
