package cpsat.junit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.testing.base.TestBase;

public class Solution3 extends TestBase{
	
	
	@Before
	  public void beforeMethod() throws Throwable {
		init("Chrome", "https://exammay2020.agiletestingalliance.org/data1");
		 checkPageReady();
	  }
	
	@Test
  public void f() throws InterruptedException {
		Solution3pageObject obj=new Solution3pageObject(d);
		obj.getDataSetName();
		obj.searchData("india");
  }

  @After
  public void afterMethod() {
	  d.quit();
  }
  
  
}



