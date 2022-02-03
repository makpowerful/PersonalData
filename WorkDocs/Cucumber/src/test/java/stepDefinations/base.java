package stepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {

	public static WebDriver driver;
	public Properties prop;
	public By tag = By.tagName("html");

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			// firefox code
		} else if (browserName.equals("IE")) {
//	IE code
		}

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		return driver;

	}

	/*
	 * public String getScreenShotPath(String testCaseName, WebDriver driver) throws
	 * IOException, InterruptedException { TakesScreenshot ts = (TakesScreenshot)
	 * driver; File source = ts.getScreenshotAs(OutputType.FILE); String
	 * destinationFile = System.getProperty("user.dir") +
	 * "\\reports\\" + testCaseName + ".png"; FileUtils.copyFile(source, new
	 * File(destinationFile)); return destinationFile;
	 * 
	 * }
	 */
	public void ScrollpagedownAxis(int Yaxis) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,200);");
	}
	public void Scrollpagedown() throws InterruptedException {

		driver.findElement(tag).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1200);
	}

	public void Scrollpageup() throws InterruptedException {

		driver.findElement(tag).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1200);
	}

	public void Scrolldown() throws InterruptedException {

		driver.findElement(tag).sendKeys(Keys.DOWN);
		Thread.sleep(1200);
	}

	public void Scrollup() throws InterruptedException {

		driver.findElement(tag).sendKeys(Keys.UP);
		Thread.sleep(1200);
	}

	public void Scrollhome() throws InterruptedException {

		driver.findElement(tag).sendKeys(Keys.HOME);
		Thread.sleep(1200);
	}

	public void Scrollend() throws InterruptedException {

		driver.findElement(tag).sendKeys(Keys.END);
		Thread.sleep(1200);
	}
	
	public void PressEnter() throws InterruptedException {

		driver.findElement(tag).sendKeys(Keys.ENTER);
		Thread.sleep(1200);
	}	
}
