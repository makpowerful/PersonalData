package CPSATEXAM;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class PageObjectClass extends TestBase{
	

	WebDriver d;
	public PageObjectClass(WebDriver d) {
		this.d=d;
		
	}
	By SpeakerNames=By.xpath("//table[@data-id='66af78a']//tr/td[2]");
	By SpeakerTopic=By.xpath("//table[@data-id='66af78a']//tr/td[3]");
	By SpeakerStory=By.xpath("//table[@data-id='66af78a']//tr/td[4]/a");
	By SpeakerInterview=By.xpath("//table[@data-id='66af78a']//tr/td[5]/a");
	
	public void getSpeakerDetails(String speakerName)
	{
		int counter=1;
		String  speakTopic="";
		String SpeakStory="";
		String Interview="";
		List<WebElement> spkNames=d.findElements(SpeakerNames);
		int videosize=0;
		String videoInterview="";
		for(WebElement name:spkNames) {
			if(name.getText().equalsIgnoreCase(speakerName))
			{
				speakTopic=d.findElements(SpeakerTopic).get(counter-1).getText();
				SpeakStory=d.findElements(SpeakerStory).get(counter-1).getAttribute("href");
				videosize=d.findElements(By.xpath("//table[@data-id='66af78a']//tr['+counter+']/td[5]/a")).size();
				
			}
			if(videosize!=0)
			{
				
				videoInterview=d.findElement(By.xpath("//table[@data-id='66af78a']//tr['+counter+']/td[5]/a")).getAttribute("href");
			}
		counter++;
		}
		
		if (speakTopic=="") {
			System.out.println("Speaker not present");
		} else {
			System.out.println("Speak Topic: " +speakTopic+" | Speak Story: "+SpeakStory+" | Interview :"+ videoInterview);
		}
		
		
		
	}
	public String GetPageTitle()
	{
		return d.getTitle();
		
	}
}