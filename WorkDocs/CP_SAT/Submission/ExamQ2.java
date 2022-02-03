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

public class ExamQ2 extends TestBase {

	public static final String url = "https://www.rediff.com/";

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}

	public void CheckMenu(String str) {

		String a = d.findElement(By.xpath("//li[@class='news']")).getText();
		Assert.assertEquals(str, a);

	}

	public void CheckSubMenu(String tr) {

		d.findElement(By.xpath("//li[@class='news']")).click();

		// WebElement b= d.findElement(By.xpath("//div[@class='subnavbar
		// news']/ul[@class='navbarul']/li/a[contains(text(),'"+tr+"')]"));
		// System.out.println(b);
		List<WebElement> a = d.findElements(
				By.xpath("//div[@class='subnavbar news']/ul[@class='navbarul']/li/a[contains(text(),'" + tr + "')]"));
		System.out.println(a.size());
		Assert.assertEquals(a.size() > 0, true);
		// takeTheScreenShot("ExamQ2");

	}
	// Assert that for the menu/Sbumenu, actual Href is same as expected HREF as per
	// excel sheet value – 4 marks

	// Click on the submenu and take a screenshot of the new window thus opened. - 3
	// marks.
	// Name the screen shot files as .jpg - 2 marks
	public void CheckAllhref(String str2, String tr) {

		String b = d
				.findElement(By.xpath(
						"//div[@class='subnavbar news']/ul[@class='navbarul']/li/a[contains(text(),'" + str2 + "')]"))
				.getAttribute("href");
		Assert.assertEquals(b, tr);
		wait(1);
		d.findElement(
				By.xpath("//div[@class='subnavbar news']/ul[@class='navbarul']/li/a[contains(text(),'" + str2 + "')]"))
				.click();
		wait(1);
		takeTheScreenShot("ExamQ2");
		d.navigate().back();
	}

	@Test
	public void test() throws Throwable, Exception {
		// Read the values of Menu / SubMenu and Href from excel sheet and for each row
		// and do the following – 6 marks

		for (int i = 0; i < getRowCount("src\\test\\resources\\TestData\\TestData.xlsx", "ExamQ2"); i++) {

			CheckMenu(readData("src\\test\\resources\\TestData\\TestData.xlsx", "ExamQ2", i, 0));
			CheckSubMenu(readData("src\\test\\resources\\TestData\\TestData.xlsx", "ExamQ2", i, 1));
			CheckAllhref(readData("src\\test\\resources\\TestData\\TestData.xlsx", "ExamQ2", i, 1),
					readData("src\\test\\resources\\TestData\\TestData.xlsx", "ExamQ2", i, 2));
		}

	}

	@AfterTest
	public void tearDown() throws Exception {
		if (d != null) {
			terminate();
		}
	}

}
