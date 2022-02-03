package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set9question1POM extends TestBase {

	private String Toplocators = "//div[@class='nglobalnav']/a";
	private String Btmlocators = "//div[@class='footer_nav']/ul/li/a";

	public Set9question1POM(WebDriver driver) {

		this.d = driver;
	}

	public String AllTopLoc() {

		String a = null;
		List<WebElement> lst = d.findElements(By.xpath(Toplocators));
		for (int i = 0; i < lst.size(); i++) {

			a = lst.get(i).getAttribute("href");
			System.out.println(a);
			try {
				setData("src\\test\\resources\\TestData\\TestData.xlsx", "Set9Q1", i, 0, a);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;

	}

	public String AllBottomLoc() {

		String a = null;
		List<WebElement> lst = d.findElements(By.xpath(Btmlocators));
		for (int i = 0; i < lst.size(); i++) {

			a = lst.get(i).getAttribute("href");
			System.out.println(a);
			try {
				setData("src\\test\\resources\\TestData\\TestData.xlsx", "Set9Q1", i, 1, a);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return a;
	}
}
