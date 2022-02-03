package cpsatExamJunit;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set4_Question3 extends TestBase{

	@Before
	public void method1()
	{
		//Open url http://www.nytimes.com/
		init("Chrome","http://www.nytimes.com/");

	}

	@Test
	public void method2() throws InterruptedException
	{
		checkPageReady();

		//Print the available languages in which the site can be viewed.
		List<WebElement> language = d.findElements(By.xpath("//ul[@data-testid='masthead-edition-menu']//a"));		
		for(int i=0;i<language.size();i++)
		{
			System.out.println("Available languages :"+language.get(i).getText());
		}

		//Print the url to which the link Politics is pointing to.
		System.out.println("Politics link is pointing to the url :"+d.findElement(By.xpath("//div[@data-testid='masthead-mini-nav']//a[text()='Politics']")).getAttribute("href"));

		//Take screenshot.
		takeTheScreenShot("Question 3");
		wait(5);

		//Verify page title.
		String pageTitle=d.getTitle().trim();
		if(pageTitle.contains("The New York Times"))
		{
			System.out.println("The page title is matched");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("The page title does not match");
			Assert.assertTrue(false);
		}

		//Go to Search, enter “arts” and from the result page, search how many result items are there.
		d.findElement(By.xpath("//span[text()='SEARCH']//parent::button[@data-test-id='search-button']")).click();
		d.findElement(By.xpath("//input[@data-testid='search-input']")).clear();
		d.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("arts",Keys.ENTER);
		checkPageReady();
		List<WebElement> searchRes=d.findElements(By.xpath("//ol[@data-testid='search-results']//li[@data-testid='search-bodega-result']"));
		System.out.println("The total search results :"+searchRes.size());
	}

	@After
	public void method3()
	{
		terminate();
	}
}
