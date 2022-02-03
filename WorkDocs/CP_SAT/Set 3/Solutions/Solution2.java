public class Solution2 extends TestBase {

	int counter=0;
	@BeforeMethod
	@Parameters({ "browser" })
	  public void beforeMethod(String browser) throws Throwable {
		init(browser, "https://exammay2020.agiletestingalliance.org/");
		waitForElementToVisible(d.findElement(By.xpath("//*[@class='eicon-close']")));
		d.findElement(By.xpath("//*[@class='eicon-close']")).click();
		checkPageReady();

	}

	@Test(dataProvider = "datapro")
	public void f(String FullName, String Email, String PhoneNumber, String Remarks) throws Throwable {
		WebElement ele= d.findElement(By.xpath("//nav[@id='site-navigation']//a[contains(text(),'Forms')]"));
		mouseover(d, ele);
		int error=0;
		jsClick(d.findElement(By.xpath("//nav[@id='site-navigation']//a[contains(text(),'Form 1')]")));
		takeScreenShot(d, "Forms1");
		d.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(FullName);
		d.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(Email);
		d.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys(PhoneNumber);
		d.findElement(By.xpath("//textarea[@placeholder='Comment or Message']")).sendKeys(Remarks);
		d.findElement(By.xpath("//button[@type='submit']")).click();
		
		counter++;
		List<WebElement> errors=d.findElements(By.xpath("//label[contains(@id,'error')]"));
		setData(Constants.pathForWritingData, "Sheet1", counter, 0, FullName);
		setData(Constants.pathForWritingData, "Sheet1", counter, 1, Email);
		setData(Constants.pathForWritingData, "Sheet1", counter, 2, PhoneNumber);
		setData(Constants.pathForWritingData, "Sheet1", counter, 3, Remarks);
		if(errors.size()>0) {
			
			setData(Constants.pathForWritingData, "Sheet1", counter, 4, "Fail");
			
		}
		else {
			setData(Constants.pathForWritingData, "Sheet1", counter, 4, "PASS");
		}
		
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