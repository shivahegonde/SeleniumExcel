package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CallBy {
    public static String id(WebDriver driver, By id){
        return driver.findElement(id).getText();
    }
    public static String name(WebDriver driver, By name){
        return driver.findElement(name).getText();
    }
    public static String className(WebDriver driver, By className){
        return driver.findElement(className).getText();
    }
    public static String xPath(WebDriver driver, By xPath){
        return driver.findElement(xPath).getText();
    }
}
