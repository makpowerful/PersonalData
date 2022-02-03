package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Mock1question2Sample extends TestBase{

public static int rowCounter=0;
	
	@BeforeClass
	public void setUp() {
		init("Chrome", "https://mockexam1cpsat.agiletestingalliance.org/");
	}
	
	@Test(priority = 0)
	public void testMethod() throws Exception {
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		d.findElement(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']")).click();
		scrollDown();
		d.findElement(By.xpath("//a[text()='List of Participants']")).click();
	} 
	
	@DataProvider(name="dataProviderDetails")
	public Object[][] testDP() throws Exception{
		Object[][] data=readData("src\\test\\resources\\TestData\\TestData.xlsx","Mock1Q2");
		return  data;            
	}
	
	@Test(dataProvider="dataProviderDetails", priority=1)
	public void testM(String testNum, String name, String desig, String company, String expRResult) throws Exception {
	
		   List<WebElement> eleSize=d.findElements(By.xpath("//table[@id='footable_350']//tbody/tr"));
		   List<WebElement> cols=eleSize.get(rowCounter).findElements(By.tagName("td"));
			
			String Actualname=cols.get(1).getText();
			String ActualDesig=cols.get(2).getText();
			String ActualCompany=cols.get(3).getText();
		    String res="";
		    
		System.out.println(Actualname+"-"+ActualDesig+"-"+ActualCompany);
		if(Actualname.equalsIgnoreCase(name) && ActualDesig.equalsIgnoreCase(desig) && ActualCompany.equalsIgnoreCase(company) ) {
			res="Matched";
		}
		else {
			res="Not Matched";
		}
		
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", rowCounter, 0, testNum);
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", rowCounter, 1, name);
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", rowCounter, 2, desig);
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", rowCounter, 3, company);
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", rowCounter, 4, expRResult); 
		setData("src\\test\\resources\\TestData\\Result.xlsx", "Mock1Q2", rowCounter, 5, res);
		
		
			++rowCounter;
	}
	
	@AfterClass
	public void close() {
		terminate();
	}
	
}
