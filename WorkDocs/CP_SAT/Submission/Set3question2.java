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


public class Set3question2 extends TestBase{

	public static final String url = "https://code.makery.ch/library/dart-drag-and-drop/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() throws InterruptedException {
		wait(2);
		scrollIntoView(d.findElement(By.xpath("//h3[@id='custom-drag-avatar']")));
		WebElement frame=d.findElement(By.xpath("//iframe[2]"));
		d.switchTo().frame(frame);
		
		List<WebElement> scrImg= d.findElements(By.xpath("//a[contains(@href,'example/custom_avatar')]//following-sibling::img"));
		WebElement trashImg= d.findElement(By.xpath("//a[contains(@href,'example/custom_avatar')]//following-sibling::div"));
		
		for(int i=0;i<scrImg.size();i++) {
			takeTheScreenShot("Set3Q2");
			Actions action=new Actions(d);
			action.dragAndDrop(scrImg.get(i), trashImg).build().perform();
			wait(2);
			
			
		}
		
	
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
