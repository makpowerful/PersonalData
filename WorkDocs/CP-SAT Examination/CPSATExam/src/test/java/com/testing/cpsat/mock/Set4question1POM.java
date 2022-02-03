package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.testing.base.TestBase;

public class Set4question1POM extends TestBase{
	
	JavascriptExecutor js;
	
	@FindBy(xpath="//div[@class='nav']/ul/li/a[contains(text(),'CII Services')]")
	private WebElement CII_xpath;
	
	@FindBy(xpath="//div[@class='servicesmenu']/ul/li/a[contains(text(),'Sectoral Portfolio')]")
	private WebElement SctrlP_xpath;
	
	@FindBy(xpath="//div[@class='servicesmenu01']/ul/li/a[contains(text(),'Food & Agricultural')]")
	private WebElement FandA_xpath;
	
	@FindBy(xpath="//div[@class='servicesmenu02']/ul/li/a[contains(text(),'Agri')]")
	private WebElement Agricltr_xpath;
	
	@FindBys(@FindBy(xpath="//div[@class='subheadtxt']/div[@class='icon']/a/img"))
	private List<WebElement> Sociallist;
	
	Set4question1POM(WebDriver driver) {
		
		this.js=(JavascriptExecutor)this.d;
		PageFactory.initElements(driver, this);
	}
	
	public void GotillAgriculture(Actions action) {
		try {
		
		action.moveToElement(CII_xpath).build().perform();
		wait(1);
		action.moveToElement(SctrlP_xpath).build().perform();
		wait(1);
		action.moveToElement(FandA_xpath).build().perform();
		wait(1);
		action.moveToElement(Agricltr_xpath).click().build().perform();
		}
		catch(Throwable t){
			t.printStackTrace();
		}
	}
	
	public void SocialTitle() {
		
		for(int i=0;i<Sociallist.size();i++)
		{
			System.out.println("Title: "+Sociallist.get(i).getAttribute("title").trim());
		}
	}
	
	
	

}
