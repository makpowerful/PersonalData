package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set2B_Question1 extends TestBase{
	@BeforeClass
	public void launchBrowser() {
		//opening the url https://www.meripustak.com/
		init("Chrome","https://www.meripustak.com/");
	}
	@Test
	public void validate() throws InterruptedException {
		try {

			//Printing the width and height of the logo. 
			int width = d.findElement(By.xpath("//a[@id='mpstkLogo']/img")).getSize().getWidth();
			int height = d.findElement(By.xpath("//a[@id='mpstkLogo']/img")).getSize().getHeight();
			System.out.println(width);
			System.out.println(height);

			//Under Follow us section on the bottom, extract and print the href of ‘twitter’ social media icon 
			List<WebElement> social = d.findElements(By.xpath("//div[@class='social links_right']"));
			for(WebElement e: social)
			{
				e.getAttribute("className").contains("twitter");
				System.out.println(d.findElement(By.xpath("//div[@class='social links_right']/a[2]")).getAttribute("href"));
			}

			/*Click on the shopping cart when an item in the cart is 0
	          and Assert the message in the shopping cart table “No Item is Added In Cart yet. Cart is Empty!!!” */

			String cart = d.findElement(By.xpath("//a[@href='https://www.meripustak.com/cart']/span")).getText();
			if(cart.contains("0")){
				d.findElement(By.xpath("//*[@href='https://www.meripustak.com/cart']")).click();
				Assert.assertEquals(d.findElement(By.xpath("//table[@class='table-striped table-bordered cart_table']//h4")).getText().trim(), "No Item is Added In Cart yet.Cart is Empty!!!");
				System.out.println("Text present - No Item is Added In Cart yet. Cart is Empty!!!");
				d.navigate().back();

				//Adding java book in cart 
				d.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys("Java");
				d.findElement(By.xpath("//input[@id='txtsearch']")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				List<WebElement> ele2=d.findElements(By.xpath("//*[@class='btn-23']"));
				for(int i=1;i<2;i++)
				{
					ele2.get(i).click();
					Thread.sleep(2000);
				}
				d.findElement(By.xpath("//*[@href='https://www.meripustak.com/cart']")).click();

				//Verifying if this message exists in the shopping cart table “No Item is Added In Cart yet. Cart is Empty!!!”
				String cart1 = d.findElement(By.xpath("//table[@class='table-striped table-bordered cart_table']//h4")).getText();
				Assert.assertEquals(d.findElement(By.xpath("//table[@class='table-striped table-bordered cart_table']//h4")).getText().trim(), "No Item is Added In Cart yet.Cart is Empty!!!");
				System.out.println("Text present - No Item is Added In Cart yet. Cart is Empty!!!");
			}
		}catch(NoSuchElementException e) {
			System.out.println("Text is not present - No Item is Added In Cart yet.Cart is Empty!!!");
		}	
	}
	@AfterClass
	public void closeBrowser() {
		terminate();
	}
}

