package cpsat.test.junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.testing.base.TestBase;

public class Solution3 extends TestBase{
	
	
	@Before
	  public void beforeMethod() throws Throwable {
		init("Chrome", "https://exammay2020.agiletestingalliance.org/data2");
		 checkPageReady();
	  }
	
	@Test
  public void f() throws InterruptedException {
		Solution3pageObject obj=new Solution3pageObject(d);
		obj.getDataSetName();
		String[] Searchname = {"Vaishali", "Fabian", "World"};
         
		for(int i = 0; i< Searchname.length; i++){

					
		List<String> cha = obj.searchData(Searchname[i]);
		System.out.println("Search Key: "+Searchname[i]+" data: "+cha);
		}
  }

  @After
  public void afterMethod() {
	  d.quit();
  }
  
  
}