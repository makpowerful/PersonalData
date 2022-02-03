package cpsatExamTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;

public class Set5_Question2 extends TestBase{
	SoftAssert softAssertion = new SoftAssert();
	@BeforeTest
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.google.com/maps/");
	}
	@Test
	public void testCase1() throws InterruptedException {
		try {
			WebElement stadium = d.findElement(By.xpath("//input[@id='searchboxinput' and @class='tactile-searchbox-input']"));
			stadium.sendKeys("Wankhede Stadium");
			stadium.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			WebElement p =d.findElement(By.xpath("//canvas[@class = 'widget-scene-canvas']"));
			int x = 37/2;
			int y= 145/2;
			JavascriptExecutor executor = (JavascriptExecutor)d;
			Actions action = new Actions(d);
			action.moveToElement(p,x,y).click().build().perform();
			executor.executeScript("arguments[0].click();", p);
			Thread.sleep(2000);
			takeTheScreenShot("Question2");
			Thread.sleep(1000);
			Boolean getTxt = d.getPageSource().contains("Stadium");
			softAssertion.assertTrue(getTxt, "Stadium");
			Thread.sleep(1000);
			String expectedTitle = "Wankhede Stadium - Google Maps";
			String actualTitle = d.getTitle();
			softAssertion.assertEquals(actualTitle, expectedTitle);
			Thread.sleep(1000);
			String reviews = d.findElement(By.xpath("//span/button[@jsaction='pane.rating.moreReviews']")).getText();
			reviews = reviews.replace("(", "");
			reviews = reviews.replace(")", "");
			System.out.println("The total number of reviews are: "+reviews);
			String rating = d.findElement(By.xpath("//span/span[@class='section-star-display']")).getText();
			System.out.println("The overall rating is: "+Double.parseDouble(rating));
			WebElement linkText = d.findElement(By.xpath("//div[10]/div/div[1]/span[3]/span[3]"));
			executor.executeScript("arguments[0].scrollIntoView()",linkText);
			WebDriverWait wait = new WebDriverWait(d, 90);
			Boolean value = wait.until(ExpectedConditions.textToBePresentInElement(linkText, "mumbaicricket.com"));
			String linkText1 = linkText.getText();
			softAssertion.assertEquals(linkText1, "mumbaicricket.com");
			Thread.sleep(1000);
			WebElement address = d.findElement(By.xpath("//div[8]/div/div[1]/span[3]/span[3]"));
			executor.executeScript("arguments[0].scrollIntoView()",address);
			String address1 = address.getText();
			System.out.println(address1);
			Thread.sleep(1000);
			WebElement phoneNumber = d.findElement(By.xpath("//div[11]/div/div[1]/span[3]/span[3]"));
			executor.executeScript("arguments[0].scrollIntoView()",phoneNumber);
			String phoneNumber1 = phoneNumber.getText();
			Boolean value1 = wait.until(ExpectedConditions.textToBePresentInElement(phoneNumber, "022 2279 5500"));
			softAssertion.assertEquals(phoneNumber1, "022 2279 5500");
			softAssertion.assertAll();
			takeTheScreenShot("Question2_1");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@AfterTest
	public void AfterTest() {
		try {
		terminate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
