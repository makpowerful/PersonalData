package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testing.base.TestBase;

public class Set8_Question2 extends TestBase {
	private static Actions act;
	private SoftAssert verify;
	

	@BeforeMethod
	public void method1()
	{
		init("Chrome","https://www.rediff.com/");
		act=new Actions(d);
		
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
			takeTheScreenShot("Set8_Question2");
			d.navigate().back();
			checkPageReady();
		}
	}
	
	
	@Test
	public void Test1() throws InterruptedException, Exception 
	{
		for (int i = 0; i < 4; i++) {
			checkMenu(readData("src\\test\\resources\\TestData\\TestData_Set8.xlsx", "CPSATExamTestNG_Question8", i, 0));
			checkSubMenu(readData("src\\test\\resources\\TestData\\TestData_Set8.xlsx", "CPSATExamTestNG_Question8", i, 1));
			checkSubMenuLink(readData("src\\test\\resources\\TestData\\TestData_Set8.xlsx", "CPSATExamTestNG_Question8", i, 1),
					readData("src\\test\\resources\\TestData\\TestData_Set8.xlsx", "CPSATExamTestNG_Question8", i, 2));
		}
}
	@AfterMethod
	public void method3() {
		terminate();
	}
	
	
}
