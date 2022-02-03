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

public class Set2Bquestion2 extends TestBase{
	
	public static final String url= "https://www.cii.in/OnlineRegistration.aspx";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		
		WebElement NOA = d.findElement(By.xpath("//select[@id='drpAttendee']"));
		Select s1= new Select(NOA);
		s1.selectByValue("3");
		
		List<WebElement> Rowcount=d.findElements(By.xpath("//table[@id='Gridview1']/tbody/child::tr/td/select"));
		for(int i=0;i<Rowcount.size();i++) {
			
			Assert.assertEquals(3,Rowcount.size());
		}
		
		WebElement Row1= d.findElement(By.xpath("//table[@id='Gridview1']/tbody/child::tr[2]/td/select"));
		Select s2= new Select(Row1);
		s2.selectByIndex(1);
		
		WebElement Row2= d.findElement(By.xpath("//table[@id='Gridview1']/tbody/child::tr[3]/td/select"));
		Select s3= new Select(Row2);
		s3.selectByValue("CA");
		
		WebElement Row3= d.findElement(By.xpath("//table[@id='Gridview1']/tbody/child::tr[4]/td/select"));;
		Select s4= new Select(Row3);
		s4.selectByVisibleText("CS");
		
		List<WebElement> Alloption=d.findElements(By.xpath("//table[@id='Gridview1']/tbody/child::tr[2]/td/select//option"));
        for(int m=0;m<Alloption.size();m++) {
			
			System.out.println(Alloption.get(m).getText());
		}
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
