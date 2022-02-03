package cpsatExamJunit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set5_Question4 extends TestBase {
	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "http://www.allmovie.com");
	}

	@Test
	public void Testcase1() throws InterruptedException {
		try {
		int count = 0;
		Actions action = new Actions(d);
		action.moveToElement(d.findElement(By.xpath(Set5_PageElementsJunit.searchinptfiels_xpath))).click()
				.sendKeys("The Godfather").sendKeys(Keys.ENTER).build().perform();
		wait(2);
		checkPageReady();
		List<WebElement> searchresults = d.findElements(By.xpath(Set5_PageElementsJunit.searchresults_xpath));
		for (int i = 1; i <= searchresults.size(); i++) {
			String result = d.findElement(By.xpath("(//h4[contains(text(),'Movie')]//following::div)[" + i + "]"))
					.getText();
			if (result.contains("1972")) {
				count = i;
				break;
			}
		}
		d.findElement(By.xpath("(//h4[contains(text(),'Movie')]//following::div)[" + count + "]//a")).click();
		wait(2);
		checkPageReady();
		if ((d.findElement(By.xpath(Set5_PageElementsJunit.moviegenre_xpath)).getText()).contains("Crime")) {
			System.out.println("The genre is displayed as crime");
			if (d.findElement(By.xpath(Set5_PageElementsJunit.mpaaRating_xpath)).getText().contains("R")) {
				System.out.println("The MPAA is displayed as 'R'");
				d.findElement(By.xpath(Set5_PageElementsJunit.castcrewtab_xpath)).click();
				wait(2);
				checkPageReady();
				if (d.findElement(By.xpath(Set5_PageElementsJunit.directorname_xpath)).getText()
						.contains("Francis Ford Coppola")) {
					System.out.println("The director name is displayed as expected");
					if (d.findElement(By.xpath(Set5_PageElementsJunit.alpacinocastrole_xpath)).getText()
							.contains("Michael Corleone")) {
						System.out.println("The casting crew name is displayed as expected");
					}
				}
			}

		} else
			System.out.println("Selected movie is invalid");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void AfterTest() {
		terminate();
	}

}

