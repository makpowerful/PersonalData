package cpsatExamTestNG;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.testing.base.TestBase;
public class Set9_Question1 extends TestBase{

	@BeforeMethod
	public void method1()
	{
		//Open the website ‘https://www.ndtv.com/business’ 
		init("Chrome","https://www.ndtv.com/business");
	}

	@Test
	public void test1() throws Exception{
		checkPageReady();
		Set9_NDTVTopLocators ndtvTop=new Set9_NDTVTopLocators();
		Set9_NDTVBottomLocators ndtvBot= new Set9_NDTVBottomLocators();


		//TopLevel Locators
		checkPageReady();
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getNDTVTxt()).getAttribute("href"));
		
		String txtBusiness = d.findElement(ndtvTop.getBusinessTxt()).getAttribute("href");
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getBusinessTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getHindiTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getMoviesTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getCricketTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getHealthTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getFoodTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getTechTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getHOPTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getAutoTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getBanglaTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getTamilTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getTrainsTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getAppsTxt()).getAttribute("href"));
		
		System.out.println("Href of TopLevel menu is: "+ d.findElement(ndtvTop.getArtTxt()).getAttribute("href"));
		
		//BootomLevel Locators
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getNewsFooterTxt()).getAttribute("href"));
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getBusinessFooterTxt()).getAttribute("href"));
		String txtBusinesFooter = d.findElement(ndtvBot.getBusinessFooterTxt()).getAttribute("href");
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getHindiFooterTxt()).getAttribute("href"));
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getMoviesFooterTxt()).getAttribute("href"));
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getCricketFooterTxt()).getAttribute("href"));
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getFoodFooterTxt()).getAttribute("href"));
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getTechFooterTxt()).getAttribute("href"));
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getAutoFooterTxt()).getAttribute("href"));
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getTransFooterTxt()).getAttribute("href"));
		
		System.out.println("Href of Bottom menu is: "+ d.findElement(ndtvBot.getArtDesignFooterTxt()).getAttribute("href"));
		


		if(txtBusinesFooter.equalsIgnoreCase(txtBusiness))
		{
			System.out.println("Both the Business Links are same");
		}
		else
		{
			System.out.println("Top href: "+txtBusiness);
System.out.println("Bottom href: "+txtBusinesFooter);
			
			Assert.fail("Both the links are not same");
			
		}

	}

	@AfterMethod
	public void method2()
	{
		terminate();
	}
}
