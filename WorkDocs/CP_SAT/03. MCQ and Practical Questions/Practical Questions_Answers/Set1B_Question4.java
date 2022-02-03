package cpsatExamJunit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set1B_Question4 extends TestBase{

	@Before
	public void method1()
	{
		//Opening the website https://www.rediff.com/ 
		init("Chrome","https://www.rediff.com/");
	}

	@Test
	public void method2() throws Exception
	{
		checkPageReady();

		//Finding out href of all the TopStories on the Rediff.com page using findElements 
		List<WebElement> allStories= d.findElements(By.xpath("(//div[contains(@id,'topdiv')])[1]/h2/a"));

		for(int i=0;i<allStories.size();i++){
			System.out.println(allStories.get(i).getAttribute("href"));
			
			//Store all the href’s in Excel File
			setData("src\\test\\resources\\TestData\\TestData2.xlsx", "Question4", i, 0, allStories.get(i).getAttribute("href"));
		}
	}

	@After
	public void method3()
	{
		terminate();
	}
}
