package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.Constants;
import utility.NavigateClass;
import utility.Operations;

public class RegisterTest {

    private WebDriver driver;
    private By username, password, repeatedPassword, firstName, lastName, email, phone, address1, address2, city, state, zip, country, save;
    public RegisterTest(WebDriver driver){
        this.driver=driver;
    }
    public void setUname(String uname) {
        driver.findElement(username).sendKeys(uname);
    }
    public void setPass(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void setRepeatPass(String repeatPass) {
        driver.findElement(repeatedPassword).sendKeys(repeatPass);
    }

    public void setFname(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void setLname(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void setMail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void setPhn(String phn) {
        driver.findElement(phone).sendKeys(phn);
    }

    public void setAddrs1(String addrs1) {
        driver.findElement(address1).sendKeys(addrs1);
    }

    public void setAddrs2(String addrs2) {
        driver.findElement(address2).sendKeys(addrs2);
    }

    public void setCt(String ct) {
        driver.findElement(city).sendKeys(ct);
    }

    public void setSt(String st) {
        driver.findElement(state).sendKeys(st);
    }

    public void setZp(String zp) {
        driver.findElement(zip).sendKeys(zp);
    }

    public void setCntry(String cntry) {
        driver.findElement(country).sendKeys(cntry);
    }
    public void initRegisterField() {
        username = By.id("username");
        password = By.id("password");
        repeatedPassword = By.id("repeatedPassword");
        firstName = By.id("firstName");
        lastName = By.id("lastName");
        email = By.id("email");
        phone = By.id("phone");
        address1 = By.id("address1");
        address2 = By.id("address2");
        city = By.id("city");
        state = By.id("state");
        zip = By.id("zip");
        country = By.id("country");
        save = By.id("save");
    }
    public void navigateToSignIn() throws InterruptedException {
        NavigateClass navigateClass=new NavigateClass(driver);
        navigateClass.navigateTo(Constants.ENTERTOSTORE);
        Thread.sleep(600);
        navigateClass.navigateTo(Constants.SIGNIN);
        Thread.sleep(600);
        navigateClass.navigateTo(Constants.REGISTER);
        Thread.sleep(600);
    }

    public void clickRegister() {
        Operations operations=new Operations();
        operations.clickOperation(driver,save);
    }
    
    public void doRegister(String username, String pass, String repeatPass, String fname, String lname, String email, String phone, String address1, String address2, String city, String state, String zip,String country){
        this.initRegisterField();
        this.setUname(username);
        this.setPass(pass);
        this.setRepeatPass(repeatPass);
        this.setFname(fname);
        this.setLname(lname);
        this.setMail(email);
        this.setPhn(phone);
        this.setAddrs1(address1);
        this.setAddrs2(address2);
        this.setCt(city);
        this.setSt(state);
        this.setZp(zip);
        this.setCntry(country);
    }
}
