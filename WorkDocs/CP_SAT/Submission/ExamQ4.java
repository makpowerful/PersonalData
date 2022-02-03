package com.testing.cpsat.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class ExamQ4 extends TestBase{
	//Open the website https://www.rediff.com/ (0 mark)
	public static final String url= "https://www.rediff.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() throws Exception {
		int i=0;
		//Find out href of all the TopStories on the Rediff.com page using findElements (3 marks)
		wait(1);
		List<WebElement> lst=d.findElements(By.xpath("//div[@id='topdiv_0']/h2/a"));
		for(WebElement e:lst) {
			
			String a = e.getAttribute("href");
			System.out.println(a);
			setData("src\\test\\resources\\TestData\\TestData.xlsx","ExamQ4", i, 0, a);
			i++;
		}
		
		//Store all the href’s in either a Text file, or an Excel file (You have to submit the file created) (3 marks)
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
