package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class trialCNG {
	static WebDriver driver = null;

	@Test(priority=1)
	public void Login() throws InterruptedException, IOException{

		/* Initialize Chrome browser */
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

		/* Launch CNG application*/
		driver.get("https://redbull.ing-sap.cfapps.eu10.hana.ondemand.com/");

		/* Maximize browser window*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;	

		/* Input from excel*/
		File src = new File("C:\\ExcelData\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String username =sheet1.getRow(0).getCell(0).getStringCellValue();
		String password =sheet1.getRow(0).getCell(1).getStringCellValue();

		/* login */
		driver.findElement(By.id("userid")).sendKeys(username);
		driver.findElement(By.id("userpassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();		
		Thread.sleep(20000);		

	}
	/* Click on Connected Goods Tile */
	@Test(priority=2)
	public void CNG_Tile_click() throws InterruptedException{

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement cng_tile_click = wait.until(ExpectedConditions.elementToBeClickable(By.id("__tile2")));
		cng_tile_click.click();	
		
	}

	@Test(priority=3)
	public void Visual_Filters() throws InterruptedException{
        
		Thread.sleep(5000);
		/* Click on BPStatus Assigned Visual Filters*/		

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement vf_assigned = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[aria-labelledby='__donut1'] [transform='translate \\(-5\\,21\\)'] [aria-hidden]")));
		vf_assigned.click();	

		/* Checking if Visual Filter is selected or not */
		try
		{
			driver.getPageSource().contains("Selected (1)");
			System.out.println("Visual Filter has been selected!");
		}
		catch (Throwable msg)
		{
			System.out.println(msg);
		}
		Thread.sleep(3000);

		/* Removing the selection of the BPStatus Assigned Visual Filter */
		driver.findElement(By.cssSelector("[aria-labelledby='__donut1'] [transform='translate \\(-5\\,21\\)']")).click();
		Thread.sleep(5000);

	}

	@Test(priority=4)
	public void Views_Selection() throws InterruptedException{
		WebElement MapView, TableView, GridView;

		//MapView = driver.findElement(By.id("__item14-button"));
		MapView = driver.findElement(By.xpath("//li[1]/span[@role='presentation']"));
		
		//TableView = driver.findElement(By.id("__item16-button"));
		TableView = driver.findElement(By.xpath("//li[3]/span[@role='presentation']"));

		/* Assuming Map View is selected, switch to Table View */
		if(!MapView.isSelected()){
			TableView.click();
		}

		Thread.sleep(5000);

		/*Assuming Table View is selected , switch to Grid View*/
		//TableView = driver.findElement(By.id("__item16-button"));
		TableView = driver.findElement(By.xpath("//li[3]/span[@role='presentation']"));
		//GridView = driver.findElement(By.id("__item17-button"));
		GridView = driver.findElement(By.xpath("//li[4]/span[@role='presentation']"));

		if(!TableView.isSelected()){
			GridView.click();
		}

		Thread.sleep(5000);
	}

	@Test(priority=5)	
	public void Object_Detail_Page() throws InterruptedException{

		/* Open object detail page of first device*/

		WebElement FirstDevice = driver.findElement(By.cssSelector(".singleCoolerItemClass:nth-of-type(1) .gridIdLabelClass"));
		FirstDevice.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;

		/* Confirm object detail page is launched */
		try
		{
			driver.findElement(By.cssSelector("[alt='Actions']"));
			System.out.println("Object Detail page has been opened");
		}
		catch (Throwable msg)
		{
			System.out.println(msg);
		}

		Thread.sleep(5000);
	}

	@Test(priority=6)
	public void Logout() throws InterruptedException{

		/*click on Home button */	
		driver.findElement(By.id("homeBtn")).click();
		Thread.sleep(5000);

		/* Logout*/
		driver.findElement(By.cssSelector("#meAreaHeaderButton span")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement logout_icon_visibility = wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutBtn-content")));
		logout_icon_visibility.click();	
		Thread.sleep(5000);
		driver.findElement(By.id("__mbox-btn-0-content")).click();
		Thread.sleep(5000);

		/*close the browser instance */
		driver.quit();
	}
}
