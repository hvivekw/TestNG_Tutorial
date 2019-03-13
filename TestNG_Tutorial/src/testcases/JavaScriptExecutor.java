package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor {

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
}
