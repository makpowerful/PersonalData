package cpsatExamJunit;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set2B_Question3 extends TestBase{
	

	@Before
	public void launchBrowser()
	{
		//open ‘https://www.hometown.in/’ 
		init("Chrome","https://www.hometown.in/");
	}
	@Test
	public void validate() throws InterruptedException
	{
		WebElement logo = d.findElement(By.xpath("//div[@class='_3vVbLPsO3kllSgsNm4wL2']//img"));
		int logo1 = logo.getSize().getWidth();
		int logo2 = logo.getSize().getHeight();
		System.out.println("Width "+logo1+ " and Height "+logo2);
		
		//Select Electronics from ‘More’ menu 
		d.findElement(By.xpath("//a[@title='Electronics']")).click();
		Thread.sleep(1000);	
		
		//From Filter, section select the color as ‘Black’ 
		WebElement search1 = d.findElement(By.xpath("//div[@class='_377qEzTxtotLBVNveHjKc7 dropdownWrapper']/button[contains(text(),'Color')]/span"));
		Actions action = new Actions(d);
		action.moveToElement(search1).click().build().perform();
		Thread.sleep(1000);
		WebElement search2 = d.findElement(By.xpath("//label[@color='textDark' and text()='Black']"));
		action.moveToElement(search2);
		action.click().build().perform();
		Thread.sleep(2000);
		WebElement filter = d.findElement(By.xpath("//div[@class='_1C7t6hCkKmMddDs8HIk_KY']//li[2]"));
		String filter1 = filter.getText();
		System.out.println(filter1);
		Assert.assertEquals(filter1, "Black");
		Thread.sleep(2000);
		
		//clicking on Quick View option for first product image
		WebElement quickView = d.findElement(By.xpath("//div[@class='ProductWrapper-l4dhev-0 dpGyLK'][1]"));
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView();", quickView);
		Thread.sleep(1000);
		WebElement quickView1 = d.findElement(By.xpath("//div[@class='ProductWrapper-l4dhev-0 dpGyLK']//child::button[2]"));
		js.executeScript("arguments[0].click();", quickView1);
		Thread.sleep(1000);
		String heading = d.findElement(By.xpath("//div[@class='_2V-WkcDUfEK2AG6_W_MTsc Div-ln5jk2-0 cpChky']/h1/a")).getText();
		System.out.println(heading);
		
		//Assert that product name contains Black.
		String productName = d.findElement(By.xpath("//h1[@class='Heading-sc-1xt1x3f-0 efiseG']/a")).getText().trim();
		System.out.println("Product name is: "+productName);
		
		if(productName.contains("Black")||productName.contains("black"))
		{
			System.out.println("The product name contains black");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("The product name doesn't contain black");
			Assert.assertTrue(false);
		}
		
		//closing quick view window.
		d.findElement(By.xpath("//button[@class='styles_closeButton__20ID4']")).click();
		Thread.sleep(1000);
		
		//verify if Black is also present in Applied filters 
		List<WebElement> appliedFilters = d.findElements(By.xpath("//label[text()='Applied Filters']/following-sibling::div/ul/li"));
		
		for(WebElement appFilter: appliedFilters )
		{
			if(appFilter.getText().equals("Black"))
			{
				System.out.println("Applied Filters contain Blank.");
				break;
			}
		}
		
	}	
	@After
	public void closeBrowser()
	{
		close();
	}
}

