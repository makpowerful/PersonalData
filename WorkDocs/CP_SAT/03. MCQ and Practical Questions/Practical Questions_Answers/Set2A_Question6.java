package cpsatExamJunit;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set2A_Question6 extends TestBase{
	@Before
	public void launchBrowser() {
		//opening the url https://www.cii.in/OnlineRegistration.aspx
		init("Chrome","https://www.cii.in/OnlineRegistration.aspx");
	}
	
	@Test
	public void method2() throws InterruptedException {
		
		//selecting no. of attendees as 7.
		WebElement ele = d.findElement(By.id("drpAttendee"));
		Select sct = new Select(ele);
		sct.selectByVisibleText("7");
		
		//Verifying if table with 7 rows is displayed
		List<WebElement> lst = d.findElements(By.xpath("//table[@id='Gridview1']//tr//select"));
		Assert.assertEquals(7,lst.size() );
		
		//Selecting different options for Title for 3 rows 
		Select fstrow = new Select(lst.get(0));
		fstrow.selectByVisibleText("Air Cmde");
		System.out.println(d.findElement(By.xpath("//*[@id='Gridview1_ctl02_drpTitle']//option[text()='Air Cmde']")).getAttribute("innerText"));
		Thread.sleep(1000);
		
		Select sndrow = new Select(lst.get(1));
		sndrow.selectByValue("Ambassador");
		System.out.println(d.findElement(By.xpath("//*[@id='Gridview1_ctl02_drpTitle']//option[text()='Ambassador']")).getAttribute("innerText"));
		Thread.sleep(1000);
		
		Select thirdrow = new Select(lst.get(2));
		thirdrow.selectByIndex(14);
		System.out.println(d.findElement(By.xpath("//*[@id='Gridview1_ctl02_drpTitle']//option[text()='Cdr']")).getAttribute("innerText"));
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
	public void closeBrowser() {
		close();
	}
}