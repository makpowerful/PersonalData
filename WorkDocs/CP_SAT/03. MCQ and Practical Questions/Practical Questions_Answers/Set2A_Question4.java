package cpsatExamTestNG;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set2A_Question4 extends TestBase {
	
	@BeforeClass
	public void setUp()
	{
		//open url https://www.woodlandworldwide.com/
		init("Chrome","https://www.woodlandworldwide.com/");
	}
	
	
	@Test
	public void testMethod() throws Exception {
		
		String sheetName = "Data";
		String fileName = "src\\test\\resources\\TestData\\Woodlands.xlsx";
		
		for(int i=0; i<3; i++)
		{String searchKey = readData(fileName, sheetName, i, 0);
	
		System.out.println(" Search Keyword is: "+searchKey);
		checkPageReady();
		
		//searching with the keyword present in excel file.
		Actions act = new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//div[contains(@class,'searchIcon')]"))).click().moveToElement(d.findElement(By.xpath("//input[@id='searchkey']"))).sendKeys(searchKey).sendKeys(Keys.ENTER);
		act.build().perform();
		
		checkPageReady();
		
		//Filter the search results from price low to high. 
		d.findElement(By.xpath("//ul[@class='rightpanel-filter']//li[4]")).click();
		
		//Verify the first 8 products are displayed in ascending order of price as per filter.
		List<WebElement> price = d.findElements(By.xpath("//li[@class='offerPrices prize']"));
		
		int arr[]= new int[8];
		int i1;
		for( i1 =0; i1<8; i1++)
		{
			
			if(price.get(i1).getText().indexOf(" ")==1)
			{
				arr[i1]= Integer.parseInt(price.get(i1).getText().substring(price.get(i1).getText().indexOf(" ")+1));
			}
			else
			{
				arr[i1]= Integer.parseInt(price.get(i1).getText().substring(1,price.get(i1).getText().indexOf(" ")));
			}
		}
		
		int value = arr[0];
		int flag = 0;
		
		for(i1 =1; i1<8; )
		{
			if(arr[i1]>=value)
			{
				value = arr[i1];
				i1++;
			}
			
			else
			{
				System.out.println("Prices for "+searchKey+" not in ascending order");
				flag =1;
				break;
			}
		}
		
		if(flag!=1)
		{
			System.out.println("Prices for "+searchKey+" are in ascending order");
		}
		
		}
		
	}
	
	

	@AfterClass
	public void tearDown()
	{
		terminate();
	}
	
}
