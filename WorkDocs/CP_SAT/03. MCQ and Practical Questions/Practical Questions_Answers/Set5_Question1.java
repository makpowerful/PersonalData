package cpsatExamTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import com.testing.base.TestBase;

public class Set5_Question1 extends TestBase {
	@BeforeTest
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "http://www.meripustak.com");
	}
	@Test
	public void Testcase1() throws Exception {
		try {
			String searchtxtfield_xpath = "//input[contains(@id,'txtsearch')]";
			String tagleftprice_xpath = "//div[contains(@class,'price left')]";
			String tagrightprice_xpath = "//div[contains(@class,'price right')]";
			String productname_xpath = "//span[contains(@itemprop,'name')]";
			for (int i = 1; i <= 3; i++) {
				String keyword = readData("src\\test\\resources\\TestData\\TestData.xlsx", "Question1", i, 0);
				d.findElement(By.xpath(searchtxtfield_xpath)).click();
				d.findElement(By.xpath(searchtxtfield_xpath)).sendKeys(keyword);
				d.findElement(By.xpath(searchtxtfield_xpath)).sendKeys(Keys.ENTER);
				wait(2);
				System.out.println("The search for "+keyword+" in the page");
				checkPageReady();
				for (int j = 1; j <= 10; j++) {
					String bookname = d.findElement(By.xpath("(//span[contains(@itemprop,'name')])[" + j + "]"))
							.getText().trim();
					String leprice = d.findElement(By.xpath("(//div[contains(@class,'price left')])[" + j + "]"))
							.getText();
					String formattedleprice = leprice.replace("Rs.", "");
					String finalpriceleft = formattedleprice.replace("/-", "").trim();
					int leftprice = Integer.parseInt(finalpriceleft);
					String reprice = d.findElement(By.xpath("(//div[contains(@class,'price right')])[" + j + "]"))
							.getText();
					String formattedreprice = reprice.replace("Rs.", "");
					String finalpriceright = formattedreprice.replace("/-", "").trim();
					int rightprice = Integer.parseInt(finalpriceright);
					if (leftprice > rightprice) {
						System.out.println(
								"The book name is: " + bookname + " and the discounted price is: " + rightprice);
						log("The book name is: " + bookname + " and the discounted price is: " + rightprice);
					}
				}
			}
		} catch (Exception e) {
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
