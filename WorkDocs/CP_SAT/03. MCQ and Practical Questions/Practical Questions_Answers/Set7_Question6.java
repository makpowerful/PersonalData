package cpsatExamTestNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import com.testing.base.TestBase;

public class Set7_Question6 extends TestBase {

	@FindBy(xpath = Set7_TestNGQuestionsPageObject.derivativeoption_xpath)
	public WebElement derivativeoption_xpath;

	@FindBy(xpath = Set7_TestNGQuestionsPageObject.currencyderivative_xpath)
	public WebElement currencyderivative_xpath;

	@FindBy(xpath = Set7_TestNGQuestionsPageObject.currencyderivativesearchbox_xpath)
	public WebElement currencyderivativesearchbox_xpath;

	@FindBy(xpath = Set7_TestNGQuestionsPageObject.currencytext_xpath)
	public WebElement currencytext_xpath;

	@BeforeTest
	public void initiateDriver() throws InterruptedException {
			init("Chrome", "http://www.nseindia.com/");
			PageFactory.initElements(d, this);
	}
	@Test
	public void testCase1() throws InterruptedException {
		try {

			derivativeoption_xpath.click();
			scrollDown();
			jsClick(currencyderivative_xpath);
			wait(2);
			Actions action = new Actions(d);
			action.moveToElement(currencyderivativesearchbox_xpath).click().sendKeys("usdinr").sendKeys(Keys.ENTER).build().perform();
			wait(2);
			checkPageReady();
			if (currencytext_xpath.isDisplayed())
				System.out.println("The text is displayed as expected");
			else
				System.out.println("The text is not displayed as expected");

		} catch (Exception e) {
			e.printStackTrace();
			terminate();
		}
	}
	@AfterTest
	public void AfterTest() {
			terminate();
	}
}

