package cpsatExamTestNG;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set10_Question3 extends TestBase{

	@BeforeMethod
	public void method1()
	{
		//Open the website: https://www.ndtv.com/business 
		init("Chrome","https://www.ndtv.com/business");
	}

	public void getTopStories() throws InterruptedException{

		//Print Href of all the TOP STORIES on the console
		checkPageReady();
		List<WebElement> stories=d.findElements(By.xpath("//div[@class='bud_otherstories1']/ul/li/p[@class='headline']/a"));
		for(int i=0;i<stories.size();i++) {
			System.out.println("Story Number "+(i+1)+" is --> "+stories.get(i).getAttribute("href"));
		}
	}



	@Test
	public void Test1() throws InterruptedException  {

		try {

			String MainWindow=d.getWindowHandle();	
			getTopStories();

			//Assert that the tool tip of the LATEST menu item is “Latest” 
			Assert.assertEquals(d.findElement(By.xpath("//a[@title='Latest']")).getAttribute("title"), "Latest");
			
			WebElement latest=d.findElement(By.xpath("//a[@title='Latest']"));
			Actions act=new Actions(d);
			waitForElementToClickable(latest);
			scrollIntoView(latest);
			act.moveToElement(latest);
			takeScreenShotTip("cpsatTestNG.Set10_Question3");

			act.contextClick(latest).build().perform();
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
			
	
			if(d.findElements(By.xpath("//a[text()='No Thanks']")).size()>0) {
				d.findElement(By.xpath("//a[text()='No Thanks']")).click();
			}
			
			//To print the title of LatestPage
			System.out.println("Latest page title: "+d.getTitle());
			
			//to check the top 3 stories in Latest tab
			List<WebElement> topLatestStories=d.findElements(By.xpath("//div[@class='nstory_header']/a")); 
			for(int i=0;i<3;i++) {
				System.out.println("Latest Story Number "+(i+1)+" is --> "+topLatestStories.get(i).getAttribute("href"));
				scrollIntoView(topLatestStories.get(i));
				takeTheScreenShot("cpsatTestNG.Set10_Question3");
			}

			
			d.switchTo().window(MainWindow);

			//Print the page title of main window  
			System.out.println("Main window Title: "+d.getTitle());

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
