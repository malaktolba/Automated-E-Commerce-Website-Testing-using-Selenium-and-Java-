package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.id("Email");
    By passwordField = By.id("Password");
    By loginButton = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input");
    By invalidLogin = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span");

public void login(String username, String password) {
    driver.findElement(emailField).sendKeys(username);
    driver.findElement(passwordField).sendKeys(password);
    driver.findElement(loginButton).click();
    }
    public boolean invalidMessage(){
        if(driver.findElement(invalidLogin).getText().equals("Login was unsuccessful. Please correct the errors and try again.")){
            return true;
        }
        return false;
    }
}