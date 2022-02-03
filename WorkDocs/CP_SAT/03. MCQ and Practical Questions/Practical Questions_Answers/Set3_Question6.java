package cpsatExamTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set3_Question6 extends TestBase{
	
	@BeforeMethod
	public void method1()
	{   //open url http://www.mptourism.com/
		init("Chrome","http://www.mptourism.com/");
	}
	
	@Test
	public void Test1() throws Exception
	{
		checkPageReady();
		//search using keywords from Excel sheet.
		int places=getRowCount("src\\test\\resources\\TestData\\TestData_Set3.xlsx", "cpsatTestNGSet3_Question6");
		WebElement searchBox; 
		for(int i=0;i<places;i++) {
			checkPageReady();
			d.findElement(By.xpath("//a[@class='searchOpen']")).click();
			wait(2);
			
			searchBox=d.findElement(By.xpath("//div[@class='searchPlace']/input[@title='Enter the terms you wish to search for.']"));
			
			searchBox.sendKeys(readData("src\\test\\resources\\TestData\\TestData_Set3.xlsx", "cpsatTestNGSet3_Question6", i, 0));
			searchBox.sendKeys(Keys.ENTER);
			checkPageReady();
			takeTheScreenShot("cpsatTestNGSet3_Question6");
			d.navigate().back();
			checkPageReady();
		}
		
		System.out.println("-------------Test Case "+getClass()+" :: Passed---------------");
	}
	
	@AfterMethod
	public void method2()
	{
		terminate();
	}

}
