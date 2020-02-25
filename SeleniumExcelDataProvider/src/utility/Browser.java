package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	static WebDriver driver;
	public static WebDriver setBrowser(String type) {
		if(type.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Java\\SeleniumDemo\\WebDrivers\\chromedriver.exe");
			
			driver=new ChromeDriver();
			return driver;
		}
		else if(type.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Documents\\Java\\SeleniumDemo\\WebDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;
		}
		else {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Admin\\Documents\\Java\\SeleniumDemo\\WebDrivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			return driver;
		}
	}

}
