package cpsatExamTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Set4_Question1Page {
	
WebDriver d;
	
	Set4_Question1Page(WebDriver d){
		this.d=d;
		
		PageFactory.initElements(d, this);
	}
	
	@FindBy(xpath="(//a[text()='CII Services'])[2]")

    WebElement menuItem1;
	

	@FindBy(xpath="//a[text()='Sectoral Portfolio']")

    WebElement menuItem2;
	

	@FindBy(xpath="//a[text()='Food & Agricultural']")

    WebElement menuItem3;
	

	@FindBy(xpath="(//a[text()='Agriculture'])[1]")

    WebElement menuItem4;
	
	@FindBy(xpath="//div[@class='contactbg-right']//img[@class='scale']")

    WebElement icons;
	
	
	public void clickAgri(Actions action) throws Exception
	{
		action.moveToElement(menuItem1).build().perform();
		Thread.sleep(1000);
		action.moveToElement(menuItem2).build().perform();
		Thread.sleep(1000);
		action.moveToElement(menuItem3).build().perform();
		Thread.sleep(1000);
		action.moveToElement(menuItem4).click().build().perform();
	}
	
	
}

