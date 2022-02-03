package cpsatExamJunit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.testing.base.TestBase;

public class Set3_Question5 extends TestBase{

	@Before
	public void method1()
	{   //Go to “https://www.cii.in/”
		init("Chrome","https://www.cii.in/");
	}

	@Test
	public void method2() throws InterruptedException
	{

		checkPageReady();
		Set3_Question5PageObject obj=new Set3_Question5PageObject();

		takeTheScreenShot("cpsatJunitSet3_Question5");
		
		//Print all the Icon names of social media (right top corner)
		int totalIcons=obj.getIconsCount();
		for(int i=0;i<totalIcons;i++) {
			System.out.println(obj.getIconName(i));
		}
		
		scrollIntoView(obj.getContact());
		checkPageReady();
		takeTheScreenShot("cpsatJunitSet3_Question5");
		
		//Click on “Contact Us” of bottom of the page
		obj.contact();
		checkPageReady();
		
		//Assert whether 1800 103 1244 present or not
		scrollIntoView(obj.getParticularText("1800 103 1244"));
		Assert.assertTrue(obj.checkPresence("1800 103 1244"));
		takeTheScreenShot("cpsatJunitSet3_Question5");
		
		
		System.out.println("-------------Test Case "+getClass()+" :: Passed---------------");
	}
	
	@After
	public void method3()
	{
		terminate();
	}
}

