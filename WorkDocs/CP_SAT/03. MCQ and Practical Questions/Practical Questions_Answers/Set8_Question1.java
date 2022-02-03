package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;

public class Set8_Question1 extends TestBase {
	private static Actions act;
	private SoftAssert verify;


	@BeforeMethod
	public void method1()
	{
		//Open the website https://www.rediff.com/
		init("Chrome","https://www.rediff.com/");
		act=new Actions(d);

	}

	@Test
	public void Test1() 
	{
		try
		{
			verify=new SoftAssert();
			checkPageReady();

			//Click on the menu for “Get Ahead”(
			d.findElement(By.xpath("//ul[@class='navbarul']//li[@class='getahead']")).click();
			wait(5);

			//Take a screenshot 
			takeTheScreenShot("Set8_Question1");


			//Get the Href’s of all the submenu items 
			List<WebElement> subMenu=d.findElements(By.xpath("//div[@class='subnavbar getahead']//ul//li//a"));
			System.out.println("Href of Sub menu Items: ");
			for(int i=0;i<subMenu.size();i++)
			{
				System.out.println(subMenu.get(i).getAttribute("href"));
			}

			//Assert that the tool tip of the adjacent menu item Get Ahead is “REALTIME NEWS” 
			String actualTooltip=d.findElement(By.xpath("//ul[@class='navbarul']//li//a[text()='REALTIME NEWS']")).getAttribute("title");
			if(actualTooltip.equals("Realtime news"))
			{
				verify.assertTrue(true);
				System.out.println("Tooltip of the Adjacent menu item of Get Ahead is as expected");
			}
			else
			{

				verify.assertTrue(false);
				System.out.println("Tooltip of the Adjacent menu item of Get Ahead is not as expected");

			}

			//Hover the mouse on the adjacent menu item (Get Ahead) showing the tool tip “REALTIME NEWS”. Take a screenshot showing the tooltip
			act.moveToElement(d.findElement(By.xpath("//ul[@class='navbarul']//li//a[text()='REALTIME NEWS']")));
			act.build().perform();
			takeTheScreenShot("Set8_Question1");

			//Assert that the background colour of the submenu items for News is having the following RGB (116, 98, 224) value. 
			String actualRGBVal=d.findElement(By.xpath("//div[@class='subnavbar getahead']")).getCssValue("background");
			if(actualRGBVal.contains("rgb(116, 98, 224)"))
			{
				verify.assertTrue(true);
				System.out.println("Background color is as expected");
			}
			else
			{

				verify.assertTrue(false);
				System.out.println("Background color is not as expected");

			}

			//Assert that the value of RGB in above step maps to the following colour name (Medium Purple) 
			String p_win=d.getWindowHandle();
			((JavascriptExecutor)d).executeScript("window.open('https://www.color-blindness.com/color-name-hue/')","");
			switchWindow();
			checkPageReady();
			d.switchTo().frame(d.findElement(By.xpath("(//iframe[contains(@src,'color-name')])[1]")));
			((JavascriptExecutor)d).executeScript("document.getElementById('cp1_Red').value='116';");
			((JavascriptExecutor)d).executeScript("document.getElementById('cp1_Green').value='98';");
			((JavascriptExecutor)d).executeScript("document.getElementById('cp1_Blue').value='224';");
			jsClick(d.findElement(By.xpath("//input[@id='cp1_RedRadio']")));
			d.findElement(By.xpath("//input[@id='cp1_Blue']")).sendKeys(Keys.ENTER);
			wait(3);
			String actualColor=d.findElement(By.xpath("//div[@id='cp1_ColorNameText']")).getText();
			if(actualColor.contains("Medium Purple"))
			{
				verify.assertTrue(true);
				System.out.println("Background color name is as expected");
			}
			else
			{

				verify.assertTrue(false);
				System.out.println("Background color name is not as expected");

			}
			d.switchTo().defaultContent();
			d.close();
			d.switchTo().window(p_win);
			verify.assertAll();
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

