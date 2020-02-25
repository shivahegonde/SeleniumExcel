package datadriventestingusingexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.Constants;
import pages.LoginTest;
import utility.Browser;

public class TestUsingExcelSheet {
	WebDriver driver;
	WebDriverWait wait;
    HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFCell cell;
 
	@BeforeTest
	void init() {
		driver=Browser.setBrowser("Chrome");
		driver.manage().window().maximize();
		driver.get(Constants.LOGINURL);
		
	}
  @Test
  public void f() throws IOException, InterruptedException {
	  

		LoginTest loginTest=new LoginTest(driver);
		
		
		// Import excel sheet.
	     File src=new File("C:\\Users\\Admin\\Documents\\Java\\SeleniumExcelDataProvider\\excelfile\\TestData.xls.xlt");
	      
	     // Load the file.
	     FileInputStream finput = new FileInputStream(src);
	      
	     // Load he workbook.
	    workbook = new HSSFWorkbook(finput);
	      
	     // Load the sheet in which data is stored.
	     sheet= workbook.getSheetAt(0);
	      
	     for(int i=1; i<=sheet.getLastRowNum(); i++)
	     {
	         // Import data for Email.
	         cell = sheet.getRow(i).getCell(1);
	         cell.setCellType(Cell.CELL_TYPE_STRING);
	         String username= cell.getStringCellValue();
//	         driver.findElement(By.id("login-email")).sendKeys(cell.getStringCellValue());
	          
	         // Import data for password.
	         cell = sheet.getRow(i).getCell(2);
	         
	         cell.setCellType(Cell.CELL_TYPE_STRING);
	         String password=cell.getStringCellValue();
//	         driver.findElement(By.id("login-password")).sendKeys(cell.getStringCellValue());
		
		loginTest.doLogin(username,password);

		Thread.sleep(3000);
		loginTest.clickLogin();
  }
  }
  @AfterTest
	public void afterMethod() {
		driver.quit();
	}
}
