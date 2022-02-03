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

public class Set1Aquestion2 extends TestBase {

	public static final String url = "https://www.rediff.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}

	public void checkMenu(String menu) throws InterruptedException{
		wait(3);
		List<WebElement> menuname=d.findElements(By.xpath("(//li[@class='"+menu+"'])[1]"));
		Assert.assertEquals(menuname.size()>0,true);
		menuname.get(0).click();
	}
	
	public void checkSubMenu(String submenu) throws InterruptedException{
		wait(3);
		List<WebElement> submenuname=d.findElements(By.xpath("//a[text()='"+submenu+"']"));
		Assert.assertEquals(submenuname.size()>0,true);
	}

	public void checkSubMenuLink(String submenu,String expectedLink) throws InterruptedException{
		wait(3);
		List<WebElement> submenuname=d.findElements(By.xpath("//a[text()='"+submenu+"']"));
		if(submenuname.size()>0){
			String actlink=d.findElement(By.xpath("//a[text()='"+submenu+"']")).getAttribute("href");
			Assert.assertEquals(actlink,expectedLink);
			d.findElement(By.xpath("//a[text()='"+submenu+"']")).click();
			wait(3);
			takeTheScreenShot("Set1A_Question2");
			d.navigate().back();
			checkPageReady();
		}
	}
	
	@Test
	public void Test() throws Exception {

		for (int i = 0; i < 4; i++) {
			checkMenu(readData("src\\test\\resources\\TestData\\TestData.xlsx", "Question2", i, 0));
			checkSubMenu(readData("src\\test\\resources\\TestData\\TestData.xlsx", "Question2", i, 1));
			checkSubMenuLink(readData("src\\test\\resources\\TestData\\TestData.xlsx", "Question2", i, 1),
					readData("src\\test\\resources\\TestData\\TestData.xlsx", "Question2", i, 2));
		}

	}
	@AfterTest
	public void tearDown() throws Exception {
		if (d != null) {
			terminate();
		}
	}

}
