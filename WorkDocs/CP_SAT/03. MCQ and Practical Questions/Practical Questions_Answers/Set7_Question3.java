package cpsatExamJunit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.testing.base.TestBase;

public class Set7_Question3 extends TestBase{
	@Before
	public void initiateDriver() throws InterruptedException {
		init("Chrome", "https://www.firstcry.com/");
	}
	@Test
	public void testCase1() {
		List<Double>listprice= new ArrayList<Double>();
		List<Double>sortedprice= new ArrayList<Double>();
		int j=0;
		String price="";
		boolean flag=false;
		try {
			for (int i = 1; i <= 3; i++) {
				wait(2);
				String keyword = readData("src\\test\\resources\\TestData\\Set7_Question3.xlsx", "TestData", i, 0);
				System.out.println(keyword);
				Actions action = new Actions(d);
				wait(2);
				action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.firstcrysearchbox_xpath))).click().sendKeys(keyword).build().perform();
				wait(5);
				action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.firstcrysearchbtn_xpath))).click().build().perform();
				wait(10);
				if(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.sortdrpdown_xpath)).isDisplayed()) {
					wait(3);
					action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.sortdrpdown_xpath))).click().build().perform();
					wait(5);
					action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.pricesortoption_xpath))).click().build().perform();
					action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.pricesortoption_xpath))).click().build().perform();

					for(j=1;j<=8;j++) {
					if(j==1||j==2) {
					if(j==1)
					 price = d.findElement(By.xpath(Set7_JunitQuestionsPageObject.productprice_xpath+"["+j+"]")).getText().trim();
					else {
						price = d.findElement(By.xpath(Set7_JunitQuestionsPageObject.productprice_xpath+"["+(j+2)+"]")).getText().trim();
					}
					}
					else
					price = d.findElement(By.xpath(Set7_JunitQuestionsPageObject.productprice_xpath+"["+((j+(2*(j-1))))+"]")).getText().trim();
					listprice.add(Double.parseDouble(price));
				    sortedprice.add(Double.parseDouble(price));
					Collections.sort(listprice);
					Collections.sort(listprice, Collections.reverseOrder());
				}
					  for(int m=0;m<=sortedprice.size()-1;m++) {
						  if((listprice.get(m)).equals(sortedprice.get(m)))
								  flag = true;
						}
					}
				 if(flag==true)
						System.out.println("The first 8 products are displayed in descending order of the price for "+keyword);  
				  else
					System.out.println("The first 8 products are not displayed in descending order of the price for "+keyword);
				  for(int f=0;f<keyword.length()-1;f++)
					action.moveToElement(d.findElement(By.xpath(Set7_JunitQuestionsPageObject.firstcrysearchbox_xpath))).click().sendKeys(Keys.BACK_SPACE).build().perform();

				}

		}
		catch(Exception e) {
		e.printStackTrace();
		terminate();
		}
	}
	
	@After
	public void AfterTest() {
		terminate();
	}
}

