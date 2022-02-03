package cpsatExamJunit;

import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.testing.base.TestBase;

public class Set2B_Question2 extends TestBase{
	@Before
	public void launchBrowser()
	{
		//Open https://www.cii.in/OnlineRegistration.aspx
		init("Chrome","https://www.cii.in/OnlineRegistration.aspx");
	}
	@Test
	public void method2() throws InterruptedException
	{
		//Select “Number of Attendees” as 3  
		WebElement ele=d.findElement(By.id("drpAttendee"));
		Select sct=new Select(ele);
		sct.selectByVisibleText("3");

		//Assert the row count is 3 
		List<WebElement> lst=d.findElements(By.xpath("//table[@id='Gridview1']//tr//select"));
		Assert.assertEquals(3, lst.size());	

		//Select 1st-row title as ‘Admiral’ 
		Select fstrow=new Select(lst.get(0));
		fstrow.selectByVisibleText("Admiral");
		System.out.println(d.findElement(By.xpath("//*[contains(@id,'drpTitle')]//option[text()='Admiral']")).getAttribute("innerText"));
		Thread.sleep(1000);
		
		//Select 2nd-row title as ‘CA’ 
		Select sndrow=new Select(lst.get(1));
		sndrow.selectByValue("CA");
		System.out.println(d.findElement(By.xpath("//*[contains(@id,'drpTitle')]//option[text()='CA']")).getAttribute("innerText"));
		Thread.sleep(1000);
		
		//Select 3rd-row title as ‘CS’
		Select thirdrow=new Select(lst.get(2));
		thirdrow.selectByIndex(18);
		System.out.println(d.findElement(By.xpath("//*[contains(@id,'drpTitle')]//option[text()='CS']")).getAttribute("innerText"));
		Thread.sleep(1000);
		
		//Display all the options present in the title drop down.
				List<WebElement> l1 = d.findElements(By.xpath("(//table[@id='Gridview1']/tbody/tr)[2]/td/select/option"));
				int j;
				
				System.out.println("Options are: ");
				
				for (j=0; j< l1.size(); j++)
				{
					System.out.println(l1.get(j).getText());
				}
	}
	@After
	public void closeBrowser()
	{
		terminate();
	}
}
