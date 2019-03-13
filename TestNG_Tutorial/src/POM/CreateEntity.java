package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateEntity {

	WebDriver driver;
	
	public CreateEntity(WebDriver driver)
	{
		this.driver = driver;
	}

	public void ClickCE()
	{
		driver.findElement(By.xpath("//*[@id='footermenu']/li[1]")).click();
	}

	public void ClickDealer()
	{
		//driver.findElement(By.className("icon_dealer")).click();
		//driver.findElement(By.name("icon_dealer")).click();
		driver.findElement(By.name("nodeicon")).click();
	}

	public void ClickAdd()
	{
		//driver.findElement(By.name("icon_plus")).click();
		driver.findElement(By.id("iconcreate")).click();
	}

	public void SelectCustomer()
	{
		driver.findElement(By.className("menu-icon")).click();
	}

	public void EnterCustomerDetails(String name, String email, String address, String city, String region, String country, String zipcode, String phone){
		WebElement element = driver.findElement(By.xpath("//*[@id='customerModal']"));
		element.findElement(By.id("customer_Name")).sendKeys(name);
		element.findElement(By.id("customer_Email")).sendKeys(email);
		element.findElement(By.id("customer_Address")).sendKeys(address);
		element.findElement(By.id("customer_City")).sendKeys(city);
		element.findElement(By.id("customer_Region")).sendKeys(region);
		element.findElement(By.id("customer_Country")).sendKeys(country);
		element.findElement(By.id("customer_ZipCode")).sendKeys(zipcode);
		element.findElement(By.id("customer_Phone")).sendKeys(phone);
		element.findElement(By.id("btnsavecust")).click();
	}
}
