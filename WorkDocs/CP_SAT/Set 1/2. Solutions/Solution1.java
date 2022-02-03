package cpsat.testng;
import org.testng.annotations.Test;



import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.util.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Solution1 extends TestBase{
	
	@BeforeMethod
	@Parameters({ "browser" })
	  public void beforeMethod(String browser) throws Throwable {
		init(browser, "https://exammay2020.agiletestingalliance.org/");
		 checkPageReady();
	  }
	
	@Test
  public void f() throws InterruptedException {
	 d.findElement(By.xpath("//*[@class='eicon-close']")).click();
	 checkPageReady();
	 List <WebElement> more=d.findElements(By.xpath("//*[contains(text(),'More')]//ancestor::a[1]"));
	 
	 for(WebElement e : more) {
		 System.out.println(e.getText() +" : "+e.getAttribute("href"));
	 }
	 scrollIntoView(d.findElement(By.className("social_icon")));
	 takeScreenShot(d, "Social_icon");
	 List<WebElement> socialIconLinks=d.findElements(By.xpath("//*[@class='social_icon']//a"));
	 String mainwindow=d.getWindowHandle();
	 for(WebElement icon : socialIconLinks) {
		 System.out.println(icon.getAttribute("href"));
		 icon.click();
		 Set <String> childwindow=d.getWindowHandles();
		 Iterator <String> winItr=childwindow.iterator();
		 while(winItr.hasNext()) {
			 String child=winItr.next();
			 if(!child.equals(mainwindow)) {
				 d.switchTo().window(child);
				 checkPageReady();
				 System.out.println(d.getTitle());
				 takeScreenShot(d, "Social_Pages");
				 d.close();
				 
			 }
			 d.switchTo().window(mainwindow);
		 }
	 }
	 List<WebElement> doppatext=d.findElements(By.xpath("//*[contains(text(),'doppa2020')]"));
	 
	 System.out.println("Doppa2020 is displayed : "+ doppatext.size());
  }
  

  @AfterMethod
  public void afterMethod() {
	  d.quit();
  }
  
  
}



