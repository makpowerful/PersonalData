package com.testing.cpsat.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;

import com.testing.base.TestBase;

public class Set7question3 extends TestBase {

	public static final String url = "https://www.firstcry.com/";

	@Before
	public void setUp() {
		init("Chrome", url);
		/*
		 * Map<String, Object> prefs = new HashMap<String, Object>();
		 * prefs.put("profile.default_content_setting_values.notifications", 2);
		 * ChromeOptions options = new ChromeOptions();
		 * options.setExperimentalOption("prefs", prefs); WebDriver d = new
		 * ChromeDriver(options);
		 */
	}


	@Test
	public void test() throws Exception {

		List<Double> listprice = new ArrayList<Double>();
		List<Double> sortedprice = new ArrayList<Double>();
		int j = 0;
		String price = "";
		boolean flag = false;
		try {
			for (int i = 1; i <= 3; i++) {
				wait(2);
				String keyword = readData("src\\test\\resources\\TestData\\TestData.xlsx", "Set7Q3", i, 0);
				System.out.println(keyword);
				Actions action = new Actions(d);
				wait(2);
				action.moveToElement(d.findElement(By.id("search_box")))
						.click().sendKeys(keyword).build().perform();
				wait(5);
				action.moveToElement(d.findElement(By.xpath("search_box")))
						.click().build().perform();
				wait(10);
				String sortdrpdown_xpath = "//span[contains(text(),'Sort by')]";
				if (d.findElement(By.xpath(sortdrpdown_xpath)).isDisplayed()) {
					wait(3);
					action.moveToElement(d.findElement(By.xpath(sortdrpdown_xpath)))
							.click().build().perform();
					wait(5);
					String pricesortoption_xpath="//li[@data-val='Price']/a";
					action.moveToElement(d.findElement(By.xpath(pricesortoption_xpath)))
							.click().build().perform();
					action.moveToElement(d.findElement(By.xpath(pricesortoption_xpath)))
							.click().build().perform();
                    String productprice_xpath= "//span[@class='r1 B14_42']/a";
					for (j = 1; j <= 8; j++) {
						if (j == 1 || j == 2) {
							if (j == 1)
								price = d
										.findElement(By.xpath(
												productprice_xpath + "[" + j + "]"))
										.getText().trim();
							else {
								price = d
										.findElement(By.xpath(
												productprice_xpath + "[" + (j + 2) + "]"))
										.getText().trim();
							}
						} else
							price = d.findElement(By.xpath(productprice_xpath + "["
									+ ((j + (2 * (j - 1)))) + "]")).getText().trim();
						listprice.add(Double.parseDouble(price));
						sortedprice.add(Double.parseDouble(price));
						Collections.sort(listprice);
						Collections.sort(listprice, Collections.reverseOrder());
					}
					for (int m = 0; m <= sortedprice.size() - 1; m++) {
						if ((listprice.get(m)).equals(sortedprice.get(m)))
							flag = true;
					}
				}
				if (flag == true)
					System.out.println(
							"The first 8 products are displayed in descending order of the price for " + keyword);
				else
					System.out.println(
							"The first 8 products are not displayed in descending order of the price for " + keyword);
				for (int f = 0; f < keyword.length() - 1; f++)
					action.moveToElement(d.findElement(By.id("search_box")))
							.click().sendKeys(Keys.BACK_SPACE).build().perform();

			}

		} catch (Exception e) {
			e.printStackTrace();
			terminate();
		}
	
	}

	@After
	public void tearDown() {
		/*
		 * if(d != null) { terminate(); }
		 */
	}

}
