package com.testing.cpsat.mock;

import java.io.IOException;
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

public class Set6question1 extends TestBase {

	public static final String url = "http://www.pepperfry.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}

	public void Noresult(String tr) {

		d.findElement(By.id("search")).click();
		d.findElement(By.id("search")).sendKeys(tr, Keys.ENTER);
		System.out.println(tr);
		takeScreenShotTip("Set6Q1", "No Result " + tr);

	}

	public void chcksort(String str) throws InterruptedException {
		wait(1);
		d.findElement(By.id("search")).sendKeys(str, Keys.ENTER);
		if(str.contentEquals("Padlocks"))
				{
			
			takeScreenShotTip("Set6Q1", "No Result " + str);
			
		}
		
		else {
		WebElement lst1 = d.findElement(By.xpath("//div[@class='clip-dtl-ttl row']"));
		Scrollpagedown();
		takeScreenShotTip("Set6Q1", "Unsorted " + str);

		WebElement lstsort = d.findElement(By.id("curSortType"));
		scrollIntoView(lstsort);
		Scrollpageup();
		wait(1);
		lstsort.click();
		d.findElement(By.xpath("//li[@class='clip-drpdwn-flxlist ']/a[contains(text(),'Price Low to High')]")).click();
		wait(2);
		scrollIntoView(lst1);
		takeScreenShotTip("Set6Q1", "Sorted " + str);
		d.findElement(By.id("search")).clear();
		wait(1);
		}

	}

	@Test
	public void test() throws Throwable, Exception {

		checkPageReady();
		WebElement frame = d.findElement(By.xpath("//iframe[@data-notification-layout-name='banner']"));
		d.switchTo().frame(frame);
		d.findElement(By.cssSelector(".wewidgeticon.we_close.icon-large")).click();
		wait(3);
		d.findElement(By.xpath("//div[@id='regPopUp']/a[@class='popup-close']")).click();
		wait(3);
		d.findElement(By.id("search")).click();

		for (int i = 0; i < 3; i++) {

			chcksort(readData("src\\test\\resources\\TestData\\TestData.xlsx", "Set6Q1", i, 0));
		}

		//Noresult(readData("src\\test\\resources\\TestData\\TestData.xlsx", "Set6Q1", 3, 0));
		

	}

	@AfterTest
	public void tearDown() throws Exception {
		/*
		 * if(d != null) { terminate(); }
		 */
	}

}
