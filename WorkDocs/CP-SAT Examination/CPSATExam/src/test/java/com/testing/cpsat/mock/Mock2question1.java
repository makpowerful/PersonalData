package com.testing.cpsat.mock;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Mock2question1 extends TestBase {

	public static final String url = "https://mockexam2cpsat.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome", url);
	}

	@Test
	public void test() throws Throwable {
		String Mainwin;
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		Mainwin = d.getWindowHandle();
		// For all the social media icons, Using findElements, find the respective URLs
		// of all the social media icons and print them on system console (Image 1.1) (2
		// marks)
		// Right click on all the social media icon one by one and open them in a new
		// window. Get the title of the new window and print the same on the system
		// console (figure above) (3 marks)

		scrollIntoView(d.findElement(By.xpath("//span[@class='elementor-grid-item']/a")));
		wait(1);
		List<WebElement> lst_social = d.findElements(By.xpath("//span[@class='elementor-grid-item']/a"));
		for (WebElement e : lst_social) {

			System.out.println("The URL is: " + e.getAttribute("href"));
			Actions action = new Actions(d);
			action.contextClick(e).build().perform();
			wait(1);
			OpenNewWindow();
			wait(1);
			switchWindow();
			System.out.println("The title is: " + d.getTitle());
			d.close();
			d.switchTo().window(Mainwin);

		}

		// Scroll up where the number of days etc. are shown (see image 1.2 below),
		// Extract the number of days, hours, minutes, and seconds, convert to integer,
		// and print on console. (3 marks)
		scrollIntoView(d.findElement(By.xpath("//div[@class='elementor-countdown-item']/span[1]")));
		List<WebElement> lst_time = d.findElements(By.xpath("//div[@class='elementor-countdown-item']/span[1]"));
		List<WebElement> lst_timelabel = d.findElements(By.xpath("//div[@class='elementor-countdown-item']/span[2]"));
		for(int i=0;i<lst_time.size();i++) {
			
			String a=lst_time.get(i).getText();
			int time=Integer.parseInt(a);
			System.out.println("The value of "+lst_timelabel.get(i).getText()+" is: "+time);
			
		}
		System.out.println(Integer.parseInt(lst_time.get(2).getText()));
		Assert.assertTrue(Integer.parseInt(lst_time.get(1).getText())<24);
		Assert.assertTrue(Integer.parseInt(lst_time.get(3).getText())<60);
	}

	@AfterTest
	public void tearDown() throws Exception {
		if (d != null) {
			terminate();
		}
	}

}
