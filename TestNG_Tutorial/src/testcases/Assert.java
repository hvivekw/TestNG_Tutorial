package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert {
	
	SoftAssert softassert = new SoftAssert();	
	@Test(priority=1)
	public void softassert()
	{
		softassert.assertEquals("softassert1", "softassert");		
	}
	
	@Test(priority=0)
	public void hardassert()
	{
	    
	}
}


