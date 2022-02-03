
package cpsat.testng;

import org.testng.annotations.Test;

import com.testing.base.TestBase;
import com.testing.util.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Solution2 extends TestBase {

	int counter=1;
	@BeforeMethod
	@Parameters({ "browser" })
	  public void beforeMethod(String browser) throws Throwable {
		init(browser, "https://exammay2020.agiletestingalliance.org/");
		waitForElementToVisible(d.findElement(By.xpath("//*[@class='eicon-close']")));
		d.findElement(By.xpath("//*[@class='eicon-close']")).click();
		mouseover(d, d.findElement(By.xpath("//ul[@id='menu-main-1']//a[text()='Data']")));
		d.findElement(By.xpath("//ul[@id='menu-main-1']/li[4]/ul/li[1]/a[1]")).click();
		checkPageReady();

	}

	@Test(dataProvider = "datapro")
	public void f(String id, String name, String address, String city, String country) throws Exception {
		HashMap<String,String> act= new HashMap<String, String>();
		act.put("ID", id);
		act.put("NAME", name);
		act.put("ADDRESS", address);
		act.put("CITY", city);
		act.put("COUNTRY", country);
		
		boolean resultFlag=false;
		int count=1;
		int pageSize=d.findElements(By.xpath("//*[@class='ea-advanced-data-table-pagination ea-advanced-data-table-pagination-button clearfix']//a")).size();
		int pagecount=1;
		boolean flag=false;
		for(int j=1;j<5;j++) {
			count =j;
			String getID=d.findElement(By.xpath("//tbody//tr[@style='display: table-row;']["+j+"]//td[1]")).getText();
			if(getID.trim().equalsIgnoreCase(id)){
			resultFlag=true;
			break;
		}
			if (count==5) {
				d.findElement(By.xpath("//*[@class='ea-advanced-data-table-pagination ea-advanced-data-table-pagination-button clearfix']//a["+pageSize+"]")).click();
			checkPageReady();
			j=1;
			pagecount++;
			if(pageSize==pagecount +2) {
				break;
			}
			}
		
		}
		String getID=null;
		String getName=null;
		String getAdd=null;
		String getCity=null;
		String getCountry=null;
		
		if(resultFlag) {
			System.out.println("PASS");
			getID=d.findElement(By.xpath("//tbody//tr[@style='display: table-row;']["+count+"]//td[1]")).getText();
			getName=d.findElement(By.xpath("//tbody//tr[@style='display: table-row;']["+count+"]//td[2]")).getText();
			getAdd=d.findElement(By.xpath("//tbody//tr[@style='display: table-row;']["+count+"]//td[3]")).getText();
			getCity=d.findElement(By.xpath("//tbody//tr[@style='display: table-row;']["+count+"]//td[4]")).getText();
			getCountry=d.findElement(By.xpath("//tbody//tr[@style='display: table-row;']["+count+"]//td[5]")).getText();
			
			HashMap<String,String> exp=new HashMap<String,String>();
			exp.put("ID", getID);
			exp.put("NAME", getName);
			exp.put("ADDRESS", getAdd);
			exp.put("CITY", city);
			exp.put("COUNTRY", getCountry);
			flag=exp.equals(act);
			
		}
		String result="";
		if(flag) {
			result="PASS";
		}
		else
		{
			result="FAIL";
		}
		
		setData(Constants.pathForWritingData, "Sheet1", counter, 0, id);
		setData(Constants.pathForWritingData, "Sheet1", counter, 1, name);
		setData(Constants.pathForWritingData, "Sheet1", counter, 2, address);
		setData(Constants.pathForWritingData, "Sheet1", counter, 3, city);
		setData(Constants.pathForWritingData, "Sheet1", counter, 4, country);
		setData(Constants.pathForWritingData, "Sheet1", counter, 4, result);
		counter++;
		
	}

	@DataProvider
	public Object[][] datapro() throws Exception {
		Object[][] data = readData(Constants.TestDataExcel_PATH, "Sheet1");
		return data;
	}

	@AfterMethod
	public void afterMethod() {
		d.quit();
	}

}