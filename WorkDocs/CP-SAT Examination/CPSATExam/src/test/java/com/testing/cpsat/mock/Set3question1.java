package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Set3question1 extends TestBase{

	public static final String url = "https://jqueryui.com/checkboxradio/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() {
		
		wait(2);
		WebElement frame = d.findElement(By.xpath("//iframe"));
		d.switchTo().frame(frame);
		wait(1);
		WebElement Pradio_xpath=d.findElement(By.xpath("//label[contains(text(),'Paris')]"));
		try {
			Assert.assertTrue(Pradio_xpath.isSelected()==false);
			System.out.println("Paris radio button is not  selected.");
			Pradio_xpath.click();
		}
		catch(Throwable t) {
			System.out.println("Paris radio button is  selected.");
		}
		
		List<WebElement> chckbox=d.findElements(By.xpath("//fieldset[2]/label"));
		for(WebElement e: chckbox) {
			
			e.click();
		}
		
	
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		
		  if(d != null) { terminate(); }
		 
	}

}
