package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set3_Question3 extends TestBase{
	
	@BeforeMethod
	public void method1()
	{
		//open url https://jqueryui.com/checkboxradio/ 
		init("Chrome","https://jqueryui.com/checkboxradio/");
	}
	
	@Test
	public void Test1() throws InterruptedException
	{
		checkPageReady();
		d.switchTo().frame(d.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		//to check paris radio btn is selected or not
		WebElement parisRadioBtn=d.findElement(By.xpath("//label[@for='radio-2']"));
		if(parisRadioBtn.isSelected()) {
			System.out.println("Paris radio btn is already selected");	
		}else {
			parisRadioBtn.click();
			System.out.println("Paris radio btn is now selected");
		}
		takeTheScreenShot("cpsatJunitSet3_Question3");
		
		
		//to Select all the checkboxes present under Hotel Ratings label
		List<WebElement> checkboxes= d.findElements(By.xpath("//legend[text()='Hotel Ratings: ']/../label"));
		System.out.println("Number of checkboxes under Hotel Ratings:: "+checkboxes.size());
		scrollIntoView(d.findElement(By.xpath("(//legend[text()='Hotel Ratings: ']/../label)[1]")));
		checkPageReady();
		for(int i=0;i<checkboxes.size();i++) {
			if(checkboxes.get(i).isSelected()) {
				System.out.println(checkboxes.get(i).getText()+" is already selected");	
			}else {
				checkboxes.get(i).click();
				System.out.println(checkboxes.get(i).getText()+"  is now selected");
			}	
		}takeTheScreenShot("cpsatJunitSet3_Question3");
		
		
		//to Select all the checkboxes present under Bed Type label
		List<WebElement> checkboxesNested= d.findElements(By.xpath("//legend[text()='Bed Type: ']/../label"));
		System.out.println("Number of checkboxes under Bed Type label: "+checkboxesNested.size());
		scrollIntoView(d.findElement(By.xpath("(//legend[text()='Bed Type: ']/../label)[1]")));
		checkPageReady();
		for(int i=0;i<checkboxesNested.size();i++) {
			if(checkboxesNested.get(i).isSelected()) {
				System.out.println(checkboxesNested.get(i).getText()+" is already selected");	
			}else {
				checkboxesNested.get(i).click();
				System.out.println(checkboxesNested.get(i).getText()+"  is now selected");
			}	
		}takeTheScreenShot("cpsatJunitSet3_Question3");
		
		
		System.out.println("-------------Test Case "+getClass()+" :: Passed---------------");
	}
	
	@AfterMethod
	public void method2()
	{
		terminate();
	}

}

