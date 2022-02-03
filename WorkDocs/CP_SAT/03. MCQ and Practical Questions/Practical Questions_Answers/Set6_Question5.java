package cpsatExamJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set6_Question5 extends TestBase{
	
	@Before
	public void method1()
	{
		init("Chrome","http://mu.ac.in/portal");
	}
	@Test
	public void test5() throws Exception{
		checkPageReady();
		Set6_Question5PageObject mp=new Set6_Question5PageObject();
		WebElement w1= d.findElement(mp.txxtAcademics());
		WebElement w2= d.findElement(mp.txtFaculty());
		WebElement w3= d.findElement(mp.txtScience());
		Actions ob = new Actions(d);
		ob.click(w1);
		ob.click(w2);
		ob.click(w3);
		ob.build().perform();
		scrollDown();
		wait(1);
		WebElement w4= d.findElement(mp.txtdeptofIT());
		w4.click();
		switchWindow();
		scrollDown();
		wait(1);
		WebElement w5=d.findElement(mp.clickLast());
		w5.click();
		scrollDown();
		wait(1);
		String vision = d.findElement(mp.txtVision()).getText();
		String desc = d.findElement(mp.txtDesc()).getText();
		System.out.println("Text for Vision is: "+vision+" "+desc);
		d.navigate().back();
		d.findElement(mp.clickContact()).click();
		wait(1);
		String contactus = d.findElement(mp.getContactUs()).getText();
		System.out.println(contactus);
		if(contactus.contains("022-26500208.")) {
			System.out.println("Phone number is present");
		}
		if(contactus.contains("uditoffice@gmail.com")) {
			System.out.println("Email address is present");
		}
	}	
	@After
	public void method2()
	{
		terminate();
	}
}
