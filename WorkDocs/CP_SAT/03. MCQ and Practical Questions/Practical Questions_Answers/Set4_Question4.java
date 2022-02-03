package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set4_Question4 extends TestBase {

	@BeforeMethod
	public void method1() {
		//Open url https://www.shoppersstop.com/
		init("Chrome", "https://www.shoppersstop.com/");
	}

	@Test
	public void method2() throws Exception {
		try {

			String filename = "src\\test\\resources\\TestData\\TestData_Set4.xlsx";
			String sheetName = "CPSATExamTestNG_Question4";
			Boolean flag=true;
			wait(30);
			checkPageReady();

			//Reading keywords from excel
			for (int i = 0; i < getRowCount(filename, sheetName); i++) {
				String data = readData(filename, sheetName, i, 0);
				System.out.println("Data to be entered :" + data);

				// Searching for the keyword
				d.findElement(By.xpath("//input[@id='js-site-search-input']")).clear();
				d.findElement(By.xpath("//input[@id='js-site-search-input']")).sendKeys(data, Keys.ENTER);
				wait(5);

				// sorting the items in descending order
				d.findElement(By.xpath("//li[@sortcode='price-desc']")).click();

				checkPageReady();

				scrollToBottom(d.findElement(By.xpath("//a[text()='Load More']")));
				wait(30);
				
				
				// Checking if prices are in descending order.
				List<WebElement> r_Price = d.findElements(By.xpath("//div[@class='li-inner']//div[@class='price_div']"));
				for (int j = 1; j < r_Price.size(); j++) {
					flag=true;
					System.out.println(r_Price.get(j).getText().toString());
					System.out.println((r_Price.get(j).getText().replaceAll("[^0-9]", " ").trim().split(" "))[0].trim());
					if (Float.parseFloat((r_Price.get(j-1).getText().replaceAll("[^0-9]", " ").trim().split(" "))[0].trim()) < Float.parseFloat((r_Price.get(j).getText().replaceAll("[^0-9]", " ").trim().split(" "))[0].trim())) {
						flag = false;
						System.out.println("Items are not in descending order for the item number"+i);
						break;
					} else {
						continue;
					}
				}
				if (flag == true) {
					System.out.println("Items are placed in descending order for the item number "+i);

				}
			}
		} 
		
		catch (Exception e) {
			log("Error message :" + e.getMessage());
			log("Testcase is failed.");
			d.close();
			log("Application closed");
			e.printStackTrace();

		}

	}

	@AfterMethod
	public void method3() {
		terminate();
	}
}
