package cpsatExamJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set2A_Question5 extends TestBase {

	@Before
	public void setUp()
	{
		//open the url https://www.premierleague.com/
		init("Chrome", "https://www.premierleague.com/");

	}

	@Test
	public void testMethod1() throws InterruptedException {

		checkPageReady();

		//Click on Tables from the menu
		d.findElement(By.xpath("//nav[@class='subNav']/ul/li/a[text()='Tables']")).click();
		checkPageReady();

		if(d.findElements(By.xpath("//div[text()='I accept cookies from this site']")).size() > 0)
		{
			d.findElement(By.xpath("//div[text()='I accept cookies from this site']")).click();
		}

		//Click on Everton from the list. 
		scrollIntoView(d.findElement(By.xpath("(//th[text()='Club'])[1]")));
		scrollIntoView(d.findElement(By.xpath("(//td[@class='team']/a/span[text()='Arsenal'])[1]")));

		Actions act = new Actions(d);
		act.moveToElement(d.findElement(By.xpath("(//td[@class='team']/a/span[text()='Everton'])[1]"))).click().build().perform();

		checkPageReady();

		//Print the official website in the new page and the page title.
		String websiteUrl = d.findElement(By.xpath("//span[text()='Official Website:']/following-sibling::a")).getText();

		System.out.println("Website Url is: "+websiteUrl);
		System.out.println("Page Title: "+d.getTitle());


	}

	@After
	public void tearDown()
	{
       terminate();
	}

}