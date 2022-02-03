package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set3question3POM extends TestBase {

	private List<WebElement> allicons_xpath;
	private WebElement Cnct_xpath;

	public Set3question3POM(WebDriver driver) {

		this.d = driver;

	}

	// b. Print all the Icon names of social media (right top corner)
	public void Allicons() {

		allicons_xpath = d.findElements(By.xpath("//div[@class='new-socila-icons']/a/span"));
		for (int i = 0; i < allicons_xpath.size(); i++) {

			System.out.println("The icons are: " + allicons_xpath.get(i).getText());
		}

	}

	// c. Click on “Contact Us” of bottom of the page
	public void ClickContactus() {
		Cnct_xpath = d.findElement(By.xpath("//aside/ul/li/a[contains(text(),'Contact')]"));
		scrollIntoView(Cnct_xpath);
		Cnct_xpath.click();

	}

	// d. Assert whether 1800 103 1244 present or not
	public String Number() {

		return d.findElement(By.xpath("//div[@class='phone']/span[contains(text(),'1800')]")).getText();
	}

}
