package com.testing.cpsat.mock;



import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;


public class Set2Bquestion1 extends TestBase{

	public static final String url = "https://www.meripustak.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() throws InterruptedException {
		try {
		SoftAssert softassert=new SoftAssert();
	
		int a= d.findElement(By.xpath("//img[@title='Meripustak Online bookstore']")).getSize().getHeight();
		int b= d.findElement(By.xpath("//img[@title='Meripustak Online bookstore']")).getSize().getWidth();
		System.out.println("The height of the logo is: "+a+", and the width of the logo is: "+b);
		
		WebElement link= d.findElement(By.xpath("//div[@class='social links_right']/a[@href='https://twitter.com/meripustak']"));
		scrollIntoView(link);
		wait(2);
		System.out.println(link.getAttribute("href"));
		
		Scrollhome();
		d.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).click();
		checkPageReady();
		String CartValue= d.findElement(By.xpath("//td/h4")).getText();
		System.out.println(CartValue);
		softassert.assertTrue(CartValue.contains("No Item is Added In Cart yet. Cart is Empty!!!"));
		
		d.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys("Java 3Ed In Easy Steps", Keys.ENTER);
		wait(2);
		d.findElement(By.xpath("//p[@class='btn-add']")).click();
		Scrollhome();
		
		d.findElement(By.xpath("//a[contains(text(),'Shopping Cart')]")).click();
		checkPageReady();
		System.out.println(CartValue);
		Assert.assertTrue(CartValue.contains("No Item is Added In Cart yet. Cart is Empty!!!"));
		}
		catch(Exception e) {
			System.out.println("Text: 'No Item is Added In Cart yet. Cart is Empty!!!'  is  not  present");
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
