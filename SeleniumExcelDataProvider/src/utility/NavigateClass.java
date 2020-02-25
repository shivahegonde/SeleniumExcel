package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigateClass {
    By link;
    WebDriver driver;
    public NavigateClass(WebDriver driver){
        this.driver=driver;
    }
    public void navigateTo(String string){
        link=By.linkText(string);
        driver.findElement(link).click();
    }
}
