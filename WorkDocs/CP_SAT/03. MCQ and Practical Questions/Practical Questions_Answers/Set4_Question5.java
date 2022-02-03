package cpsatExamJunit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.testing.base.TestBase;

public class Set4_Question5 extends TestBase {

	@Before
	public void method1() {
		
		//Open url http://www.onlineconversion.com/length_common.htm
		init("Chrome", "http://www.onlineconversion.com/length_common.htm");
	}

	@Test
	public void method2() throws Exception {
		try {
			int value=5;
			
			checkPageReady();
			//Enter value 5
			d.findElement(By.xpath("//input[@name='what']")).sendKeys(String.valueOf(value).replace(".0", ""));
			
			//Select feet from From list.
			selectFromDropDown(d.findElement(By.xpath("//select[@name='from']")), "text", "feet", "1", "0.3048");
			
			//Select inch from To list.
			selectFromDropDown(d.findElement(By.xpath("//select[@name='to']")), "text", "inch", "2", "0.3048/12");
			
			//Click on Convert button.
			d.findElement(By.xpath("//input[@name='Go' and @type='button']")).click();
			waitForElementToVisible(d.findElement(By.xpath("//input[@name='answer']")));
			
			//Verify the result follows the formula (value*12).
			int expectedValue=value*12;
			String actualValue=d.findElement(By.xpath("//input[@name='answer']")).getAttribute("value").trim();
			if(actualValue.contains(Integer.toString(expectedValue)))
			{
				Assert.assertTrue(true);
				System.out.println("The result is verified");
			}
			else
			{
				Assert.assertTrue(false);
				System.out.println("The result is not verified");
			}
			
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
	public void method3() {
		terminate();
	}
}

