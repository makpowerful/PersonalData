package cpsatExamTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Set9_NDTVTopLocators {
WebDriver d;
	
	
	public By getNDTVTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='NDTV']");
	}
	
	public By getBusinessTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Business']");
	}
	
	public By getHindiTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='हिन्दी']");
	}

	public By getMoviesTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Movies']");
	}
	
	public By getCricketTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Cricket']");
	}
	
	public By getHealthTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Health']");
	}

	public By getFoodTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Food']");
	}
	
	public By getTechTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Tech']");
	}
	
	public By getHOPTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='HOP']");
	}
	public By getAutoTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Auto']");
	}

	public By getBanglaTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='বাংলা']");
	}
	
	public By getTamilTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='தமிழ்']");
	}
	
	public By getTrainsTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Trains']");
	}
	
	public By getAppsTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Apps']");
	}
	
	public By getArtTxt(){
		return By.xpath("//div[@class='nglobalnav']/a[text()='Art']");
	}
}
