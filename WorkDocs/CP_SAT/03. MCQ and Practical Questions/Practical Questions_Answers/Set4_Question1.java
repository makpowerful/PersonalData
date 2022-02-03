package cpsatExamTestNG;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set4_Question1 extends TestBase {
	private static Actions act;

	@BeforeMethod
	public void method1()
	{
		//Open url http://www.cii.in
		init("Chrome","http://www.cii.in");

		//define mouse action object
		act=new Actions(d);
	}

	@Test
	public void Test1() throws InterruptedException
	{
		checkPageReady();

		//Go to CII Services -> Sectoral Portfolio -> Food & Agriculture -> Agriculture.
		Set4_Question1Page q1p=new Set4_Question1Page(d);
		try {

			q1p.clickAgri(act);


			//Assert page Title.
			wait(10);
			Assert.assertEquals(d.getTitle(), "Sectors");


			//Check for the social network icons and print their tooltips.
			Set4_Question1_PageFactory page2 = new Set4_Question1_PageFactory(d);
			page2.printSocialList();

			//Take a screenshot at this instance.
			takeTheScreenShot("Question 1");
		}
		catch (Exception e) {

			e.printStackTrace();
		}

	}

	@AfterMethod
	public void method2()
	{
		terminate();
	}
}
