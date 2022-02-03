package cpsatExamJunit;

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;

public class Set8_Question3 extends TestBase{
	private static SoftAssert verify;

	@Before
	public void method1()
	{
		//open ‘https://www.rediff.com/
		init("Chrome","https://www.rediff.com/");
		verify=new SoftAssert();
		
	}

	@Test
	public void method2()
	{
		try
		{
		checkPageReady();
		Set8_Question3PageObject q3p=new Set8_Question3PageObject();
		String pid=d.getWindowHandle();
		d.switchTo().frame(d.findElement(q3p.moneyFrame()));
		
		//for printing the BSE Index Value, NSE Index Value 
		System.out.println("BSE index value is :"+d.findElement(q3p.getBSEIndex()).getText()); //to print BSE index value
		System.out.println("NSE index value is :"+d.findElement(q3p.getNSEIndex()).getText()); //to print NSE index value
		
		//Enter company “Reliance Industries” in the company or MF Input field
		d.findElement(q3p.companyInput()).sendKeys("Reliance Industries");
		d.findElement(q3p.searchBtn()).click();
		switchWindow();
		
		//assert that the title of this new window has “Reliance” in it
		if(d.getTitle().contains("RELIANCE"))
		{
			verify.assertTrue(true);
			System.out.println("Title of the new window has Reliance in it");
		}
		else
		{

			verify.assertTrue(false);
			System.out.println("Title of the new window does not have Reliance in it");
		}
		d.switchTo().window(pid);
		d.switchTo().defaultContent();
		
		//assert that the title of old window has “Rediff.com:” in it
		if(d.getTitle().contains("Rediff.com:"))
		{
			verify.assertTrue(true);
			System.out.println("Title of the previous window has Rediff.com in it");
		}
		else
		{

			verify.assertTrue(false);
			System.out.println("Title of the previous window does not have Rediff.com in it");
		}
		verify.assertAll();
		}
		catch (Exception e) {
			log("Error message :" + e.getMessage());
			log("Testcase is failed.");
			d.close();
			log("Application closed");
			e.printStackTrace();

		}
		}
	
	@After
	public void method3()
	{
		terminate();
	}
}
