package mocktest;

import org.testng.annotations.Test;

import data.Constants;
import pages.LoginTest;
import pages.RegisterTest;
import utility.Browser;
import utility.CallBy;
import utility.Operations;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest {
	WebDriver driver;
	String myname;
	XcelParserTestNGLogin login1 = new XcelParserTestNGLogin();
    Object[][] data1;
     
	@Test(priority=1,dataProvider = "RawRegisterData")
	public void registerTest(String username,String password,String repassword,String fname,String lname,String email,String mobile,String addr1,String addr2,String city,String state,String zip,String country) throws InterruptedException {
		RegisterTest registerTest=new RegisterTest(driver);
		registerTest.initRegisterField();
		registerTest.navigateToSignIn();
		registerTest.doRegister(username,password,repassword,fname,lname,email,mobile,addr1,addr2,city,state,zip,country);
		Thread.sleep(500);
//		this.myname="qwe";
		      registerTest.clickRegister();
		      Thread.sleep(1000);
		//      String msg=CallBy.className(driver, By.className(Constants.SUCCESS));
		//      Assert.assertEquals(msg, "Your account has been created. Please try login !!" );
		//      System.out.println("Registration Successful msg is "+ msg);
	}

//
//
//	@Test(dataProvider = "RawLoginData")
//	public void loginTest(String username,String password) throws InterruptedException {
////		driver.get(Constants.LOGINURL);
//		LoginTest loginTest=new LoginTest(driver);
//		loginTest.doLogin(username,password);
//
//		Thread.sleep(3000);
//		loginTest.clickLogin();
//		String name=CallBy.xPath(driver, By.xpath("//*[@id=\"WelcomeContent\"]/div/span"));
//		System.out.println("........... "+   username+"      " +password);
////		Assert.assertEquals(name, myname);
//		System.out.println("User Login Successful... userid== "+name);
//		Operations.linkTextClick(driver, By.linkText("Sign Out"));
//	}
	@DataProvider(name="RawLoginData")
	public Object[][] getLoginDataFromProvider(){
		return new Object[][] {			
				{"shiv1234","shiv1997"},
				{"iv","qwertyuiop"},
				{"shiv1235","shiv1997"},
				{"shiv","shivkumar"},
				{"shiv1236","shiv1997"},
				{"shiv1237","shiv1997"}
		};
	}
	@DataProvider(name="RawRegisterData")
	public Object[][] getRegisterDataFromProvider(){
		return new Object[][] {
			{"shiv1234","shiv1997","shiv1997","qwe","kumar","shiv1234@gmail.com","7897899874","Hadapsar","Pune","Pune","Maharashtra","12345","India"},
			{"shiv1235","shiv1997","shiv1997","qwe","kumar","shiv1235@gmail.com","7897899874","Hadapsar","Pune","Pune","Maharashtra","12345","India"},
			{"shiv1236","shiv1997","shiv1997","qwe","kumar","shiv1236@gmail.com","7897899874","Hadapsar","Pune","Pune","Maharashtra","12345","India"},
			{"shiv1237","shiv1997","shiv1997","qwe","kumar","shiv1237@gmail.com","7897899874","Hadapsar","Pune","Pune","Maharashtra","12345","India"},
			
		};
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver=Browser.setBrowser("Chrome");
		driver.manage().window().maximize();
		driver.get(Constants.BASEURL);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@DataProvider(name="RegisterByExcel")
	
    @Test(dataProvider = "userData")
    public void fillUserForm(String userName, String passWord, String dateCreated, String noOfAttempts, String result)
    {
       System.out.println("UserName: "+ userName);
       System.out.println("PassWord: "+ passWord);
       System.out.println("DateCreated: "+ dateCreated);
       System.out.println("NoOfAttempts: "+ noOfAttempts);
       System.out.println("Result: "+ result);
       System.out.println("*********************");
    }
     
	@DataProvider
    public Object[][] dp() throws IOException {
       //login1.fileName = "Data//Login.xls";
       //login1.sheetName = "Sheet1";
       FileInputStream fis = new FileInputStream("Data//LoginPage.xls");
       String sheetName = "Login";
       login1.loadFromSpreadsheet(fis,sheetName);
       return login1.getData();        
   }
   
    @Test(dataProvider = "dp")
    public void devLogin(String UserName,String PassWord) throws InterruptedException, IOException {

        driver.findElement(By.name("txtUserName")).sendKeys(UserName);
        driver.findElement(By.name("txtPwd")).sendKeys(PassWord);
        driver.findElement(By.name("btnSignIn")).click();
        Thread.sleep(5000);

        if (driver.findElement(By.linkText("DashBoard")).isDisplayed()) {
            List<String> arrayList = new ArrayList<String>();
            arrayList.add("Pass");
            HSSFWorkbook workbook = new HSSFWorkbook();
            login1.createSheet("Login", workbook, arrayList);
        } 
        else {
            try{
            Alert alert=driver.switchTo().alert();
            String alertText=alert.getText();

            Assert.assertEquals("invalid username or password,please try again",alertText);
            alert.accept();
            }catch(UnhandledAlertException e){
                e.printStackTrace();
            }
            List<String> arrayList = new ArrayList<String>();
            arrayList.add("Fail");
            HSSFWorkbook workbook = new HSSFWorkbook();
            login1.createSheet("Login", workbook, arrayList);
        }
    }
   

}
