package cpsatExamTestNG;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Set4_Question1_PageFactory {

	WebDriver d;
	
	@FindBys({@FindBy(xpath="//div[@class='contactbg-right']//img[@class='scale']")})
	List<WebElement> iList;
	
	public Set4_Question1_PageFactory(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);
	}
	
	public void printSocialList()
	{
		for (int i=0; i<iList.size(); i++)
		{
			System.out.println("Tool Tip: " + iList.get(i).getAttribute("title").trim());
		}
	}
	
}

