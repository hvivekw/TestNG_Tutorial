package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExcelInput {	

	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException, IOException{	
		
		Login();
		verifytitle();
		ChangePassword();
		VerifyPasswordPage();
		Logout();
	}	

	//@Test(priority=1)
	@BeforeTest			
	public static void Login() throws IOException 					
	{			
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//Launching the Site.
		driver.get("http://demo.guru99.com/V4/");					

		//Input from excel	
		
		File src = new File("C:\\ExcelData\\TestNGTestData1.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String username =sheet1.getRow(0).getCell(0).getStringCellValue();
		String password =sheet1.getRow(0).getCell(1).getStringCellValue();	
				
		//Login to Guru99 
		
		//driver.findElement(By.name("uid")).sendKeys("mngr70272");	
		driver.findElement(By.name("uid")).sendKeys(username);
		//driver.findElement(By.name("password")).sendKeys("ejUguby");	
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();	
		
		//Verifying the manager home page		
		Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage" );					
	}		

	//@Test(priority=2)
	@BeforeMethod			
	public static void verifytitle()					
	{		
		//Verifying the title of the home page		
		Assert.assertEquals(driver.getTitle(),"Guru99 Bank Manager HomePage" );					
	}		

	//@Test(priority=3)
	@Test
	private static void ChangePassword() 
	{
		driver.findElement(By.linkText("Change Password")).click();
	}
	
	//@Test(priority=4)
	@AfterMethod
	private static void VerifyPasswordPage() 
	{
		String text = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[1]")).getText();
		System.out.println(text);
		Assert.assertEquals(text,"Old Password");	
	}

	//@Test(priority=5)
	@SuppressWarnings("deprecation")
	@AfterTest		
	public static void Logout() throws IOException					
	{		
		driver.findElement(By.linkText("Log out")).click();					
		Alert alert=driver.switchTo().alert();			
		alert.accept();	
		System.out.println(driver.getTitle());
		//Verifying the title of the logout page		
		Assert.assertEquals(driver.getTitle(),"Guru99 Bank Home Page" );	
		
		//******************write output to excel*********//
		
		/*File src = new File("C:\\ExcelData\\TestNGTestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet3 = wb.getSheetAt(2);
		String username =sheet3.getRow(0).getCell(0).getStringCellValue();
		String password =sheet3.getRow(0).getCell(1).getStringCellValue();	*/
		
		//File src = new File("C:\\ExcelData\\TestNGTestData1.xlsx");
		//FileOutputStream fos = new FileOutputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet2 = wb.getSheet("Sheet2");
		//System.out.println(driver.getTitle());
		sheet2.getRow(1).getCell(1).setCellValue("hello");
		System.out.println(driver.getTitle());	
		//******************write output to excel*********//		
	}		
}
