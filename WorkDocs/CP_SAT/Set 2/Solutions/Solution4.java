package com.Solutions;

import static org.testng.Assert.assertNotSame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Solutions4 extends TestBase {

	int counter = 1;

	@BeforeMethod
	@Parameters({ "browser" })
	public void launchApplication() throws Throwable {
		init("Chrome", "https://exammay2020.agiletestingalliance.org/");
		waitForElementToVisible(d.findElement(By.className("eicon-close")));
		d.findElement(By.className("eicon-close")).click();
//		mouseover(d, d.findElement(By.xpath("(//ul[@id='menu-main-1']//a[text()='Pages'])")));

		checkPageReady();
	}

	@Test()
	public void appTest() throws Throwable {

		mouseover(d, d.findElement(By.xpath("(//ul[@id='menu-main-1']//a[text()='Pages'])")));
		d.findElement(By.xpath("(//*[@id='menu-main-1']/li[5]/ul/li[2]/a)[1]")).click();
		WebElement tickersSection = d.findElement(By.xpath("//ul[@class='eael-tab-inline-icon']"));
		scrollIntoView(tickersSection);
		d.findElement(By.className("eicon-close")).click();
		takeScreenShot(d, "Question4_Upcoming Meetups and Events");
		List<WebElement> tickers = d.findElements(By.xpath("//div[@class='ticker-content']//a"));
		String tickerMsg = "";
		boolean flag = false;
		for (WebElement ticker : tickers) {
			String theTextIWant = ticker.getAttribute("textContent");
			tickerMsg = theTextIWant + " ,";
			System.out.println(theTextIWant);
			if (tickerMsg.contains(theTextIWant)) {

				flag = true;
			}
		}
		if (!flag) {
			System.out.println("Messages are not matching");
		}
		for (WebElement ticker : tickers) {
			if (ticker.getAttribute("href") == null || ticker.getAttribute("href") == "") {

			} else {
				System.out.println(ticker.getAttribute("href"));
			}

		}
		int count = 1;
		List<WebElement> plusIcon = d
				.findElements(By.xpath("//i[@class='fa-toggle fas fa-angle-down']//preceding-sibling::i"));
		for (WebElement ele : plusIcon) {
			String beforeClick = ele.getCssValue("color");
			String beforeClick1 = Color.fromString(beforeClick).asRgb();
			jsClick(ele);
			String afterClick = ele.getCssValue("color");
			String afterClick1 = Color.fromString(afterClick).asRgb();
			wait(2);
			System.out.println(
					d.findElement(By.xpath("(//div[contains(@id,'elementor-tab-conten')]//p[2])[" + count + "]"))
							.getText());
			System.out.println();
			count++;
			assertNotSame(beforeClick1, afterClick1, "not same");
			System.out.println("Before Click RGB Color : " + beforeClick1);
			System.out.println("After Click RGB Color : " + afterClick1);
		}
	}

	@AfterMethod
	public void closeBrowser() {
		d.quit();
	}

}