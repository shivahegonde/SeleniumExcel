package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.Constants;
import utility.NavigateClass;
import utility.Operations;
public class LoginTest {
	WebDriver driver;

	By username, password, login,logout;
	public LoginTest(WebDriver driver) {
		this.driver = driver;
		this.username = By.name("username");
		this.password = By.name("password");
		this.login = By.id("login");
		this.logout = By.linkText("Sign Out");
		
		 
	}

	public void setUsername(String uname) {
		driver.findElement(username).sendKeys(uname);
	}

	public void setPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	public void navigateToLogIn() throws InterruptedException {
		
		NavigateClass navigateClass=new NavigateClass(driver);
		navigateClass.navigateTo(Constants.SIGNIN);
		Thread.sleep(600);
	}
	public void clickLogin() {
		Operations operations=new Operations();
		operations.clickOperation(driver,login);
	}
	public void clickLogout() {
		Operations operations=new Operations();
		operations.clickOperation(driver,logout);
	}
	public void doLogin(String uname,String pass) {
		this.setUsername(uname);
	    this.setPassword(pass);
	}
}
