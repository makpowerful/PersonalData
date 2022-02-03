package cpsatExamJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set5_Question3 extends TestBase {
	@Before
	public void initiateDriver() {
		init("Chrome", "https://www.qaagility.com");
	}

	@Test
	public void Testcase1() throws InterruptedException {
		try {
			String title = d.getTitle();
			if (title.contains("QAAgility"))
				System.out.println("The Title of the page matches as expected");
			else
				System.out.println("The Title of the page does not matches as expected");
			Dimension size = d.findElement(By.xpath(Set5_PageElementsJunit.mainheader_xpath)).getSize();
			System.out.println("Width of the button with method: " + size.getWidth());
			System.out.println("Height of the button with method: " + size.getHeight());
			wait(2);
			String footercontent = d.findElement(By.xpath(Set5_PageElementsJunit.footercontent_xpath))
					.getAttribute("textContent");
			if (footercontent.equals("QAAgility Technologies Pvt. Ltd. © 2018. All Rights Reserved."))
				System.out.println("Footer text is displayed as expected");
			else
				System.out.println("Footer text is not displayed as expected");
			boolean flag = d.findElement(By.xpath(Set5_PageElementsJunit.twittericon_xpath)).isDisplayed();
			if (flag == true) {
				Point twitterposition = d.findElement(By.xpath(Set5_PageElementsJunit.twittericon_xpath)).getLocation();
				Point contactusposition = d.findElement(By.xpath(Set5_PageElementsJunit.contactusicon_xpath)).getLocation();
				if ((twitterposition.getX()) < contactusposition.getX())
					System.out.println("Twitter link is displayed above contact us");
				else
					System.out.println("Twitter link is not displayed above contact us");
			} else
				System.out.println("Page is not loaded properly");
			Actions action = new Actions(d);
			action.moveToElement(d.findElement(By.xpath(Set5_PageElementsJunit.drpdwnmenu_xpath))).click().build().perform();
			wait(2);
			d.findElement(By.xpath(Set5_PageElementsJunit.firstdrpdwnoptn_xpath)).click();
			wait(5);
			checkPageReady();
			if (d.findElement(By.xpath(Set5_PageElementsJunit.leadingSAFeheader_xpath)).isDisplayed())
				System.out.println("User is able to navigate to page using dropdown");
			else
				System.out.println("User is not able to navigate to page using dropdown");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@After
	public void closeBrowser() {
		d.close();
	}
	}