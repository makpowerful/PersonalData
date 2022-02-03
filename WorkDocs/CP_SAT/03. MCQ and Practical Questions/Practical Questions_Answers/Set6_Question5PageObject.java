package cpsatExamJunit;

import org.openqa.selenium.By;

import com.testing.base.TestBase;

public class Set6_Question5PageObject extends TestBase{

	public By txxtAcademics(){
		return By.xpath("(//a[text()='ACADEMICS'])[1]");
	}	
	public By txtFaculty(){
		return By.xpath("(//a[text()='FACULTY'])[1]");
	}	
	public By txtScience(){
		return By.xpath("(//a[text()='SCIENCE & TECHNOLOGY'])[1]");
	}
	public By txtdeptofIT(){
		return By.xpath("//a[text()='DEPARTMENT OF INFORMATION TECHNOLOGY']");
	}
	public By clickLast(){
		return By.xpath("//a[@title='Go to last page']");
	}
	public By txtVision(){
		return By.xpath("(//span[@style='font-family:georgia,serif'])[1]");
		
	}
	public By txtDesc(){
		return By.xpath("(//span[@style='font-family:georgia,serif'])[2]");
	}	
	public By clickContact(){
		return By.xpath("//ul[@id='main-menu-links']//child::li[10]/a");
	}
	public By getContactUs(){
		return By.xpath("//div[@class='field-item even']//child::p[4]/strong");
	}
	
}
