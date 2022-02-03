package cpsatExamJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.testing.base.TestBase;

public class Set5_Question5 extends TestBase{
	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "http://ata123456789123456789.appspot.com/");
	}
	@Test
	public void testCase1() {
		try {
		d.findElement(By.id(Set5_PageElementsJunit.elucidminusrdibtn_id)).click();
		d.findElement(By.xpath(Set5_PageElementsJunit.firstnumberfield_xpath)).clear();
		d.findElement(By.xpath(Set5_PageElementsJunit.firstnumberfield_xpath)).sendKeys("7");
		d.findElement(By.xpath(Set5_PageElementsJunit.secondnumberfield_Xpath)).clear();
		d.findElement(By.xpath(Set5_PageElementsJunit.secondnumberfield_Xpath)).sendKeys("4");
		d.findElement(By.xpath(Set5_PageElementsJunit.calculatebtn_xpath)).click();
		wait(2);
	    String value = d.findElement(By.xpath(Set5_PageElementsJunit.generatedfield_xpath)).getAttribute("value");
		int generatedvalue = Integer.parseInt(value);
	    int expectedvalue = (7*7)-2*(7*4)+(4*4);
		System.out.println(expectedvalue);
		if(generatedvalue==expectedvalue)
		{
			System.out.println("Value is generated as expected");
		}else {
			System.out.println("Value is not generated as expected");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void AfterTest() {
		terminate();
	}
}

