package com.testing.cpsat.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

import com.testing.base.TestBase;

public class Set4question3 extends TestBase {

	public static final String url = "http://www.nytimes.com/";

	@Before
	public void setUp() {
		init("Chrome", url);
	}

	@Test
	public void test() {

		List<WebElement> listlang = d.findElements(By.xpath("//ul[@data-testid='masthead-edition-menu']/li/a"));
		for (WebElement e : listlang) {
			System.out.println("The total languages listed above are:" + e.getText());
		}

		System.out.println("Politics link  points to the URL: " + d.findElement(By.xpath(
				"//div[@class='css-jj4aw3']/ul[@class='css-1vxc2sl']/li[@class='css-cwdrld']/a[@class='css-1wjnrbv'][contains(@href,'section/politics')]"))
				.getAttribute("href"));

		takeTheScreenShot("Set4Q3");

		Assert.assertEquals(d.getTitle(), "The New York Times - Breaking News, US News, World News and Videos");
		
		//WebElement frame = d.findElement(By.xpath("//iframe"));
        //d.switchTo().frame(frame);
		d.findElement(By.xpath("//button[@data-test-id='search-button']")).click();
		wait(1);
		d.findElement(By.xpath("//input[@name='query']")).sendKeys("arts", Keys.ENTER);
		wait(1);
		List<WebElement> listRes = d.findElements(By.xpath("//ol[@data-testid='search-results']/li"));

		System.out.println("The total number of results are: " + listRes.size());

	}

	@After
	public void tearDown() {
		
		  if (d != null) { terminate(); }
		 
	}

}
