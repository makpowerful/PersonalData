package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set1Aquestion4POM extends TestBase{
	
	private String EleList_xpath="//div[@id='topdiv_0']/h2/a";
	
	
	public Set1Aquestion4POM(WebDriver driver) {
		
		this.d=driver;
		
	}
	
	public String ElementList() {
		String b = null;
		List<WebElement> list=d.findElements(By.xpath(EleList_xpath));
		for(int i=0;i<list.size();i++) {
			
			b=list.get(i).getAttribute("href");
			System.out.println(b);
		}
		return b;
	}
		
	public String ElementExcelList() throws Exception {
			
			List<WebElement> list=d.findElements(By.xpath(EleList_xpath));
			for(int i=0;i<list.size();i++) {
				
				System.out.println(list.get(i).getAttribute("href"));
				
				setData("\\src\\test\\resources\\TestData.xlsx", "Question4", i, 0, list.get(i).getAttribute("href"));
			}             
			return null;
			
		
	}

}
