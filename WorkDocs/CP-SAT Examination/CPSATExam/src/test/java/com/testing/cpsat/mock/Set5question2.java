package com.testing.cpsat.mock;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;


public class Set5question2 extends TestBase{

	public static final String url = "https://www.google.com/maps/";

	@BeforeTest
	public void setUp() {
		init("Chrome",url);
	}

	@Test
	public void test() {
		SoftAssert softAssertion=new SoftAssert();
		wait(3);
		Set5question2POM pom= new Set5question2POM(d);
		pom.EnterSearch("Wankhede Stadium");
		pom.ClickSearch();
		wait(3);
		takeTheScreenShot("Set5q2");
		softAssertion.assertTrue(pom.Leftframe().contains("Wankhede"));
		softAssertion.assertEquals(pom.GetTitle(), "Wankhede Stadium - Google Maps");
		System.out.println(pom.RatingandReview());
		softAssertion.assertTrue(pom.Linkpresent().contains("mumbaicricket.com"));
		System.out.println(pom.Address());
	
	}
	
	@AfterTest
	public void tearDown() throws Exception{
		if(d != null) {
			terminate();
		}
	}

}
