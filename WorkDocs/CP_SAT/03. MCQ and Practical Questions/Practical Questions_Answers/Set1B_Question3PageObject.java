package cpsatExamJunit;

import org.openqa.selenium.By;

import com.testing.base.TestBase;

public class Set1B_Question3PageObject extends TestBase{

	
	public By getBSE(){
		return By.xpath("//span[@id='bseindex']");
	}
	
	public By getNSE(){
		return By.xpath("//span[@id='nseindex']");
	}
	
	public By getSearchField(){
		return By.xpath("//input[@id='query']");
	}
	
	public By getFrame(){
		return By.xpath("//iframe[@id='moneyiframe']");
	}
	
}

