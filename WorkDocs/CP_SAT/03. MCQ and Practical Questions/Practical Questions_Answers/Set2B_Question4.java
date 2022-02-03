package cpsatExamJunit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set2B_Question4 extends TestBase {

	@Before
	public void setUp()
	{
        //open https://www.premierleague.com/
		init("Chrome", "https://www.premierleague.com/");
		
	}
	
	@Test
	public void testMethod1() throws InterruptedException, AWTException {

		checkPageReady();
		
		//Click on Tables from the header 
		d.findElement(By.xpath("//nav[@class='subNav']/ul/li/a[text()='Tables']")).click();
		checkPageReady();

		if(d.findElements(By.xpath("//div[text()='I accept cookies from this site']")).size() > 0)
		{
			d.findElement(By.xpath("//div[text()='I accept cookies from this site']")).click();
		}
		
		String MainWindow=d.getWindowHandle();	
		
		//From the tables, open ‘Arsenal’ club in a new window via context-click (3 points)
		scrollIntoView(d.findElement(By.xpath("(//th[text()='Club'])[1]")));
		scrollIntoView(d.findElement(By.xpath("(//td[@class='team']/a/span[text()='Sheffield United'])[1]")));
		
		Actions act = new Actions(d);
		
		act.moveToElement(d.findElement(By.xpath("(//td[@class='team']/a/span[text()='Arsenal'])[1]")));
		act.contextClick(d.findElement(By.xpath("(//td[@class='team']/a/span[text()='Arsenal'])[1]"))).
		build().perform();
		
		Robot robot = new Robot();

		robot.delay(1500); 
		robot.keyPress(KeyEvent.VK_DOWN); 
		robot.keyRelease(KeyEvent.VK_DOWN); 
		robot.delay(1500); 
		robot.keyPress(KeyEvent.VK_DOWN); 
		robot.keyRelease(KeyEvent.VK_DOWN); 
		robot.delay(1500); 
		robot.keyPress(KeyEvent.VK_ENTER);	

		switchWindow();
		checkPageReady();
		
		//Find official website URL on the page and print on the console from the newly opened window 
		String websiteUrl = d.findElement(By.xpath("//span[text()='Official Website:']/following-sibling::a")).getText();
		
		System.out.println("Website Url is: "+websiteUrl);

		//Print the page title of the newly opened window 
		System.out.println("New window Title: "+d.getTitle());
		
		d.switchTo().window(MainWindow);

		//Print the page title again  
		System.out.println("Main window Title: "+d.getTitle());
	}



	@After
	public void tearDown()
	{
       terminate();
	}

}