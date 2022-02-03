package cpsatExamJunit;

import org.openqa.selenium.By;

import com.testing.base.TestBase;

public class Set6_Question3PageObject extends TestBase{

	public By searchForHome(){
		return By.id("searchboxinput");
	}
	
	public By getHomeAddress(){
		return By.xpath("(//h3[@class='section-result-title']//child::span)");
	}
	
	public By txtaddress(){
		return By.xpath("(//h3[@class='section-result-title']//child::span)[1]");
	}
	public By clickDirection(){
		return By.xpath("//div[@data-value='Directions']");
	}
	public By getDirection(){
		return By.xpath("//div[@id='sb_ifc51']/input");
	}
	public By getTable(){
		return By.xpath("//div[@data-trip-index='0']");
	}
	public By getTime(){
		return By.xpath("(//div[@class='section-directions-trip-duration delay-light']/span)[1]");
	}
	
	public By getDistance(){
		return By.xpath("(//div[@class='section-directions-trip-distance section-directions-trip-secondary-text']/div)[1]");
	}
}
