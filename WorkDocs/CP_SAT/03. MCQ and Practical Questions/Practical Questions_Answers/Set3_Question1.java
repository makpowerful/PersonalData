package cpsatExamJunit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set3_Question1 extends TestBase{

	@Before
	public void method1()
	{
		//open url http://www.allmovie.com/
		init("Chrome","https://www.allmovie.com/");
	}

	@Test
	public void method2() throws InterruptedException
	{
		checkPageReady();
		//for searching the Movie The Godfather
		WebElement searchTxtBox= d.findElement(By.xpath("//input[@class='site-search-input']"));
		waitForElementToClickable(searchTxtBox);
		searchTxtBox.sendKeys("The Godfather");
		searchTxtBox.sendKeys(Keys.ENTER);
		checkPageReady();
		
		//for fetching the search result count
		waitForElementToVisible(d.findElement(By.xpath("//div[@class='results']/h1")));
		String searchCount=d.findElement(By.xpath("//div[@class='results']/h1")).getText().replaceAll("[^0-9]", "");
		System.out.println("Total Search count for The Godfather is : "+ searchCount);
		
		//for selecting the movie with 1972 year
		checkPageReady();
		for(int i=1;i<Integer.valueOf(searchCount);i++) {
			if(d.findElement(By.xpath("(//div[@class='title'])["+i+"]")).getText().contains("1972")){
				takeTheScreenShot("cpsatJunitSet3_Question1");
				d.findElement(By.xpath("(//div[@class='title'])["+i+"]/a")).click();
				break;
			}
		}
		//to find genres and MPAA rating
		checkPageReady();
		takeTheScreenShot("cpsatJunitSet3_Question1");
		String actGenres=d.findElement(By.xpath("//span[@class='header-movie-genres']/a")).getText().trim();
		System.out.println("Genres of the movie is: "+actGenres);
		Assert.assertEquals("Crime", actGenres);
		
		String mPAARating=d.findElement(By.xpath("//span[contains(text(),'MPAA Rating')]/span")).getText().trim();
		System.out.println("MPAA Rating of the movie is: "+mPAARating);
		Assert.assertEquals("R", mPAARating);
		
		//to find the director name
		d.findElement(By.xpath("//li[@class='tab cast-crew']")).click();
		checkPageReady();
		scrollIntoView(d.findElement(By.xpath("//h2[text()='Director']/../div/div/dl/dt/a")));
		checkPageReady();
		takeTheScreenShot("cpsatJunitSet3_Question1");
		String directorName=d.findElement(By.xpath("//h2[text()='Director']/../div/div/dl/dt/a")).getText().trim();
		System.out.println("Director Name of the movie is: "+directorName);
		Assert.assertEquals("Francis Ford Coppola", directorName);
		
		//to find the AlPacino's Character Name
		scrollIntoView(d.findElement(By.xpath("//a[text()='Al Pacino']/../../div[3]")));
		checkPageReady();
		takeTheScreenShot("cpsatJunitSet3_Question1");
		String AlPacinoCharName=d.findElement(By.xpath("//a[text()='Al Pacino']/../../div[3]")).getText().trim();
		System.out.println("AlPacino's Character Name is: "+AlPacinoCharName);
		Assert.assertEquals("Michael Corleone", AlPacinoCharName);
		
		
		System.out.println("-------------Test Case "+getClass()+" :: Passed---------------");
	}
	
	@After
	public void method3()
	{
		terminate();
	}
	
}

