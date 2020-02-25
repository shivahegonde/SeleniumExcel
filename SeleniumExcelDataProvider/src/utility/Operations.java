package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Operations {
    public void clickOperation(WebDriver driver, By way){
        driver.findElement(way).click();
    }
    public static void linkTextClick(WebDriver driver, By way){
        driver.findElement(way).click();
    }
}
