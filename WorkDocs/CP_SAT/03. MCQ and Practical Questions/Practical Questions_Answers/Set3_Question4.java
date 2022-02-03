package cpsatExamJunit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set3_Question4 extends TestBase{
	@Before
	public void method1()
	{
		//open url: https://code.makery.ch/library/dart-drag-and-drop/
		init("Chrome","https://code.makery.ch/library/dart-drag-and-drop/");
	}

	@Test
	public void method2() throws InterruptedException
	{
		checkPageReady();
		
		//Scroll to view “Custom Drag Avatar” heading
		scrollIntoView(d.findElement(By.xpath("//h3[@id='custom-drag-avatar']")));
		d.switchTo().frame(1);
		List<WebElement> images=d.findElements(By.xpath("//a[contains(@href,'example/custom_avatar')]//following-sibling::img"));
		
		//Drag all the docs to bin and take screenshot before each drag
		WebElement trash=d.findElement(By.xpath("//a[contains(@href,'example/custom_avatar')]//following-sibling::div"));
		Actions actions=new Actions(d);
		System.out.println("Number of images: "+images.size());
		for(int i=0;i<images.size();i++) {
			takeTheScreenShot("cpsatJunitSet3_Question4");
			actions.dragAndDrop(images.get(i), trash).build().perform();
			checkPageReady();
		}

		
		System.out.println("-------------Test Case "+getClass()+" :: Passed---------------");
	}
	
	@After
	public void method3()
	{
		terminate();
	}

}

