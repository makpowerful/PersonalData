package cpsatExamTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set10_Question6 extends TestBase{

	@BeforeMethod
	public void method1()
	{
		//open url https://www.ndtv.com/business
		init("Chrome","https://www.ndtv.com/business");
	}
	

	@Test
	public void Test1() throws Exception {
	
		checkPageReady();
		//Print the Sensex and Nifty Values
		d.switchTo().frame(d.findElement(By.xpath("//iframe[contains(@src,'market-indicator')]")));
		
		System.out.println("NIFTY: "+d.findElement(By.xpath("(//a[text()='NIFTY']/parent::td/following-sibling::td)[1]")).getText());
		System.out.println("SENSEX: "+d.findElement(By.xpath("(//a[text()='SENSEX']/parent::td/following-sibling::td)[1]")).getText());
		
	   //Check the RGB colour of Sensex and Nifty
        String rgbNIFTY = d.findElement(By.xpath("//a[text()='NIFTY']")).getCssValue("color");
        String rgbcolor1 = Color.fromString(rgbNIFTY).asRgb();
        System.out.println("RGB color of Nifty: "+rgbcolor1);
        
        String rgbSENSEX = d.findElement(By.xpath("//a[text()='SENSEX']")).getCssValue("color");
        String rgbcolor2 = Color.fromString(rgbSENSEX).asRgb();
        System.out.println("RGB color of SENSEX: "+rgbcolor2);
        
	}
	
	@AfterMethod
	public void method2()
	{
		terminate();
	}

}

