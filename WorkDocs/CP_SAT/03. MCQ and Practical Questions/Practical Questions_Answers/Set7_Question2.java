package cpsatExamJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set7_Question2 extends TestBase {
	@Before
	public void initiateDriver() throws InterruptedException {
			init("Chrome", "http://www.imdb.com/");
	}

	@Test
	public void testCase1() {
		try {
			Actions action = new Actions(d);
			action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.imdbsearchbox_xpath))).click()
					.sendKeys("Gangs of New York").sendKeys(Keys.ENTER).build().perform();
			wait(2);
			checkPageReady();
			d.findElement(By.xpath(Set7_JunitQuestionsPageObject.imdbmoviwresult_xpath)).click();
			checkPageReady();
			String MPAArating = d.findElement(By.xpath(Set7_JunitQuestionsPageObject.mpaarating_xpath)).getText();
			String[] mpaaarting = MPAArating.split(" ");
			String MPAArating1  = mpaaarting[1];
			if(MPAArating1.equals("R"))
			 System.out.println("MPAArating is displayed as 'R'");
			else
				System.out.println("MPAArating is not displayed as 'R'");
			String moviegenre = d.findElement(By.xpath(Set7_JunitQuestionsPageObject.moviegenres_xpath)).getText();
			if(moviegenre.equalsIgnoreCase("Crime"))
			System.out.println("The movie genre has Crime as expected");
			else
				System.out.println("The movie genre is not Crime as expected");	
			String runtime = d.findElement(By.xpath(Set7_JunitQuestionsPageObject.movieruntime_xpath)).getText();
			String[] runtime1 = runtime.split(" ");
			int movietime = Integer.parseInt(runtime1[0]);
			if(movietime < 180)
			    System.out.println("The movie time is less than 180 min as expected");
			else
				System.out.println("The movie time is not less than 180 min as expected");
			action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.userreviewsection_xpath))).build().perform();
			String reviewername = d.findElement(By.xpath(Set7_JunitQuestionsPageObject.reviewername_xpath)).getText();
			System.out.println("The reviewer name is displayed as "+reviewername);
		} catch (Exception e) {
			e.printStackTrace();
			terminate();
		}
	}

	@After
	public void AfterTest() {
			terminate();
	}
}

