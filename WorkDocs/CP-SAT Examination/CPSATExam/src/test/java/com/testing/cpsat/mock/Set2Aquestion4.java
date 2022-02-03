package com.testing.cpsat.mock;

import java.io.IOException;
import java.util.Arrays;
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


public class Set2Aquestion4 extends TestBase{

	public static final String url = "https://www.woodlandworldwide.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}
	
	public void check(String str) throws InterruptedException {
		
		d.findElement(By.xpath("//input[@id='searchKey']")).sendKeys(str, Keys.ENTER);
		checkPageReady();
		List<WebElement> list=d.findElements(By.xpath("//span[@class='price']"));
        for(int l=0;l<8;l++) {
			
			System.out.println("This is the unsorted list for "+str+ ": "+list.get(l).getText().trim().strip());
			//char[] c= list.get(l).getText().toCharArray();
			//System.out.println(Arrays.sort(c));
		}
		WebElement sort= d.findElement(By.xpath("//span[contains(text(),'Sort')]"));
		Actions action=new Actions(d);
		action.moveToElement(sort).build().perform();
		d.findElement(By.xpath("//a[@data-id='price-asc']")).click();
		List<WebElement> list1=d.findElements(By.xpath("//span[@class='price']"));
		for(int m=0;m<8;m++) {
			
			System.out.println("This is the sorted list for "+str+": "+list1.get(m).getText());
			
		}
		System.out.println("******************************************");
		d.navigate().back();
		wait(2);
		d.findElement(By.xpath("//input[@id='searchKey']")).clear();
		wait(1);
	}

	@Test
	public void test() throws Throwable {
	
		for(int i=0;i<getRowCount("src\\test\\resources\\TestData\\TestData.xlsx","Set2aQ4");i++) {
			
			check(readData("src\\test\\resources\\TestData\\TestData.xlsx","Set2aQ4", i, 0));
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
