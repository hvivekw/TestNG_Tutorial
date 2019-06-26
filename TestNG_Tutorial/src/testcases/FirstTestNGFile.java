package testcases;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstTestNGFile {

	static WebDriver driver;

	public String baseURL = "http://newtours.demoaut.com/";	
	public String expected = null;
	public String actual = null;

	@BeforeTest
	//using Parameters tag to pass browser as parameter(testng.xml should have used parameters tag)
	@Parameters("browser")
	public void launchbrowser(String browser){
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver","C:\\IEDriverServer_x64_3.3.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
		}
		driver.get(baseURL);
	}

	@BeforeMethod
	@Parameters("browser")
	public void verifyhomepagetitle(){
		expected ="Welcome: Mercury Tours"; 		
		actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
	}

	@Test
	@Parameters("browser")
	public void register()
	{
		driver.findElement(By.linkText("REGISTER")).click();
		//driver.findElement(By.cssSelector("td.mouseOut:nth-child(2)")).click();
		expected = "Register: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);    	
	}

	@Test
	@Parameters("browser")
	public void support()
	{
		driver.findElement(By.linkText("SUPPORT")).click();
		expected = "Under Construction: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);    	
	}    

	@AfterMethod
	@Parameters("browser")
	public void gobacktohomepage(){
		driver.findElement(By.linkText("Home")).click();    	
	}

	@AfterTest
	@Parameters("browser")
	public void terminatebrowser(){
		driver.quit();   	
	}

}
