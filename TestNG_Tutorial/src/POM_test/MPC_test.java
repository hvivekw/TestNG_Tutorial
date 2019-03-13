package POM_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MPC_test {
	
	static WebDriver driver = null;
	
	public void testLogin(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		TestLogin login = new TestLogin(driver);
		login.username();
		login.password();
		login.submit();		
		
	}
	
	public void testLogout(){
		TestLogout logout = new TestLogout();
	}

}
