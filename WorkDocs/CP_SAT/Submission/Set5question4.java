package com.testing.cpsat.mock;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set5question4 extends TestBase{
	
	public static final String url= "http://www.allmovie.com/";
	
	@Before
	public void setUp() {
		init("Chrome",url);
	}
	
	@Test
	public void test() {
		
		
		
		d.findElement(By.xpath("//input[@type='search']")).sendKeys("The Godfather", Keys.ENTER);
		wait(2);
		
		String[] a= d.findElement(By.xpath("//div[@class='results']/h1")).getText().split(" ");
		System.out.println(a[0].trim());
		
		List<WebElement> lst= d.findElements(By.xpath("//div[@class='title']"));
		for(int i=0;i<lst.size();i++) {
			
			String al= lst.get(i).getText();
			if(al.contains("1972"))
			{
				System.out.println(al);
				lst.get(i).click();
				System.out.println("Clicked on the link containing 1972 as the year");
			}
			break;
		}
		
		wait(3);
		Assert.assertEquals(d.findElement(By.xpath("//span[@class='header-movie-genres']/a")).getText(),"Crime");
		System.out.println("The Genre is:"+ d.findElement(By.xpath("//span[@class='header-movie-genres']/a")).getText());
		try {
			Assert.assertEquals(d.findElement(By.xpath("//div[@class='mpaa']/div")).getText(), "A");
		}
		catch(Throwable t){
			System.out.println("The MPAA rating is not A");
		}
		
		d.findElement(By.xpath("//a[contains(text(),'Cast & Crew')]")).click();
		wait(1);
		try {
			Scrollpagedown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ab = d.findElement(By.xpath("//*[@id=\"cmn_wrap\"]/div[2]/div[2]/section/div[1]/div[1]/div[2]/dl/dt/a")).getText().trim();
		System.out.println("The name of the director is:" +ab);
		Assert.assertEquals(ab,"Francis Ford Coppola");
		String cd=d.findElement(By.xpath("//a[contains(text(),'Al Pacino')]//parent::div//following::div[1]")).getText().trim();
		System.out.println("The name of the character played by Al pacino is: " +cd);
		Assert.assertEquals(cd,"Michael Corleone");
	}
	
	@After
	public void tearDown() {
		if(d != null) {
			terminate();
		}
	}

}
