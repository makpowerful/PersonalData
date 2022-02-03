package com.testing.cpsat.mock;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set1Aquestion1 extends TestBase {

	public static final String url = "https://www.rediff.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}

	@Test
	public void test() throws InterruptedException {

		
		  d.findElement(By.xpath("//a[contains(text(),'NEWS')]")).click(); wait(2);
		  takeTheScreenShot("Set1AQ");
		  
		  wait(2); List<WebElement> lst = d.findElements(By
		  .xpath("//div[contains(concat(\" \", normalize-space(@class), \" \"), \" subnavbar news\")]/ul/li/a"
		  )); for (int i = 0; i < lst.size(); i++) {
		  
		  System.out.println(lst.get(i).getAttribute("href"));
		  
		  }
		  
		  Assert.assertTrue(d.findElement(By.xpath("//a[contains(text(),'BUSINESS')]"))
		  .getAttribute("title") .contains("Business headlines"));
		  
		  WebElement business =
		  d.findElement(By.xpath("//a[contains(text(),'BUSINESS')]")); Actions action =
		  new Actions(d); action.moveToElement(business).build().perform(); wait(2);
		  takeScreenShotTip("Set1AQ", "Tooltip01");
		  
		  String a =
		  d.findElement(By.xpath("//li[@class='news']")).getCssValue("background-color"
		  ); 
		  String b = Color.fromString(a).asRgb(); System.out.println(b);
		  Assert.assertEquals(b, "rgb(188, 62, 49)");
		 

		
		 // d.get("https://www.color-blindness.com/color-name-hue");
		  checkPageReady();
		  String i_frame="//iframe";
		  d.switchTo().frame(d.findElement(By.xpath(i_frame)));
		  wait(1);
		  JavascriptExecutor js=(JavascriptExecutor)d;
		  js.executeScript("document.getElementById('cp1_Red').value='188';");
		  d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys(Keys.ENTER);
		  wait(2);
		  //d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys(Keys.CONTROL + "a",Keys.DELETE,"188", Keys.ENTER);
		  //wait(1);
		  js.executeScript("document.getElementById('cp1_Green').value='62';");
		  d.findElement(By.xpath("//input[@id='cp1_Green']")).sendKeys(Keys.ENTER);
		  wait(2);
		  //d.findElement(By.xpath("//input[@id='cp1_Green']")).sendKeys(Keys.CONTROL + "a",Keys.DELETE,"62", Keys.ENTER);
		  d.findElement(By.xpath("//input[@id='cp1_Blue']")).sendKeys("49", Keys.ENTER);
		  wait(1);
         Assert.assertEquals(d.findElement(By.xpath("//div[@id='cp1_ColorNameText']")).getText(), "Grenadier");
	}

	@AfterTest
	public void tearDown() throws Exception {
		if (d != null) {
			terminate();
		}
	}

}
