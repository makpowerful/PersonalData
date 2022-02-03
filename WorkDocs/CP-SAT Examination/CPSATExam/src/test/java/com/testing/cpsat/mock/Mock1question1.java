package com.testing.cpsat.mock;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Mock1question1 extends TestBase{

	//• Visit https://mockexam1cpsat.agiletestingalliance.org/
	public static final String url = "https://mockexam1cpsat.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() throws AWTException, InterruptedException {
		String Mainwin;
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		Mainwin=d.getWindowHandle();
		
			//• Click on the Hamburger Menu
		d.findElement(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']")).click();
		
			//• Using findElements read all the menu items values and print on the system console.
		List<WebElement> lst_Hmenuitems=d.findElements(By.xpath("//ul[@id='menu-slideout-spacious']/li/a"));
		for(WebElement e: lst_Hmenuitems) {
			
			System.out.println("The Hamburger menu items are: "+e.getText());
		}
			
		//• For all the social media icons, find the respective urls of all the social media icons and print them on system console (1 in figure above)
		wait(1);
		List<WebElement> lst_SMicons=d.findElements(By.xpath("//ul[@class='lsi-social-icons icon-set-lsi_widget-1']/li/a"));
		for(WebElement f: lst_SMicons) {
			
			System.out.println("The url of "+f.getAttribute("title")+ " is: "+f.getAttribute("href"));
		}
		//• Right click on all the social media icon one by one and open them in a new window. Get the title of the new window and print the same on the system console (2 in figure above)
		for(int i=0;i<3;i++) {
			
			Actions action=new Actions(d);
			action.contextClick(lst_SMicons.get(i)).build().perform();
			OpenNewWindow();
			wait(2);
			switchWindow();
			System.out.println("The title is: "+d.getTitle());
			d.close();
			d.switchTo().window(Mainwin);
		}
	
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
