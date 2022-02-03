package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testing.base.TestBase;

public class Set1B_Question2 extends TestBase{

	@BeforeMethod
	public void method1()
	{
		init("Chrome","https://www.rediff.com/");
	}

	//Asserting Menu present on web page is same as that of excel value. If so, clicking on the same.
	public void checkMenu(String menu) throws InterruptedException{
		checkPageReady();
		List<WebElement> menuname=d.findElements(By.xpath("(//li[@class='"+menu+"'])[1]"));
		Assert.assertEquals(menuname.size()>0,true);
		menuname.get(0).click();
	}

	//Asserting SubMenu present on web page is same as that of excel value.
	public void checkSubMenu(String submenu) throws InterruptedException{
		checkPageReady();
		List<WebElement> submenuname=d.findElements(By.xpath("//a[text()='"+submenu+"']"));
		Assert.assertEquals(submenuname.size()>0,true);
	}

	//Asserting HREF present on web page for SubMenu is same as that of excel value. If so, clicking on SubMenu and taking screen shot.
	public void checkSubMenuLink(String submenu,String expectedLink) throws InterruptedException{
		checkPageReady();
		List<WebElement> submenuname=d.findElements(By.xpath("//a[text()='"+submenu+"']"));
		if(submenuname.size()>0){
			String actlink=d.findElement(By.xpath("//a[text()='"+submenu+"']")).getAttribute("href");
			Assert.assertEquals(actlink,expectedLink);
			d.findElement(By.xpath("//a[text()='"+submenu+"']")).click();
			wait(30);
			takeTheScreenShot("Question2B");
			d.navigate().back();
			checkPageReady();
		}
	}

	@Test
	public void Test1() throws Exception {

		for (int i = 0; i < 4; i++) {
			checkMenu(readData("src\\test\\resources\\TestData\\TestData.xlsx", "Question2B", i, 0));
			checkSubMenu(readData("src\\test\\resources\\TestData\\TestData.xlsx", "Question2B", i, 1));
			checkSubMenuLink(readData("src\\test\\resources\\TestData\\TestData.xlsx", "Question2B", i, 1),
					readData("src\\test\\resources\\TestData\\TestData.xlsx", "Question2B", i, 2));
		}

	}

	@AfterMethod
	public void method2()
	{
		terminate();
	}
}
