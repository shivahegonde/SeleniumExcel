package datadriventestingusingexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import data.Constants;
import pages.LoginTest;
import utility.Browser;

public class TestUsingExcelSheetXLSX {
	WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	LoginTest loginTest;
	boolean result;
	FileOutputStream fileOutput;
	@BeforeTest
	void init() {
		driver=Browser.setBrowser("Chrome");
		driver.manage().window().maximize();
		//driver.get(Constants.LOGINURL);

	}

	@Test
	public void f() throws IOException, InterruptedException {


		System.out.println("Started...");

		// Import excel sheet.
		File src=new File("C:\\Users\\Admin\\Documents\\Java\\SeleniumExcelDataProvider\\excelfile\\TestData.xlsx");

		// Load the file.
		FileInputStream finput = new FileInputStream(src);

		// Load he workbook.
		workbook = new XSSFWorkbook(finput);

		// Load the sheet in which data is stored.
		sheet= workbook.getSheetAt(0);

		for(int i=1; i<=sheet.getLastRowNum(); i++)
		{
			try{

				driver.get(Constants.LOGINURL);
				loginTest=new LoginTest(driver);
				// Import data for Email.
				cell = sheet.getRow(i).getCell(1);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				String username= cell.getStringCellValue();
				//	         driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
				System.out.println("Loop Started..."+i);

				// Import data for password.
				cell = sheet.getRow(i).getCell(2);

				cell.setCellType(Cell.CELL_TYPE_STRING);
				String password=cell.getStringCellValue();
				//	         driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());

				loginTest.doLogin(username,password);
				loginTest.clickLogin();
				String url=driver.getCurrentUrl();
				Thread.sleep(3000);
				Assert.assertEquals(url,"https://jpetstore.cfapps.io/catalog");

				// Specify the message needs to be written.
				String message = "Passed";

				// Create cell where data needs to be written.
				sheet.getRow(i).createCell(3).setCellValue(message);

				// Specify the file in which data needs to be written.
				fileOutput = new FileOutputStream(src);
				workbook.write(fileOutput);

				Thread.sleep(4000);
				loginTest.clickLogout();
				Thread.sleep(3000);
				
			}
			catch(AssertionError e)
			{
				sheet.getRow(i).createCell(3).setCellValue("Failed");
				// Specify the file in which data needs to be written.
				fileOutput = new FileOutputStream(src);
				workbook.write(fileOutput);
				Thread.sleep(4000);
			}
			// finally write content

		}
	}

	@AfterTest
	public void afterMethod() {
		driver.quit();
	}
}
