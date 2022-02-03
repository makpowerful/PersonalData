package com.testing.cpsat.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.junit.Assert;


import com.testing.base.TestBase;

public class Dummy extends TestBase{
	
	public static final String url = "https://mockexam2cpsat.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() throws InterruptedException, Throwable {
		
		Actions action=new Actions(d);
		
			//b) Click on the "ABOUT" Menu
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'About')]")).click();
		wait(1);
		
		
			//g) Go to the section where the logos of CPSAT are shown (image 4.4) – 3 marks
			//• Take the mouse over the respective logos
			//• Tool tips are shown – take a screen shot showing the tooltips for each logo
			//• Extract the tool tip and print on the console for each of the logo
		
		scrollIntoView(d.findElement(By.xpath("//div[@class='elementor-image']")));
		wait(1);
		int k=1;
		List<WebElement> lst_clickicon = d.findElements(By.xpath("//div[@class='elementor-image']"));
		//List<WebElement> lst_getscript= d.
		for(int j=0;j<lst_clickicon.size();j++) {
			
			action.moveToElement(lst_clickicon.get(j)).build().perform();
			wait(1);
			takeScreenShotTip("TipMock2Q4", "Tip"+k);
			wait(1);
			//JavascriptExecutor js=(JavascriptExecutor)d;
			//System.out.println(js.executeScript("return document.getElementsByTagName('script')[1].innerText;"));
			//System.out.println(js.executeScript("document.getElementsByTagName('script')[1].valueOf('content');"));
			System.out.println(d.findElement(By.xpath("//div[@class='elementor-widget-wrap']/div/script/parent::div")).getAttribute("data-settings"));
			String[] a=d.findElement(By.xpath("//div[@class='elementor-widget-wrap']/div/script")).getAttribute("innerHTML").split("'");
			System.out.println(a[5]);
			System.out.println(a[6]);
			System.out.println(a[7]);
			System.out.println(a[8]);
			k++;
			
			
		}
		
		
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
