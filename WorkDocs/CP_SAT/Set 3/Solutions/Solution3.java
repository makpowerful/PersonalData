package CPSATEXAM;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.testing.base.TestBase;

public class Solution3 extends TestBase {
	
	
	@Before
	public void bfr() throws InterruptedException {
		init("Chrome", "https://exammay2020.agiletestingalliance.org/");
		checkPageReady();
		
	}

	@Test
	public void test() throws Throwable {
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		mouseover(d, d.findElement(By.xpath("//ul[@id='menu-main-1']/li[3]/a")));
		d.findElement(By.xpath("//ul[@id='menu-main-1']//li[3]/ul/li[2]/a")).click();
		
		PageObjectClass obj=new PageObjectClass(d);
		System.out.println(obj.GetPageTitle());
		
		obj.getSpeakerDetails("masa K MAeda");
		obj.getSpeakerDetails("Khimanad Upreti");
		obj.getSpeakerDetails("Omar Fernandez");
	}
	
}