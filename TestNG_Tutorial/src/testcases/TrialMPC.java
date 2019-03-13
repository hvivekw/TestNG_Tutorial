package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TrialMPC {

	@Test
	public void Login() throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qa.mymaxprocloud.com/mpc");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		driver.findElement(By.xpath("//*[@id='loginform']/ul/li[1]/div/input")).sendKeys("test1@test1.com");	
		driver.findElement(By.xpath("//*[@id='loginform']/ul/li[2]/div/input")).sendKeys("Password@123");
		driver.findElement(By.id("btnlogin")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id='footermenu']/li[1]")).click();
		Thread.sleep(6000);
		//driver.findElement(By.name("icon_dealer")).click();
		driver.findElement(By.name("nodeicon")).click();
		//driver.findElement(By.xpath("//*[@id='afc05534-92c0-4c0a-5f70-d4ae9fb4fbb1267b35d9-1e23-e711-80cc-000d3a72ddaf']/i[1]")).click();
		//driver.findElement(By.xpath("//*[@id='a213f6e5-9309-35b7-3160-1a5280ec27b5267b35d9-1e23-e711-80cc-000d3a72ddaf']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("iconcreate")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("menu-icon")).click();
		Thread.sleep(2000);

		try
		{			
			String title = driver.findElement(By.xpath("//*[@id='customerModal']")).getText();
			System.out.println(title);
		}
		catch(Throwable msg)
		{
			System.out.println(msg);
		}

		WebElement element = driver.findElement(By.xpath("//*[@id='customerModal']"));
				
		element.findElement(By.id("customer_Name")).sendKeys("cust1");
		element.findElement(By.id("customer_Email")).sendKeys("cust1@cust1.com");
		element.findElement(By.id("customer_Address")).sendKeys("honeywell");
		element.findElement(By.id("customer_City")).sendKeys("Bengaluru");
		element.findElement(By.id("customer_Region")).sendKeys("Karnataka");
		element.findElement(By.id("customer_Country")).sendKeys("India");
		element.findElement(By.id("customer_ZipCode")).sendKeys("560103");
		element.findElement(By.id("customer_Phone")).sendKeys("0987634567898765");
		element.findElement(By.id("btnsavecust")).click();

	}
}
