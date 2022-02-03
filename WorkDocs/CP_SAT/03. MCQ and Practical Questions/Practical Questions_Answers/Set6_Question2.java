package cpsatExamJunit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set6_Question2 extends TestBase{
	
	@Before
	public void launchBrowser()
	{
		init("Chrome","http://www.wikipedia.org");
	}
	
	@Test
	public void validate() throws Exception{
		try {
		checkPageReady();
		Set6_Question2PageObject mp=new Set6_Question2PageObject();
		String english = d.findElement(mp.getEnglistTxt()).getText();
		System.out.println("The number of English articles are: "+english);
		WebElement search = d.findElement(By.id("searchInput"));
		search.sendKeys("Anna University");
		search.sendKeys(Keys.ENTER);
		wait(1);
		String motto = d.findElement(mp.getMottoTxt()).getText();
		System.out.println(motto);
		if(motto.contains("Knowledge")) {
			System.out.println("The Motto in English have Knowledge word in it");
		}
		wait(10);
		List<WebElement> notable_person = d.findElements(mp.getNotablePerson());
		scrollIntoView(d.findElement(mp.getNotablePersonSection()));
		for (int i=0;i<notable_person.size();i++) {
			WebElement notable = notable_person.get(i);
			wait(1);
			String person = notable.getText();
			if(person.contains("Ravi Ruia")) {
				System.out.println("Ravi Ruia is present in the notable person list");
			}
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@After
	public void closeBrowser()
	{
		terminate();
	}
}