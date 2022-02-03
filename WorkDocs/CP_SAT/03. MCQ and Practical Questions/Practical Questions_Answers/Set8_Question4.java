package cpsatExamJunit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;

public class Set8_Question4 extends TestBase{
	private static SoftAssert verify;

	@Before
	public void method1()
	{
		//Open the website https://www.rediff.com/ 
		init("Chrome","https://www.rediff.com/");
		verify=new SoftAssert();
		
	}

	@Test
	public void method2()
	{
		try
		{
		checkPageReady();
		String fileName="src\\test\\resources\\TestData\\TestData_Set8.xlsx";
		String sheetName="CPSATExamJUnit_Question8";
		
		//Find out href of all the TopStories on the Rediff.com page using findElements 
		List<WebElement> topStories=d.findElements(By.xpath("//div[contains(@id,'topdiv_0')]//h2//a"));
		for (int i=0;i<topStories.size();i++)
		{
			System.out.println("Href for the top story is :"+topStories.get(i).getAttribute("href"));
			String data=topStories.get(i).getAttribute("href");
			
			//Store all the href’s in either a Text file, or an Excel file
			setData(fileName, sheetName, i, 0, data);
		}
		}
		catch (Exception e) {
			log("Error message :" + e.getMessage());
			log("Testcase is failed.");
			d.close();
			log("Application closed");
			e.printStackTrace();

		}
		}
	
	@After
	public void method3()
	{
		terminate();
	}
}
