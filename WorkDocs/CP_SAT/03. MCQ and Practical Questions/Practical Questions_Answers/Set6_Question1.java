package cpsatExamTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set6_Question1 extends TestBase {

	@BeforeMethod
	public void method1() {
		init("Chrome", "http://www.pepperfry.com/");
	}
	public void checksignUpPopUpPresence() {
		if (d.findElements(By.xpath("//div[@class='popup-box gb-modal reg_modal']/a")).size() > 0) {
			if (d.findElements(By.xpath("//div[@class='popup-box gb-modal reg_modal']/a")).get(0).isDisplayed()) {
				d.findElements(By.xpath("//div[@class='popup-box gb-modal reg_modal']/a")).get(0).click();
			}
		}
	}
	boolean flag = false;
	public void searchItems(String item) throws InterruptedException {
		checksignUpPopUpPresence();
		checkPageReady();
		d.findElement(By.xpath("//input[@id='search']")).clear();
		d.findElement(By.xpath("//input[@id='search']")).sendKeys(item);
		d.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
		if (d.findElements(By.xpath("//span[text()='No results found for ']")).size() > 0) {
			if (d.findElements(By.xpath("//span[text()='No results found for ']")).get(0).isDisplayed()) {
				System.out.println("No Results found for " + item);
				flag = true;
			}
		}
	}
	public void sortItems(String sortBy) throws InterruptedException {
		if (!flag) {
			waitForElementToClickable(d.findElement(By.xpath("//li[@class='drpdwn-price-htol']")));
			d.findElement(By.xpath("//li[@class='drpdwn-price-htol']")).click();
			waitForElementToClickable(d.findElement(By.xpath("//a[text()='Price: Low to High']")));
			d.findElement(By.xpath("//a[text()='" + sortBy + "']")).click();
			wait(1);
			scrollIntoView(d.findElement(By.xpath("//li[@class='drpdwn-price-htol']")));
			takeTheScreenShot("sorted list");
		}
	}
	@Test
	public void Test1() throws Exception {
		for (int i = 0; i < getRowCount("src\\test\\resources\\TestData\\TestData_Set6.xlsx", "Sheet"); i++) {
			searchItems(readData("src\\test\\resources\\TestData\\TestData_Set6.xlsx", "Sheet", i, 0));
			sortItems("Price: Low to High");
		}
	}
	@AfterMethod
	public void method2() {
		terminate();
	}
}