package cpsat.testng;
import org.testng.annotations.Test;
import com.testing.base.TestBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Solution4 extends TestBase{
	
	
	@BeforeMethod
	@Parameters({ "browser" })
	  public void beforeMethod(String browser) throws Throwable {
		init(browser, "https://exammay2020.agiletestingalliance.org/");
		 checkPageReady();
	  }
	
	@Test
  public void f() throws Exception {
		wait(2);
		 d.findElement(By.xpath("//*[@class='eicon-close']")).click();
		 checkPageReady();
		 WebElement ele = d.findElement(By.xpath("//div[@id='primary-menu']//a[contains(text(),'Pages')][1]"));
		 Actions action=new Actions(d);
		 action.moveToElement(ele).perform();
		 d.findElement(By.xpath("//div[@id='primary-menu']//a[contains(text(),'Pages')][1]//following::a[contains(text(),'Certifications')][1]")).click();;
		 scrollDown();
		 scrollDown();
		 wait(2);
		 d.findElement(By.xpath("//i[@class='eicon-close']")).click();;
		 takeScreenShot(d, "Upcomingtickers");
		 List <WebElement> tickers=d.findElements(By.xpath("//div[@class='ticker-content']//a"));
		 String tickerMsg="";
		 int counter=1;
		 for(WebElement ticker: tickers) {
			 if(counter==1) {
				 tickerMsg=ticker.getText();
			 }
			 else
			 {
				 if(tickerMsg.equalsIgnoreCase(ticker.getText())) {
					 
				 }
				 else {
					 System.out.println("The ticker messages are not same");
				 break;
				 }
			 }
			 counter++;
		 }
		 for(WebElement ticker: tickers) {
			 if(ticker.getAttribute("href")==null || ticker.getAttribute("href")=="") {
				 
			 }
			 else
			 {
				 System.out.println(ticker.getAttribute("href"));
			 }
		 }
		 
	 }
  

  @AfterMethod
  public void afterMethod() {
	  d.quit();
  }
  
  
}



