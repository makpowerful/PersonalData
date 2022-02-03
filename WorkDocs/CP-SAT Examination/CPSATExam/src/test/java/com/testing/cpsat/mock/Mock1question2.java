package com.testing.cpsat.mock;

import java.util.List;

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


public class Mock1question2 extends TestBase{

	//Visit https://mockexam1cpsat.agiletestingalliance.org/
	public static final String url = "https://mockexam1cpsat.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}
	
	int i=0;
	
	@DataProvider(name="DataProvider")
	public Object[][] testdp() throws Exception{
		
		Object[][] dp=readData("src\\test\\resources\\TestData\\TestData.xlsx","Mock1Q2");
		return dp;
	}
	
	@Test(priority=0)
	public void testInitial() {
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		//• Click on the Hamburger Menu
		d.findElement(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']")).click();
		
			//• Scroll down to List Of participants menu
		scrollIntoView(d.findElement(By.xpath("//a[contains(text(),'List of Par')]")));
		
			//• Click on the List of Participants menu
		d.findElement(By.xpath("//a[contains(text(),'List of Par')]")).click();
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//input[@type='text']")));
		wait(1);
		
	}
	


	@Test(dataProvider="DataProvider",priority=1)
	public void test1(String TNameDP, String NameDP, String DesigDP, String ONameDP) throws Throwable {
		
		d.findElement(By.xpath("//input[@type='text']")).clear();
		wait(2);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys(NameDP, Keys.ENTER);
		wait(3);
		
		String Nametable=d.findElement(By.xpath("//tbody/tr/td[2]")).getText();
		String Desigtable=d.findElement(By.xpath("//tbody/tr/td[3]")).getText();
		String ONametable=d.findElement(By.xpath("//tbody/tr/td[4]")).getText();
		String Res1;
		String Res2;
		
		if(Nametable.equalsIgnoreCase(NameDP)&&Desigtable.equalsIgnoreCase(DesigDP)&&ONametable.equalsIgnoreCase(ONameDP)) {
			
			Res1="Pass";
			Res2="Matched";
		}
		
		else
		{
			Res1="Fail";
			Res2="Not Matched";
			
		}
		
		setData("src\\test\\resources\\TestData\\Result.xlsx","Mock1Q2", i, 0, TNameDP);
		setData("src\\test\\resources\\TestData\\Result.xlsx","Mock1Q2", i, 1, Nametable);
		setData("src\\test\\resources\\TestData\\Result.xlsx","Mock1Q2", i, 2, Desigtable);
		setData("src\\test\\resources\\TestData\\Result.xlsx","Mock1Q2", i, 3, ONametable);
		setData("src\\test\\resources\\TestData\\Result.xlsx","Mock1Q2", i, 4, Res1);
		setData("src\\test\\resources\\TestData\\Result.xlsx","Mock1Q2", i, 5, Res2);
		
		d.findElement(By.xpath("//input[@type='text']")).clear();
		wait(2);
		i++;
	}
	
	
	
	
	
	@AfterTest
	public void tearDown() throws Exception{
		
		  if(d != null) { terminate(); }
		 
	}

}
