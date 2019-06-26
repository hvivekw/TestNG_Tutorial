package POM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MPC {

	private static final TimeUnit SECONDS = null;
	static WebDriver driver = null;
	static WebDriverWait wait;


	@Test(priority=1)
	public void VerifyLogin() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://perf.mymaxprocloud.com/mpc");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		/*********input from excel****************/
		File src = new File("C:\\ExcelData\\KDF\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String username =sheet1.getRow(0).getCell(0).getStringCellValue();
		String password =sheet1.getRow(0).getCell(1).getStringCellValue();	
		Login login = new Login(driver);        
		//login.username("vivek.gopinath@honeywell.com");
		login.username(username);
		//login.password("Password@123");
		login.password(password);
		/******** input from excel*****************/		
		login.submit();   
		Thread.sleep(6000);
	}

	//@Test(priority=2)
	public void CreateEntity() throws InterruptedException, IOException
	{
		CreateEntity createentity = new CreateEntity(driver);
		createentity.ClickCE();
		Thread.sleep(8000);
		//wait = new WebDriverWait(driver,20);
		//WebElement LoadedCE;
		//LoadedCE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='86611d9f-29fa-19ff-d936-5f2dce4653ebc7790b1c-3c03-e711-80cc-000d3a30fe85']/i[1]")));
		createentity.ClickDealer();		
		Thread.sleep(2000);
		createentity.ClickAdd();
		Thread.sleep(2000);
		createentity.SelectCustomer();
		Thread.sleep(2000);
		
		/******** input from excel*****************/
		File src = new File("C:\\ExcelData\\KDF\\TestData.xlsx");
		FileInputStream fis1 = new FileInputStream(src);
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		XSSFSheet sheet2 = wb1.getSheetAt(1);
		String Name =sheet2.getRow(0).getCell(0).getStringCellValue();
		String Email =sheet2.getRow(0).getCell(1).getStringCellValue();	
		String Address =sheet2.getRow(0).getCell(2).getStringCellValue();
		String City =sheet2.getRow(0).getCell(3).getStringCellValue();	
		String Region =sheet2.getRow(0).getCell(4).getStringCellValue();
		String Country =sheet2.getRow(0).getCell(5).getStringCellValue();	
		String Zipcode =sheet2.getRow(0).getCell(6).getStringCellValue().toString();
		//String Zipcode =sheet2.getRow(0).getCell(6).getStringCellValue();
		//String Phone =sheet2.getRow(0).getCell(7).getStringCellValue();	 
		String Phone =sheet2.getRow(0).getCell(7).getStringCellValue().toString();	
		//createentity.EnterCustomerDetails("Test1","test1@test.com","honeywell","bengaluru","karnataka","india","562125","0987654321");
		createentity.EnterCustomerDetails(Name,Email,Address,City,Region,Country,Zipcode,Phone);
		/******** input from excel*****************/
		Thread.sleep(5000);
	}

	@Test(priority=2)
	public void VerifyLogout() throws InterruptedException
	{
		Logout logout = new Logout(driver); 
		logout.profile();
		logout.submitlogout();
	}
}
