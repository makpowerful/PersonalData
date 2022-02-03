package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set1A_Question1 extends TestBase {

	@BeforeMethod
	public void method1()
	{
		//opening website https://www.rediff.com/ 
		init("Chrome","https://www.rediff.com/");
	}
	
	@Test
	public void Test1() throws InterruptedException
	{
		//Clicking on the menu for News 
		waitForElementToClickable(d.findElement(By.xpath("//a[text()='NEWS']"))).click();
		
		//Take a screenshot (showing that the News is clicked) 
		takeTheScreenShot("Question1");
		
		//Getting the Href’s of all the submenu items 
		List<WebElement> subMenus=d.findElements(By.xpath("//div[@class='subnavbar news']/ul/li/a"));
		for(int i=0;i<subMenus.size();i++){
			System.out.println(subMenus.get(i).getAttribute("href"));
		}
		Thread.sleep(5000);
		
		//Asserting that the tool tip of the adjacent menu item Business is “Business Headlines” 
		Assert.assertEquals(d.findElement(By.xpath("//a[text()='BUSINESS']")).getAttribute("title"), "Business headlines");
		
		
		//Hovering the mouse on the adjacent menu item (Business) showing the tool tip “Business Headlines”. 
		Actions act=new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//a[text()='BUSINESS']"))).build().perform();
		
		Thread.sleep(15000);
		//Taking a screenshot showing the tooltip. 
		takeScreenShotTip("Question1");
			
		//Asserting that the background colour of the submenu items for News is having the following RGB (188, 62, 49) value. 
		String bgcolor=d.findElement(By.xpath("//li[@class='news']")).getCssValue("background-color");
		String rgbClr=Color.fromString(bgcolor).asRgb();
		Assert.assertEquals(rgbClr, "rgb(188, 62, 49)");
		
		//Assert that the value of RGB in above step maps to the Grenadier colour name.
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
		takeTheScreenShot("Question1");
		Assert.assertEquals(d.findElement(By.xpath("//div[@id='cp1_ColorNameText']")).getText(), "Grenadier");
	}
	
	@AfterMethod
	public void method2()
	{
		terminate();
	}
}
