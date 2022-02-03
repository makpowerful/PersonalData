package cpsatExamTestNG;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set1B_Question1 extends TestBase {

	@BeforeMethod
	public void method1()
	{
		//opening website https://www.rediff.com/ 
		init("Chrome","https://www.rediff.com/");
	}
	
	@Test
	public void Test1() throws InterruptedException
	{
		//Clicking on the menu for BUSINESS 
		waitForElementToClickable(d.findElement(By.xpath("//a[text()='BUSINESS']"))).click();
		
		//Take a screenshot (showing that the BUSINESS is clicked) 
		takeTheScreenShot("Question1B");
		
		//Getting the Href’s of all the submenu items 
		List<WebElement> subMenus=d.findElements(By.xpath("//div[@class='subnavbar business']/ul/li/a"));
		for(int i=0;i<subMenus.size();i++){
			System.out.println(subMenus.get(i).getAttribute("href"));
		}
		Thread.sleep(5000);
		
		//Asserting that the tool tip of the adjacent menu item news is “News Headlines” 
		Assert.assertEquals(d.findElement(By.xpath("//a[text()='NEWS']")).getAttribute("title"), "News headlines");
		
		
		//Hovering the mouse on the adjacent menu item (News) showing the tool tip “News Headlines”. 
		Actions act=new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//a[text()='NEWS']"))).build().perform();
		
		Thread.sleep(15000);
		//Taking a screenshot showing the tooltip. 
		takeScreenShotTip("Question1B");
			
		//Asserting that the background colour of the submenu items for Business is having the following RGB (159,107,63) value. 
		String bgcolor=d.findElement(By.xpath("//li[@class='business']")).getCssValue("background-color");
		String rgbClr=Color.fromString(bgcolor).asRgb();
		Assert.assertEquals(rgbClr, "rgb(159, 107, 63)");
		
		//Assert that the value of RGB in above step maps to the Desert colour name.
		d.navigate().to("https://www.color-blindness.com/color-name-hue/");
		checkPageReady();
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@src='/color-name-hue-tool/color-name-hue.html']")));
		
		String[] clr=rgbClr.split(",");
		waitForElementToClickable(d.findElement(By.xpath("//input[@id='cp1_Red']"))).click();
		d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys("-");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys(clr[0].replaceAll("[^0-9]", ""));
		
		d.findElement(By.xpath("//input[@id='cp1_Green']")).click();
		d.findElement(By.xpath("//input[@id='cp1_Green']")).sendKeys("-");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='cp1_Green']")).sendKeys(clr[1].replaceAll("[^0-9]", ""));
		
		d.findElement(By.xpath("//input[@id='cp1_Blue']")).click();
		d.findElement(By.xpath("//input[@id='cp1_Blue']")).sendKeys("-");
		Thread.sleep(5000);
		d.findElement(By.xpath("//input[@id='cp1_Blue']")).sendKeys(clr[2].replaceAll("[^0-9]", ""));
		takeTheScreenShot("Question1B");
		Assert.assertEquals(d.findElement(By.xpath("//div[@id='cp1_ColorNameText']")).getText(), "Desert");
	}
	
	@AfterMethod
	public void method2()
	{
		terminate();
	}
}
