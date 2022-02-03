package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Mock1question4 extends TestBase{

	public static final String url = "https://mockexam1cpsat.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}
	
	
	public void Click_Content() {
		
		
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//i[@class='fa-accordion-icon fas fa-plus']")));
		List<WebElement> lst_para_color=d.findElements(By.xpath("//div[@class='eael-accordion-list']/div[@class='elementor-tab-title eael-accordion-header']"));
		List<WebElement> lst_para=d.findElements(By.xpath("//i[@class='fa-accordion-icon fas fa-plus']"));
		List<WebElement> lst_paraname=d.findElements(By.xpath("//i[@class='fa-accordion-icon fas fa-plus']/following::span"));
		List<WebElement> lst_paratext=d.findElements(By.xpath("//i[@class='fa-accordion-icon fas fa-plus']/following::div/p[2]"));
		
		for(int i=0;i<lst_para.size();i++) {
			
			String Color1=lst_para_color.get(i).getCssValue("background-image").replace("linear-gradient(", "").replace(" 70%, rgb(255, 255, 255) 100%)", "").trim();
			//System.out.println(Color1);
			//Color.fromString(Color1).getColor();
			System.out.println("The Color is: "+Color1);
			//String Color2=Color.fromString(Color1).getColor().asRgb();
			//System.out.println("The Color is: "+Color2);
			lst_para.get(i).click();
			wait(1);
			String Color3=lst_para_color.get(i).getCssValue("background-image").replace("linear-gradient(", "").replace(" 70%, rgb(255, 255, 255) 100%)", "").trim();;
			//String Color4=Color.fromString(Color3).asRgb();
			System.out.println("The Color is: "+Color3);
			wait(1);
			Assert.assertNotEquals(Color1,Color3);
			System.out.println("The text for "+lst_paraname.get(i).getText()+" is: "+lst_paratext.get(i).getText());
			takeTheScreenShot("Mock1Q4");
			lst_para.get(i).click();
			wait(1);
		}
		
		
		
	}

	@Test
	public void test() {
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		
			//• Click on the Hamburger Menu
		d.findElement(By.xpath("//li[@class='slideout-toggle menu-item-align-right ']")).click();
		
		//Click on Challenge 1
		
		d.findElement(By.xpath("//a[contains(text(),'Challenge 1')]")).click();
		wait(1);
		
		//• Click on + signs for all the sections
		//• Extract the content of the sections and print it on the system console
		//• Take screenshot
		//• Note the background color of the section bar before clicking the + sign and after clicking the sign. Print the color on system console.
		//• Assert that the two colors are different
		Click_Content();
		
		
		//• Open https://mockexam1cpsat.agiletestingalliance.org/index.php/challenge-2/
		//• Using findElements find the names of all the speakers and print the same on system console
		d.navigate().to("https://mockexam1cpsat.agiletestingalliance.org/index.php/challenge-2/");
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//div[@class='elementor-widget-container']/h6/a")));
		List<WebElement> Lst_Spnames=d.findElements(By.xpath("//div[@class='elementor-widget-container']/h6/a"));
		for(WebElement e: Lst_Spnames) {
			
			System.out.println("The names of all the speakers are: "+e.getText());
		}
		
		//• Open https://mockexam1cpsat.agiletestingalliance.org/index.php/challenge-4/
		//• For all the carasoul tweets, read the message (highlighted) and print it on the system console
		d.navigate().to("https://mockexam1cpsat.agiletestingalliance.org/index.php/challenge-4/");
		wait(1);
		scrollIntoView(d.findElement(By.xpath("//div[@class='eael-twitter-feed-item-content']/p")));
		List<WebElement> Lst_Scpnames=d.findElements(By.xpath("//div[@class='eael-twitter-feed-item-content']/p"));
		List<WebElement> Lst_Scpnames_click=d.findElements(By.xpath("//span[@class='swiper-pagination-bullet']"));
		for(int i=0;i<Lst_Scpnames_click.size();i++) {
			
			Lst_Scpnames_click.get(i).click();
			System.out.println("The text of carasoul tweets are: "+Lst_Scpnames.get(i).getText());
			wait(1);
		}
		
	
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
