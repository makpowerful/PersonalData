package cpsatExamJunit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;

import com.testing.base.TestBase;

public class Set1A_Question3 extends TestBase{

	@Before
	public void method1()
	{
		init("Chrome","https://www.rediff.com/");
	}

	@Test
	public void method2() throws InterruptedException
	{
		Set1A_Question3PageObject qp=new Set1A_Question3PageObject();
		checkPageReady();
		String mainWin=d.getWindowHandle();
		d.switchTo().frame(d.findElement(qp.getFrame()));
		
		//Printing the BSE Index Value, NSE Index Value 
		System.out.println("BSE Value: "+d.findElement(qp.getBSE()).getText());
		System.out.println("NSE Value: "+d.findElement(qp.getNSE()).getText());
		
		//Entering company “Reliance Industries” in the company field
		d.findElement(qp.getSearchField()).sendKeys("Reliance Industries");
		Thread.sleep(2000);
		d.findElement(qp.getSearchField()).sendKeys(Keys.ENTER);
		switchWindow();
		checkPageReady();
		
		//Asserting that the title of this new window has “Reliance” in it
		String newWinTitle=d.getTitle();
		System.out.println("New Window Title: "+newWinTitle);
		Assert.assertEquals(newWinTitle.contains("RELIANCE"),true);
		
		//Asserting that the title of old window has “Rediff.com:” in it
		d.switchTo().window(mainWin);
		String mainWinTitle=d.getTitle();
		System.out.println("Old Window Title: "+mainWinTitle);
		Assert.assertEquals(mainWinTitle.contains("Rediff.com:"),true);
		
	}
	
	@After
	public void method3()
	{
		terminate();
	}
}
