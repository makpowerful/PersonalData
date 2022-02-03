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

public class ExamQ1 extends TestBase {
	// Open the website https://www.rediff.com/ (1/2 mark)
	public static final String url = "https://www.rediff.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}

	@Test
	public void test() throws Throwable {

		// Click on the menu for News (1/2 mark)
		d.findElement(By.xpath("//a[contains(text(),'NEWS')]")).click();

		// Take a screenshot (showing that the News is clicked) (1/2 mark)
		takeTheScreenShot("ExamQ1");
		// Get the Href’s of all the submenu items (e.g headlines, defence etc) (2
		// marks)
		List<WebElement> lst = d.findElements(By.xpath("//div[@class='subnavbar news']/ul[@class='navbarul']/li/a"));
		for (WebElement e : lst) {
			System.out.println(e.getAttribute("href"));

		}
		// Assert that the tool tip of the adjacent menu item Business is “Business
		// Headlines” (1.5 marks)
		WebElement Bussiness = d.findElement(By.xpath("//a[contains(text(),'BUSINESS')]"));
		try {
			Assert.assertEquals(Bussiness.getAttribute("title"), "Business Headlines");
		} catch (Throwable t) {
			System.out.println("The title value is: " + Bussiness.getAttribute("title"));

		}
		// Hover the mouse on the adjacent menu item (Business) showing the tool tip
		// “Business Headlines”. Take a screenshot showing the tooltip (4 marks)
		Actions action = new Actions(d);
		action.moveToElement(Bussiness).build().perform();
		wait(1);
		takeScreenShotTip("ExamQ1", "tooltip");

		// Assert that the background colour of the submenu items for News is having the
		// following RGB (188, 62, 49) value. ( 2 Marks)
		String a=d.findElement(By.xpath("//li[@class='news']")).getCssValue("background-color");
		String b=Color.fromString(a).asRgb();
		System.out.println(b);
		Assert.assertEquals("rgb(188, 62, 49)", b);
		
		// Assert that the value of RGB in above step maps to the following colour name
		// (Grenadier) – Hint use the following website to get the colour name from RGB
		// values https://www.color-blindness.com/color-name-hue/ (4 Marks)
		d.navigate().to("https://www.color-blindness.com/color-name-hue/");
		checkPageReady();
		WebElement frame=d.findElement(By.xpath("//iframe"));
		d.switchTo().frame(frame);
		JavascriptExecutor js=(JavascriptExecutor)d;
		js.executeScript("document.getElementById('cp1_Red').value=188;");
		wait(1);
		js.executeScript("document.getElementById('cp1_Green').value=62;");
		wait(1);
		js.executeScript("document.getElementById('cp1_Blue').value=49;");
		d.findElement(By.id("cp1_Blue")).sendKeys(Keys.ENTER);
		wait(1);
		Assert.assertEquals(d.findElement(By.id("cp1_ColorNameText")).getText(), "Grenadier");

	}

	@AfterTest
	public void tearDown() throws Exception {
		
		  if (d != null) { terminate(); }
		 
	}

}
