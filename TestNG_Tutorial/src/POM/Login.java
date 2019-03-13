package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;

	public Login(WebDriver driver)
	{
		this.driver = driver;
	}

	public void username(String user) 
	{
		driver.findElement(By.xpath("//*[@id='loginform']/ul/li[1]/div/input")).sendKeys(user);	
	}

	public void password(String pass) 
	{		
		driver.findElement(By.xpath("//*[@id='loginform']/ul/li[2]/div/input")).sendKeys(pass);	
	}

	public void submit() throws InterruptedException
	{
		driver.findElement(By.id("btnlogin")).click();
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//*[@id='profileoptions']/ul/li/a/img")).click();
		//driver.findElement(By.xpath("//*[@id='profileoptions']/ul/li/a")).click();
	}
}
