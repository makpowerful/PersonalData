package cpsatExamTestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set10_Question5 extends TestBase{

	@BeforeMethod
	public void method1()
	{
		//open url https://www.ndtv.com/business
		init("Chrome","https://www.ndtv.com/business");
	}
	
	
	public String checkHREF(String menu) {
		return d.findElement(By.xpath("//a[@title='"+menu+"']")).getAttribute("href");
	}
	
	@Test
	public void Test1() throws Exception {
	
		for (int i = 1; i < 4; i++) {
		//reading menu items from excel.
		String menu=readData("src\\test\\resources\\TestData\\TestData_Set10.xlsx", "cpsatTestNGSet10.Set10_Question", i, 0);
		String actualHREF=checkHREF(menu);
		
		//The href values provided in excel sheet have to asserted. 
		Assert.assertEquals(actualHREF, readData("src\\test\\resources\\TestData\\TestData_Set10.xlsx", "cpsatTestNGSet10.Set10_Question", i, 1));
		System.out.println("Actal HREF for "+menu+" is as expected HREF :"+actualHREF);
		}
		takeTheScreenShot("cpsatTestNG.Set10_Question5");
		System.out.println("-------------Test Case "+getClass()+" :: Passed---------------");
	}
	
	@AfterMethod
	public void method2()
	{
		terminate();
	}

}

