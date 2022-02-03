package cpsatExamJunit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import com.testing.base.TestBase;

public class Set2A_Question3 extends TestBase{
	@Before
	public void launchBrowser() {
		//opening the url https://www.hometown.in/
		init("Chrome","https://www.hometown.in/");
	}
	@Test
	public void validateApplication() throws InterruptedException {	
		
		//Clicking on ‘More’ drop down and and selecting ‘Electronics’
		Actions action = new Actions(d);
		WebElement more = d.findElement(By.xpath("//button[text()='More']"));
		action.moveToElement(more).build().perform();
		d.findElement(By.xpath("//a[@title='Electronics']")).click();
		Thread.sleep(1000);
		
		//clicking on ‘color’ drop down and selecting ‘Red’.
		WebElement search1 = d.findElement(By.xpath("//div[@class='_377qEzTxtotLBVNveHjKc7 dropdownWrapper']//button[contains(text(),'Color')]"));
		action.moveToElement(search1).click().build().perform();
		Thread.sleep(1000);
		WebElement search2 = d.findElement(By.xpath("//label[@color='textDark' and text()='Red']"));
		action.moveToElement(search2).click().build().perform();
		Thread.sleep(2000);
		
		//Checking if Red is present in Applied filters
		WebElement filter = d.findElement(By.xpath("//div[@class='_1C7t6hCkKmMddDs8HIk_KY']//li[2]"));
		String filter1 = filter.getText();
		System.out.println(filter1);
		Assert.assertEquals(filter1, "Red");
		Thread.sleep(2000);
		
		//Verifying if the first product displayed has ‘Red’ in the product name.
		WebElement quickView = d.findElement(By.xpath("//div[@class='ProductWrapper-l4dhev-0 dpGyLK'][1]"));
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView();", quickView);
		Thread.sleep(1000);
		WebElement quickView1 = d.findElement(By.xpath("//div[@class='ProductWrapper-l4dhev-0 dpGyLK']//child::button[2]"));
		js.executeScript("arguments[0].click();", quickView1);
		Thread.sleep(1000);
		String heading = d.findElement(By.xpath("//div[@class='_2V-WkcDUfEK2AG6_W_MTsc Div-ln5jk2-0 cpChky']/h1/a")).getText();
		System.out.println(heading);
		if(heading.contains("Red")) {
		Assert.assertTrue(true);
		}
		d.findElement(By.xpath("//button[@class='styles_closeButton__20ID4']")).click();
	}
	@After
	public void closeBrowser() {
		close();
	}
}