package com.testing.cpsat.mock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Mock2question2 extends TestBase {

	public static final String url = "https://mockexam2cpsat.agiletestingalliance.org/";
	public static int rowCounter = 0;

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}

	@DataProvider(name = "dataProviderDetails")
	public Object[][] testDP() throws Exception {

		Object[][] data = readData("src\\test\\resources\\TestData\\TestData.xlsx", "Mock2Q2");
		return data;
	}

	@Test(priority = 0)
	public void initial() {

		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'About')]")).click();
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//input[@type='text']")));
		wait(1);

	}

	@Test(dataProvider = "dataProviderDetails", priority = 1)
	public void test(String Testno, String citydp, String YEdp, String CAdp, String ExpResdp) throws Exception {

		System.out.println(citydp);
		// readData("src\\test\\resources\\TestData\\TestData.xlsx","Mock2Q2",i,1)
		d.findElement(By.xpath("//input[@type='text']")).sendKeys(citydp, Keys.ENTER);
		wait(3);
		
		/*
		 * if(citydp=="City 6") {
		 * 
		 * List<WebElement> lst_Value = d.findElements(By.
		 * xpath("//tbody/tr[@class='ninja_table_row_5 nt_row_id_6']/td")); String city
		 * = lst_Value.get(0).getText(); String YE = lst_Value.get(1).getText(); String
		 * CA = lst_Value.get(2).getText(); String res1 = ""; String res2 = ""; }
		 */

		List<WebElement> lst_Value = d.findElements(By.xpath("//tbody/tr/td"));

		String city = lst_Value.get(0).getText();
		String YE = lst_Value.get(1).getText();
		String CA = lst_Value.get(2).getText();
		String res1 = "";
		String res2 = "";

		System.out.println(city + "-" + YE + "-" + CA);
		d.findElement(By.xpath("//input[@type='text']")).clear();
		wait(1);
		//d.findElement(By.xpath("//span[@class='fooicon fooicon-remove']")).click();
		wait(2);
		if (city.equalsIgnoreCase(citydp) && YE.equalsIgnoreCase(YEdp) && CA.equalsIgnoreCase(CAdp)) {
			res1 = "Pass";
			res2="Matched";
		} else {
			res1 = "Fail";
			res2="Not Matched";
		}

		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock2Q2", rowCounter, 0, Testno);
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock2Q2", rowCounter, 1, citydp);
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock2Q2", rowCounter, 2, YE);
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock2Q2", rowCounter, 3, CA);
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock2Q2", rowCounter, 4, res1);
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock2Q2", rowCounter, 5, res2);

		rowCounter++;
	}


	@AfterTest
	public void tearDown() throws Exception {
		if (d != null) {
			terminate();
		}
	}

}
