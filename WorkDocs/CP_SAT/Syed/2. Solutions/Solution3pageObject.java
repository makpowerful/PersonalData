
package cpsat.junit;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.testing.base.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.testing.util.Constants;

import org.junit.After;
import org.junit.Assert;

public class Solution3pageObject extends TestBase {
	
WebDriver d;
	
	public Solution3pageObject(WebDriver d) {
		this.d = d;
	}
	
	By header=By.xpath("//h2[contains(text(),'DATA SET 1')]");
	By searchBox=By.xpath("//input[@class='ea-advanced-data-table-search']");
	By searchResult=By.xpath("//tbody//tr[@style='display: table-row;']//td");
	
	public void getDataSetName() {
		String heading=d.findElement(header).getText();
		System.out.println("Header is: "+heading);
	}
	
	public void searchData(String keyword) {
		d.findElement(searchBox).clear();
		d.findElement(searchBox).sendKeys(keyword);
		List <WebElement> results=d.findElements(searchResult);
		System.out.println("Records found= " +results.size());
		for(WebElement e: results) {
			System.out.println(e.getText());
		}
	}
}


