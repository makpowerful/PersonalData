package cpsatExamTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Set9_NDTVBottomLocators {
WebDriver d;
	
	
	public By getNewsFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'News')]");
	}
	
	public By getBusinessFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'Business')]");
	}
	
	public By getHindiFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'Hindi')]");
	}

	public By getMoviesFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'Movies')]");
	}
	
	public By getCricketFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'Cricket')]");
	}
	
	public By getFoodFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'Food')]");
	}

	public By getTechFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'Tech')]");
	}
	
	public By getAutoFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'Auto')]");
	}
	
	public By getTransFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'Trains')]");
	}
	public By getArtDesignFooterTxt(){
		return By.xpath("//li[@class='more']/a[contains(text(),'Art & Design')]");
	}


}
