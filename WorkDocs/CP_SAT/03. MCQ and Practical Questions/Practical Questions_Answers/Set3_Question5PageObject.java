package cpsatExamJunit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class Set3_Question5PageObject extends TestBase{
	
	By contact=By.xpath("//a[contains(text(),'Contact Us')]");
	By icons=By.xpath("//div[@class='icons-container']//a/span");
	
	
	public int getIconsCount() {
		return d.findElements(icons).size();
	}
	
	public WebElement getContact() {
		return d.findElement(contact);
	}
	
	public String getIconName(int i) {
		List<WebElement> iconNames=d.findElements(icons);
		String[] parts=iconNames.get(i).getText().split("/");
		return parts[parts.length-1];
	}
	
	
	public void contact() {
		d.findElement(contact).click();
	}
	
	
	public boolean checkPresence(String text) {
		return d.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed();
	}
	
	public WebElement getParticularText(String text) {
		return d.findElement(By.xpath("//*[text()='"+text+"']"));
	}

}

