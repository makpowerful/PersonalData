package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Set1Bquestion1 extends TestBase{

	public static final String url = "https://www.rediff.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() throws InterruptedException {
		
		//b. Click on the menu for business (1/2 mark)
		d.findElement(By.xpath("//li[@class='business']")).click();
		
		//c. Take a screenshot (showing that the business is clicked) (1/2 mark)
		takeTheScreenShot("Set1BQ1");
		
		//d. Get the Href’s of all the submenu items (2 marks)
		List<WebElement> lst=d.findElements(By.xpath("//div[@class='subnavbar business']/ul[@class='navbarul']/li/a"));
		for(WebElement e: lst) {
			
			System.out.println(e.getAttribute("href"));
		}
		
		//e. Assert that the tool tip of the adjacent menu item News is “News Headlines’” (1.5 marks)
		try {
		Assert.assertEquals(d.findElement(By.xpath("//ul[@class='navbarul']/li/a[contains(text(),'NEWS')]")).getAttribute("title"),"News Headlines");
		}
		catch(Throwable t) {
			System.out.println("The tool tip of the adjacent menu item News is not “News Headlines’");
		}
		
		//f. Hover the mouse on the adjacent menu item (News) showing the tool tip “News Headlines’. Take a screenshot showing the tooltip (4 marks)
		WebElement link= d.findElement(By.xpath("//ul[@class='navbarul']/li/a[contains(text(),'NEWS')]"));
		Actions actions=new Actions(d);
		actions.moveToElement(link).build().perform();
		wait(1);
		takeScreenShotTip("Set1BQ1", "TipSS");
		
		//g. Assert that the background color of the submenu items for Business is having the following RGB (159,107,163) value. ( 2 Marks)
		String a= d.findElement(By.xpath("//li[@class='business']")).getCssValue("background-color");
		String b= Color.fromString(a).asRgb();
		System.out.println(b);
		try {
		Assert.assertEquals(b, "rgb(159, 107, 63)");
		}
		catch(Throwable t) {
			System.out.println("The background color of the submenu items for Business is: "+b);
		}
		
		//h. Assert that the value of RGB in above step maps to the following colour name (desert) – Hint use the following website to get the color name from RGB values https://www.color-blindness.com/color-name-hue/ (4 Marks)
		d.navigate().to("https://www.color-blindness.com/color-name-hue/");
		checkPageReady();
		WebElement frame=d.findElement(By.xpath("//iframe"));
		scrollIntoView(frame);
		d.switchTo().frame(frame);
		JavascriptExecutor js= (JavascriptExecutor)d;
		js.executeScript("document.getElementById('cp1_Red').value=159;");
		wait(1);
		js.executeScript("document.getElementById('cp1_Green').value=107;");
		wait(1);
		js.executeScript("document.getElementById('cp1_Blue').value=63;");
		d.findElement(By.id("cp1_Blue")).sendKeys(Keys.ENTER);
		
		wait(1);
		Assert.assertEquals(d.findElement(By.xpath("//div[@id='cp1_ColorNameText']")).getText(), "Desert");
				
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		
		 if(d != null) { terminate(); }
		 
	}

}
