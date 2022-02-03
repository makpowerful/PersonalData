package com.testing.cpsat.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

import com.testing.base.TestBase;

public class Set2Aquestion6 extends TestBase {

	public static final String url = "https://www.cii.in/OnlineRegistration.aspx";

	@Before
	public void setUp() {
		init("Chrome", url);
	}

	@Test
	public void test() {

		Select s = new Select(d.findElement(By.xpath("//select[@name='drpAttendee']")));
		s.selectByValue("7");
		List<WebElement> lst = d.findElements(By.xpath("//table[@id='Gridview1']//tr//select"));
		if (lst.size() == 7) {
			System.out.println("The number of displayed rows are: " + lst.size());
		}
		Assert.assertEquals(lst.size(), 7);
		wait(3);

		WebElement optn1;
		optn1 = d.findElement(By.xpath("//select[@id='Gridview1_ctl02_drpTitle']"));
		Select s1 = new Select(optn1);
		s1.selectByVisibleText("Advocate");
		wait(1);

		WebElement optn2;
		optn2 = d.findElement(By.xpath("//select[@id='Gridview1_ctl03_drpTitle']"));
		Select s2 = new Select(optn2);
		s2.selectByIndex(4);
		wait(1);

		WebElement optn3;
		optn3 = d.findElement(By.xpath("//select[@id='Gridview1_ctl04_drpTitle']"));
		Select s3 = new Select(optn3);
		s3.selectByValue("Amb");
		wait(1);

		List<WebElement> lstall = d.findElements(By.xpath("//select[@id='Gridview1_ctl02_drpTitle']/option"));
		for (int i = 0; i < lstall.size(); i++) {
			System.out.println(lstall.get(i).getText());
		}

	}

	@After
	public void tearDown() {
		
		  if(d != null) { terminate(); }
		 
	}

}
