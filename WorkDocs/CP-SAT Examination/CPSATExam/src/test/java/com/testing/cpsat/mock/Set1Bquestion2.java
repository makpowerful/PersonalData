package com.testing.cpsat.mock;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Set1Bquestion2 extends TestBase{

	public static final String url = "https://www.rediff.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}
	
	public void checkMenu(String menustr) throws InterruptedException {
		
		List <WebElement> menu=d.findElements(By.xpath("//li[@class='"+menustr+"']"));
		Assert.assertEquals(menu.size()>0, true);
		menu.get(0).click();
	}
	
	public void checkSubMenu(String submenustr) {
		
		List<WebElement> submenu=d.findElements(By.xpath("//a[contains(text(),'"+submenustr+"')]"));
		Assert.assertEquals(submenu.size()>0, true);
	}
	
	public void checkSubMenulink(String submenustr, String actuallink) {
		
		List<WebElement> submenu=d.findElements(By.xpath("//a[contains(text(),'"+submenustr+"')]"));
		if(submenu.size()>0) {
			String al= d.findElement(By.xpath("//a[contains(text(),'"+submenustr+"')]")).getAttribute("href");
			Assert.assertEquals(al,actuallink);
			d.findElement(By.xpath("//a[text()='"+submenustr+"']")).click();
			wait(3);
			takeTheScreenShot("Set1b_Q2");
			d.navigate().back();
			wait(3);
		}
		
	}
	

	@Test
	public void test() throws Throwable {
	
		for(int i =0;i< getRowCount("src\\test\\resources\\TestData\\TestData.xlsx","Set1bQ2") ;i++) {
			
			checkMenu(readData("src\\test\\resources\\TestData\\TestData.xlsx","Set1bQ2" ,i, 0));
			checkSubMenu(readData("src\\test\\resources\\TestData\\TestData.xlsx","Set1bQ2", i, 1));
			checkSubMenulink(readData("src\\test\\resources\\TestData\\TestData.xlsx","Set1bQ2", i, 1),readData("src\\test\\resources\\TestData\\TestData.xlsx","Set1bQ2", i, 2));
		}
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
