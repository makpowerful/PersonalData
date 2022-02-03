package stepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings({ "deprecation", "unused" })
@RunWith(Cucumber.class)
public class stepDefination extends base {
	WebDriver driver;
	public By tag = By.tagName("html");

	@Given("^User is on Signin page \"([^\"]*)\"$")
	public void user_is_on_Signin_page(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		this.driver=driver;
		driver.get(arg1);
		Thread.sleep(3000);
	}
    
	@When("^Enter username and password$")
	public void enter_username_and_password() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[3]/div/div/lightning-input/div/input"))
				.sendKeys("stateofmainecitizenjacksmith@deloitte.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[4]/div/div/lightning-input/div/input")).sendKeys("Deloitte@3");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@value='Accept']")).click();
		Thread.sleep(2000);
		driver.findElement(tag).sendKeys(Keys.END);
		WebElement signin_click=driver.findElement(By.xpath("//button[contains(text(),'Sign')]"));
		
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(ExpectedConditions.elementToBeClickable(signin_click)).click();
		Thread.sleep(20000);
		driver.findElement(tag).sendKeys(Keys.END);
		WebElement Accept_click=driver.findElement(By.xpath("//button[contains(text(),'Yes')]"));
		w.until(ExpectedConditions.elementToBeClickable(Accept_click)).click();
		Thread.sleep(5000);
	}

	@Then("^User should be logged in to application and land on Dashboard screen$")
	public void user_should_be_logged_in_to_application_and_land_on_Dashboard_screen() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getTitle(), "Home");
	}

}