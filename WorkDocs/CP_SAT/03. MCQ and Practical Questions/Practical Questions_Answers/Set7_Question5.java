package cpsatExamTestNG;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set7_Question5 extends TestBase {
	@BeforeMethod
	public void initiateDriver() throws InterruptedException {
			init("Chrome", "https://letterboxd.com/");
	}

	@Test
	public void testCase1() {
		try {
			Actions action = new Actions(d);
			action.moveToElement(d.findElement(By.xpath(Set7_TestNGQuestionsPageObject.peopleheader_xpath))).click().build().perform();
			wait(3);
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("window.scrollBy(0,3000)");
			List<WebElement> listele = d.findElements(By.xpath(Set7_TestNGQuestionsPageObject.reviewersnamelist_xpath));
			for (int i = 1; i <= listele.size() - 1; i++) {
				String reviewername = d.findElement(By.xpath(Set7_TestNGQuestionsPageObject.reviewersnamelist_xpath + "[" + i + "]"))
						.getText();
				System.out.println("The reviewers name are as follows :");
				System.out.println(i + " - "+reviewername);
			}
			String reviewnum = d.findElement(By.xpath(Set7_TestNGQuestionsPageObject.firstreviewerreviews_xpath)).getText();
			System.out.println("The total number of reviews for first reviewer is :"+reviewnum);
			
		} catch (Exception e) {
			e.printStackTrace();
			terminate();
		}
	}

	@AfterMethod
	public void AfterTest() {
		terminate();
	}

}

