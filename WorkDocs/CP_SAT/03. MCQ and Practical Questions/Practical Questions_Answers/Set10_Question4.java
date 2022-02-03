package cpsatExamTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set10_Question4 extends TestBase{

	@BeforeMethod
	public void method1()
	{
		//Open the website: https://www.ndtv.com/business 
		init("Chrome","https://www.ndtv.com/business");
	}
	
	
	@Test
	public void Test1()  {
		
		try {
		//assert if the value initially shown in the dropdown is Site and take screen shot.
		checkPageReady();
		d.switchTo().frame(1);
		WebElement site=d.findElement(By.xpath("//select[@id='type']"));
		waitForElementToClickable(site);
		site.click();
		Select slt=new Select(site);
		takeTheScreenShot("cpsatTestNG.Set10_Question4");
		Assert.assertEquals(slt.getFirstSelectedOption().getText(), "Site");
		System.out.println("Default selected option is : Site");
		
		//Select “STOCK” from dropdown and take screenshot 
		slt.selectByVisibleText("Stock");
		takeTheScreenShot("cpsatTestNG.Set10_Question4");
		
		//to search Infosys stocks
		waitForElementToClickable(d.findElement(By.xpath("//input[@class='search-input']")));
		d.findElement(By.xpath("//input[@class='search-input']")).sendKeys("Infosys");
		d.findElement(By.xpath("//input[@class='search-input']")).sendKeys(Keys.ENTER);
		
		wait(10);
		
		//to check videos
	
		scrollIntoView(d.findElement(By.xpath("(//span[contains(text(),'Video Result')])[1]")));
		String resultMsg=d.findElement(By.xpath("(//span[contains(text(),'Video Result')])[1]")).getText();
		String VideoCount=resultMsg.replaceAll("[^0-9]", "");
		int count=Integer.valueOf(VideoCount);
		System.out.println("Total video results are : "+count);
		takeTheScreenShot("cpsatTestNG.Set10_Question4");
		
		//Assert that the video results number fetched is greater than 1 (one) 
		Assert.assertTrue(count>1);

		//to print 1st video's link
		String link=d.findElement(By.xpath("((//ul[@id='Related'])[2]/ul/li/p[2]/a)[1]")).getAttribute("href");
		System.out.println("First video's link is : "+link);
		
		//Navigate to the video URL 
		d.navigate().to(link);
		wait(10);
		
		
		System.out.println("-------------Test Case "+getClass()+" :: Passed---------------");
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void method2()
	{
		terminate();
	}

}
