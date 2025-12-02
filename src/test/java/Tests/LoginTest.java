package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;



public class LoginTest {
    WebDriver driver = new ChromeDriver();
    HomePage home = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    @Test
    public void ValidLogin() {

        home.goToLoginPage();
        loginPage.login("mttolba2004@gmail.com", "Malak_2004");
    }
    @Test
    public void InvalidLogin() {

        home.goToLoginPage();
        loginPage.login("mttolba2004@gmail.com", "Malak_2005");
    }
}
