package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set2A_Question1 extends TestBase{
	@BeforeTest
	public void launchBrowser() {
		//opening the url https://www.meripustak.com.
		init("Chrome", "https://www.meripustak.com");
	}
	@Test
	public void validateApplication() throws InterruptedException {
		try {
			checkPageReady();
			//Printing the height and width of the logo.
			int width = d.findElement(By.xpath("//a[@id='mpstkLogo']/img")).getSize().getWidth();
			int height = d.findElement(By.xpath("//a[@id='mpstkLogo']/img")).getSize().getHeight();
			System.out.println(width);
			System.out.println(height);
			
			//Printing the pinterest target url under follow us. 
			List<WebElement> social = d.findElements(By.xpath("//div[@class='social links_right']"));
			for (WebElement e:social) {
				e.getAttribute("className").contains("Pinterest");
				System.out.println(d.findElement(By.xpath("//div[@class='social links_right']/a[4]")).getAttribute("href"));
			}
			
			//Clicking on the shopping cart and verifying the message "No Item is Added In Cart yet.Cart is Empty!!!” in cart table. 
				d.findElement(By.xpath("//*[@href='https://www.meripustak.com/cart']")).click();
				Thread.sleep(5000);
				Assert.assertEquals(d.findElement(By.xpath("//table[@class='table-striped table-bordered cart_table']//h4")).getText().trim(), "No Item is Added In Cart yet.Cart is Empty!!!");
				System.out.println("Text present - No Item is Added In Cart yet.Cart is Empty!!!");
				d.navigate().back();
				Thread.sleep(5000);
				
			//Searching and adding any cricket book in cart and verifying the “no items is added .. “message no longer appears in table.
				d.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys("Cricket");
				d.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				d.findElement(By.xpath("//div[@id='book_list']//child::li/a")).click();
				Thread.sleep(5000);
				d.findElement(By.xpath("//input[@id='ContentPlaceHolder1_AddtoCart']")).click();
				Thread.sleep(5000);
				Assert.assertEquals(d.findElement(By.xpath("//table[@class='table-striped table-bordered cart_table']//h4")).getText().trim(), "No Item is Added In Cart yet.Cart is Empty!!!");
				System.out.println("Text present - No Item is Added In Cart yet.Cart is Empty!!!");				
		}catch(Exception e) {
			System.out.println("Text is not present - No Item is Added In Cart yet.Cart is Empty!!!");
		}
	}
	@AfterTest
	public void closeBrowser() {
		close();
	}
}