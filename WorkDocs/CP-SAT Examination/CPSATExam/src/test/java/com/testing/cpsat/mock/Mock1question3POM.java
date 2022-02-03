package com.testing.cpsat.mock;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Mock1question3POM extends TestBase {

	private String closeicon_xpath="//i[@class='eicon-close']";
	private String hammenu_xpath= "//li[@class='slideout-toggle menu-item-align-right ']";
	private String partime_xpath="//a[contains(text(),'List of Par')]";
	private String input_xpath="//input[@type='text']";
	private String closebtn_xpath="//button[@type='submit']";
	
	public Mock1question3POM(WebDriver d) {
		
		this.d = d;
	}

	// a.Visit https://mockexam1cpsat.agiletestingalliance.org/

	public void ClickHam() {
		
		d.findElement(By.xpath(closeicon_xpath)).click();
		d.findElement(By.xpath(hammenu_xpath)).click();
	}
	// b. Click on the Hamburger Menu
	
	// c. Scroll down to List Of participants menu
	// d. Click on the List of Participants menu
	public void Scroll_Click_Partimenu() {
		scrollIntoView(d.findElement(By.xpath("//a[contains(text(),'List of Par')]")));
		d.findElement(By.xpath(partime_xpath)).click();
	}
	// e. Create a POM Question3POM for list of Participants page
	// A. List <String> searchParticipantName(String Name)
	// The method in the POM class should be able to search for the participant name
	// and return a list of Names found. e.g. on searching for “ch” it should return
	// the respective names in a list. If no names are found it should return a
	// blank list.
	
	public void ListNames() {
		scrollIntoView(d.findElement(By.xpath("//input[@type='text']")));
		wait(1);
		d.findElement(By.xpath(input_xpath)).sendKeys("ch");
		wait(2);
		List<WebElement> lstn=d.findElements(By.xpath("//td[2]"));
		if(lstn.size()>0) {
			for(WebElement e: lstn) {
				System.out.println("The list of names are :"+e.getText());
			}
		}
		else {
			System.out.println("The list is empty");
		}
		
        d.findElement(By.xpath(closebtn_xpath)).click();
		
	}
	
	// B. List <String> searchParticipantDesignation(String Name)
	// The method in the POM class should be able to search for the participant name
	// and return a list of designations found for all the rows. e.g. on searching
	// for “ch” it should return the respective designations in a list for all the
	// rows. If no names are found it should return a blank list.
	// Create a separate Junit Test, such that the above POM class object is
	// created, the method/function are called and the values received from both the
	// functions are printed on system console properly.
	public void ListDesNames() {
		scrollIntoView(d.findElement(By.xpath("//input[@type='text']")));
		wait(1);
		d.findElement(By.xpath(input_xpath)).sendKeys("ch");
		wait(2);
		List<WebElement> lstd=d.findElements(By.xpath("//td[3]"));
		if(lstd.size()>0) {
			for(WebElement f: lstd) {
				System.out.println("The list of Designations are: "+f.getText());
			}
		}
		else {
			System.out.println("The list is empty");
		}

		
	}
	

}
