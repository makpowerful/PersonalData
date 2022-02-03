package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Set6question3 extends TestBase{
	
	public static final String url= "http://maps.google.com";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		//Peace Apartments(TC Palya)
		//Deloitte Campus
		//Search for your home address (2 points) 
		
		wait(2);
		d.findElement(By.xpath("//input[@id='searchboxinput']")).sendKeys("Peace Apartments(TC Palya)", Keys.ENTER);
		wait(2);
		
		//Print the address text that is displayed in the left frame (2 points) 
		String address=d.findElement(By.xpath("//div[@class='rogA2c']/div[@class='QSFF4-text gm2-body-2'][contains(text(),'3rd')]")).getText();
		System.out.println("The address details are: "+address);
		//Take screenshot of the page at this instant and save the image (2 points) 
		takeTheScreenShot("Set6Q3");
		//Click on direction and get direction from your office address to your home (2 points) 
		d.findElement(By.xpath("//button[@data-value='Directions']")).click();
		wait(2);
		d.findElement(By.xpath("//div[@class='sbib_b']/input[@dir='ltr']")).sendKeys("Deloitte Campus", Keys.ENTER);
		wait(1);
		
		
		//Display the first option distance and time suggested in eclipse console (2 points) 
		String Distance= d.findElement(By.xpath("//div[@class='section-directions-trip-distance section-directions-trip-secondary-text']/child::div[1]")).getText();
		String Time=d.findElement(By.xpath("//div[@class='section-directions-trip-duration delay-light']/span")).getText();
		System.out.println("The Distance taken is: "+Distance+", and the Time take is: "+Time);

	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
