package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class LoginTest extends BaseTest  {
    HomePage home;
    LoginPage loginPage;
    @Test
    public void ValidLogin() {
        home = new HomePage(driver);
        loginPage = new LoginPage(driver);

        home.goToLoginPage();
        loginPage.login("mttolba2004@gmail.com", "Malak_2004");
        if(home.checkLogin()){
            test.pass("good job");
        }
        else {
            test.fail("bad job");
        }


    }
    @Test
    public void InvalidLogin() {
        home = new HomePage(driver);
        loginPage = new LoginPage(driver);

        home.goToLoginPage();
        loginPage.login("mttolba2004@gmail.com", "Malak_2005");
        if(loginPage.invalidMessage()){
            test.pass("ronaldo");
        }
        else{
            test.fail("messi");
        }

    }
}
