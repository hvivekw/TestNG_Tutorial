package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*public class JavaScriptExecutor {

	@Test
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();

		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('identifierId').value='vivek.236@gmail.com'");
		js.executeScript("document.getElementById('identifierNext').click()");
	}
}*/
public class JavaScriptExecutor {

	WebDriver driver; 
	@Test(priority=1)
	public void test1() {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();

		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("document.getElementById('identifierId').value='vivek.236@gmail.com'");
		js.executeScript("document.getElementById('identifierNext').click()");

	}

	@Test(priority=2)
	public void test2(){

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		JavascriptExecutor js = (JavascriptExecutor)driver;		
		driver.get("http://moneyboats.com/");			
		driver.manage().window().maximize();		

		//Vertical scroll down by 600  pixels		
		js.executeScript("window.scrollBy(0,800)");
	}

	@Test(priority=3)
	public void test3(){

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();		
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		driver.get("http://demo.guru99.com/V4/");			

		WebElement button =driver.findElement(By.name("btnLogin"));			

		driver.findElement(By.name("uid")).sendKeys("mngr185607");					
		driver.findElement(By.name("password")).sendKeys("AnumUre");					

		//Perform Click on LOGIN button using JavascriptExecutor		
		js.executeScript("arguments[0].click();", button);

		//To generate Alert window using JavascriptExecutor. Display the alert message 			
		js.executeScript("alert('Welcome to Guru99');");   

	}
}
