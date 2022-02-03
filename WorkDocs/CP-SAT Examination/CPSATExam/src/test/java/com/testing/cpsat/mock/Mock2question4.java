package com.testing.cpsat.mock;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;


public class Mock2question4 extends TestBase{
	//a) Visit https://mockexam2cpsat.agiletestingalliance.org/
	public static final String url = "https://mockexam2cpsat.agiletestingalliance.org/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() throws InterruptedException, Throwable {
		
		Actions action=new Actions(d);
		
			//b) Click on the "ABOUT" Menu
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		wait(1);
		d.findElement(By.xpath("//ul[@id='menu-main-1']/li/a[contains(text(),'About')]")).click();
		wait(1);
		//c) Scroll down to Accordian (Image 4.1) – 1 mark
		//d) In a while loop (Using FindElements) – 5 marks
		//• Click on + signs for all the sections
		//• Extract the content of the sections and print it on the system console
		//• Take screenshot of expanded section
		//• Note the background color of the section bar before clicking the + sign and after clicking the sign. Print the color on system console.
		String Mainwin=d.getWindowHandle();
		scrollIntoView(d.findElement(By.xpath("//div[@class='eael-accordion-list']")));
		List<WebElement>  lst_accord=d.findElements(By.xpath("//div[@class='eael-accordion-list']"));
		List<WebElement>  lst_accord_color=d.findElements(By.xpath("//div[@class='eael-accordion-list']/div[@class='elementor-tab-title eael-accordion-header']"));
		List<WebElement>  lst_accord_name=d.findElements(By.xpath("//div[@class='eael-accordion-list']/div/span"));
		for(int i=0;i<lst_accord.size();i++) {
			
			String beforeClick=lst_accord_color.get(i).getCssValue("background-color");
			String BC_Color= Color.fromString(beforeClick).asRgb();
			System.out.println("The background color before click for "+lst_accord_name.get(i).getText()+" is: "+BC_Color);
			lst_accord.get(i).click();
			wait(1);
			String afterClick=lst_accord_color.get(i).getCssValue("background-color");
			String AC_Color= Color.fromString(afterClick).asRgb();
			System.out.println("The background color after click for "+lst_accord_name.get(i).getText()+" is: "+AC_Color);
			List<WebElement> lst_text=d.findElements(By.xpath("//div[@class='eael-accordion-content clearfix']/p[2]"));
			wait(1);
			System.out.println("The text of "+lst_accord_name.get(i).getText()+" is: "+lst_text.get(i).getText());
			takeTheScreenShot("Mock2Q4");
			Scrollup();
			wait(1);
			lst_accord.get(i).click();
		}
		
			//e) Scroll down to CP-SAT Advisory Board (Image 4.2) – 3 mark
			//• Using findElements find the names of all the speakers and print the same on system console
			//• In a loop open the hrefs and assert if the linkedin page opened is of correct speaker or not. (do not assert the hreft, you have to open the href and then check if the speaker name is present or not)
		scrollIntoView(d.findElement(By.xpath("//div[@class='elementor-image-box-content']/h3/a")));
		wait(1);
		List<WebElement> lst_ABnames=d.findElements(By.xpath("//div[@class='elementor-image-box-content']/h3/a"));
		//List<WebElement> lst_WebPABnames=d.findElements(By.xpath("//div[@class='elementor-image-box-content']/h3/a"));
		for(int i=0;i<lst_ABnames.size();i++) {	
			Scrolltopoint(0,1800);
			wait(1);
			System.out.println("The names of the authors is:  "+lst_ABnames.get(i).getText());
			
		}
		List<WebElement> lst_ABnames2;
		for(int m=0;m<lst_ABnames.size();m++) {	
			Scrolltopoint(0,1800);
			WebDriverWait wait = new WebDriverWait(d,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='elementor-image-box-content']/h3/a")));
			
			action.contextClick(lst_ABnames.get(m)).build().perform();
			OpenNewWindow();
	        switchWindow();
	        wait(1);
			  try { WebElement Webpage=d.findElement(By.
			  xpath("//div[@class='pv-text-details__left-panel mr5']/div/h1[contains(text(),'"
			  +lst_ABnames.get(m).getText()+"')]"));
			  Assert.assertEquals(Webpage,lst_ABnames.get(m).getText());
			  System.out.println("The Linked in page does contain the name."); }
			  catch(Throwable t) {
			  System.out.println("The Linked in page does not contain the name."); }
			 d.close();
			 wait(1);
			d.switchTo().window(Mainwin);	
			wait(1);
			
		}
		
		
		//f) Scroll down to #ATAGTR2021 Twitter Feed (Image 4.3) – 3 marks
			//• For all the carousel tweets, read the message and print it on the system console
		
		scrollIntoView(d.findElement(By.xpath("//span[@class='swiper-pagination-bullet']")));
		wait(1);
		List<WebElement> lst_click = d.findElements(By.xpath("//span[@class='swiper-pagination-bullet']"));
		List<WebElement> lst_content = d.findElements(By.xpath("//div[@class='eael-twitter-feed-item-content']/p"));
		int l=1;
		for(int n=0;n<lst_click.size();n++) {
			
			lst_click.get(n).click();
			wait(1);
			System.out.println("The value for the carousel tweets "+l+" is: "+lst_content.get(n).getText());
			l++;
			
		}
		
		//g) Go to the section where the logos of CPSAT are shown (image 4.4) – 3 marks
		//• Take the mouse over the respective logos
		//• Tool tips are shown – take a screen shot showing the tooltips for each logo
		//• Extract the tool tip and print on the console for each of the logo
	
	scrollIntoView(d.findElement(By.xpath("//div[@class='elementor-image']")));
	wait(1);
	int k=1;
	List<WebElement> lst_clickicon = d.findElements(By.xpath("//div[@class='elementor-image']"));
	List<WebElement> lst_clickicontip = d.findElements(By.xpath("//div[@class='elementor-widget-wrap']/div/script"));
	//List<WebElement> lst_getscript= d.
	for(int j=0;j<lst_clickicon.size();j++) {
		
		action.moveToElement(lst_clickicon.get(j)).build().perform();
		wait(1);
		takeScreenShotTip("TipMock2Q4", "Tip"+k);
		wait(1);
		String[] a=lst_clickicontip.get(j).getAttribute("innerHTML").split("'");
		System.out.println("The title tool tip "+l+" is: "+a[5]);
		k++;
			
			
		}
		
		
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
