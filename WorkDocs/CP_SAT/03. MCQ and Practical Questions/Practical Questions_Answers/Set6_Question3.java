package cpsatExamJunit;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.testing.base.TestBase;

public class Set6_Question3 extends TestBase{
	
	@Before
	public void method1()
	{
		init("Chrome","http://maps.google.com");
	}
	
	@Test
	public void test2() throws InterruptedException{
		checkPageReady();
		Set6_Question3PageObject mp=new Set6_Question3PageObject();
		WebElement element = d.findElement(mp.searchForHome());
		element.sendKeys("Janapriya Lakeview Apartment - Phase 1");
		element.sendKeys(Keys.ENTER);
		checkPageReady();
		List<WebElement> list = d.findElements(mp.getHomeAddress());
		for(int i=0;i<list.size();i++) {
			WebElement ele = list.get(i);
		}
		d.findElement(mp.txtaddress()).click();
		takeTheScreenShot("test2");
		d.findElement(mp.clickDirection()).click();
		WebElement element1 = d.findElement(mp.getDirection());
		element1.sendKeys("Deloitte C2");
		element1.sendKeys(Keys.ENTER);
		String elements = d.findElement(mp.getTable()).getText();
		wait(1);
		String time = d.findElement(mp.getTime()).getText();
		System.out.println("Time of arrival for the first search result is: "+time);
		wait(1);
		String distance = d.findElement(mp.getDistance()).getText();
		System.out.println("Distance for the first search result is: "+distance);
	}
	@After
	public void method2()
	{
		terminate();
	}


}