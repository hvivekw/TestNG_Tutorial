package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {

	WebDriver driver;	
	public Logout(WebDriver driver)
	{
		this.driver = driver;
	}

	public void profile()
	{		
		//driver.findElement(By.xpath("//*[@id='profileoptions']")).click();
		//driver.findElement(By.xpath("//*[@id='profileoptions']/ul/li")).click();
		driver.findElement(By.id("profileoptions")).click();       
		//driver.findElement(By.id("dash-profile")).click();
	}

	public void submitlogout()
	{	
		driver.findElement(By.xpath("//*[@id='dash-profile']/li[3]/span[2]/a")).click();
	}

}
