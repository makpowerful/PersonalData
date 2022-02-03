package cpsatExamJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set7_Question1 extends TestBase {
	@Before
	public void initiateDriver() {
			init("Chrome", "http://www.shoppersstop.com");
	}

	@Test
	public void testCase1() throws InterruptedException {
		try {
			d.findElement(By.xpath(Set7_JunitQuestionsPageObject.brandheaderbtn_xpath)).click();
			wait(2);
			checkPageReady();
			Actions action = new Actions(d);
			action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.huatecurryimglnk_xpath))).build().perform();
			wait(2);
			d.findElement(By.xpath(Set7_JunitQuestionsPageObject.huatecurryviewnowlnk_xpath)).click();
			wait(2);
			checkPageReady();
			takeTheScreenShot("Question1_Shopperstopbrand page");
			String title = d.getTitle();
			if (title.contains("Haute Curry Bags"))
				System.out.println("The Title of the page matches as expected");
			else
				System.out.println("The Title of the page does not matches as expected");
			JavascriptExecutor js = (JavascriptExecutor) d;
			wait(2);
			action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.brandheaderbtn_xpath))).build().perform();
			wait(3);
			js.executeScript("window.scrollBy(0,3000)");
			wait(3);
			if (d.findElement(By.xpath(Set7_JunitQuestionsPageObject.startsomethingnewtxt_xpath)).isDisplayed())
				System.out.println("The footer text is displayed as expected");
			else
				System.out.println("The footer text is not displayed as expected");
			if (d.findElement(By.xpath(Set7_JunitQuestionsPageObject.twitterlogo_xpath)).isDisplayed()) {
				String urlpointingto = d.findElement(By.xpath(Set7_JunitQuestionsPageObject.twittericonurl_xpath)).getAttribute("href");
				System.out.println("The twitter logo is pointing to " + urlpointingto);
			} else
				System.out.println("The twitter logo is not displayed as expected");

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

