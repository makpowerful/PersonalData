package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;

public class Set4_Question6 extends TestBase {
	private static SoftAssert verify;

	@BeforeMethod
	public void method1() {
		
		//open url https://en.wikipedia.org/wiki/Main_Page
		init("Chrome", "https://en.wikipedia.org/wiki/Main_Page");
		verify=new SoftAssert();
	}

	@Test
	public void method2() throws Exception {
		try {
			
			checkPageReady();
			
			//Search for the film “Memento (film)”.
			d.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).clear();
			d.findElement(By.xpath("//input[@placeholder='Search Wikipedia']")).sendKeys("Memento (film)");
			d.findElement(By.xpath("//input[@id='searchButton']")).click();
			wait(3);
			
			//Verify the runtime is 113 minutes in terms of hh:MM.
			int actualRunningTime=Integer.parseInt((d.findElement(By.xpath("(//div[contains(text(),'Running time')]//following::td)[1]")).getText().trim().split(" "))[0]);
			int actaulHour=actualRunningTime/60;
			int actualMinute=actualRunningTime%60;
			if(actaulHour==1 && actualMinute==53)
			{
				verify.assertTrue(true);
				System.out.println("The run time is 113 minutes as expected");
			}
			else
			{
				verify.assertTrue(false);
				System.out.println("The run time is not 113 minutes.");
				
			}
			
			//Verify the director is Christopher Nolan
			if(d.findElement(By.xpath("(//table[@class='infobox vevent']//tr//th[contains(text(),'Screenplay by')]//following::td)[1]")).getText().trim().equals("Christopher Nolan"))
			{
				verify.assertTrue(true);
				System.out.println("The director name is as expected");
			}
			else
			{
				verify.assertTrue(false);
				System.out.println("The director name is not as expected");
				
			}
			
			//Verify the box office collection is $39.7 million.
			if(d.findElement(By.xpath("(//table[@class='infobox vevent']//tr//th[contains(text(),'Box office')]//following::td)[1]")).getText().trim().contains("$39.7 million"))
			{
				verify.assertTrue(true);
				System.out.println("The box office collection is as expected");
			}
			else
			{
				verify.assertTrue(false);
				System.out.println("The box office collection is not as expected");
				
			}
			
			//Print the cast
			System.out.println("Cast :");
			List<WebElement> cast2=d.findElements(By.xpath("//span[text()='Cast']/parent::h2/following-sibling::div[1]/ul/li"));
			for(int i=0;i<cast2.size();i++)
			{
				System.out.println(cast2.get(i).getText().trim() );
			}
			
			verify.assertAll();
			
			
			}
		catch (Exception e) {
			log("Error message :" + e.getMessage());
			log("Testcase is failed.");
			d.close();
			log("Application closed");
			e.printStackTrace();

		}

	}

	@AfterMethod
	public void method3() {
		terminate();
	}
}

