package testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class ApplicationTest {
	
	@Test(priority=1) //test case with highest priority
	public void doLogin(){
		System.out.println("Login Test execution");
	}
		
	@Test(priority=2) //skip test case
	
	public void doPasswordChange(){	
		System.out.println("change password");
		throw new SkipException("simply");
	}
	
	//test case which depends on previous or another test case
	@Test(priority=3, dependsOnMethods = { "doPasswordChange" }) //test case
	public void doLogout(){
		System.out.println("Logging out");
	}
}
