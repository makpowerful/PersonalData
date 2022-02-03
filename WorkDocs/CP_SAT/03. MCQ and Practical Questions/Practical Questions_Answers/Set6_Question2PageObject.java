package cpsatExamJunit;

import org.openqa.selenium.By;

import com.testing.base.TestBase;

public class Set6_Question2PageObject extends TestBase{

	public By getEnglistTxt(){
		return By.xpath("//a[@id='js-link-box-en']//child::strong//parent::a//following-sibling::small/bdi[@dir='ltr']");
	}
	
	public By getMottoTxt(){
		return By.xpath("//th[text()='Motto']/following-sibling::td");
	}
	
	public By getNotablePerson(){
		return By.xpath("//span[@id='Notable_alumni']/../following-sibling::ul/li");
	}
	public By getNotablePersonSection() {
		return By.xpath("//span[@id='Notable_alumni']");
	}
	
}

