package Pages;

import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

public class HomePage {
        WebDriver driver;

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }
        By loginButton = By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a");

        public boolean checkLogin(){
           String loginButtonText = driver.findElement(loginButton).getText();
            System.out.println(loginButtonText);
            if(loginButtonText.equals("Log out")){
                return true;
            }
            return false;
        }

        public void goToLoginPage(){
         driver.findElement(loginButton).click();
        }


        By searchBar = By.xpath("//*[@id=\"small-searchterms\"]");
        By searchButton = By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]");
        By productName = By.className("product-title");

        public boolean checkItemSearch(){
            List<WebElement> productNames = driver.findElements(productName);
            boolean valid = true;
            for (int i=0; i< productNames.size();i++) {
                System.out.println(productNames.get(i).getText());
                if(!productNames.get(i).getText().toLowerCase().contains("gift card")){
                    valid=false;
                    break;
                }
            }
            return valid;
        }
        public void search(){

            driver.findElement(searchBar).sendKeys("gift card");
            driver.findElement(searchButton).click();

        }
        By jewelry = By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a");
        By drop = By.xpath("//*[@id=\"products-orderby\"]");
        By filter = By.xpath("//*[@id=\"products-orderby\"]/option[4]");
        public void sort(){
            driver.findElement(jewelry).click();
            driver.findElement(drop).click();
            driver.findElement(filter).click();
        }

        By actualPrice = By.className("actual-price");
        public boolean checkSort(){
            List<WebElement> productsPrices = driver.findElements(actualPrice);
            boolean validPrices  = true;
            float previousPrice = 0;
            for (int i=0; i< productsPrices.size();i++) {

                if(Arrays.stream(productsPrices.get(i).getText().split(" ")).count()>1){
                    if(previousPrice>Float.parseFloat(productsPrices.get(i).getText().split(" ")[1])){
                        validPrices=false;
                        break;
                    }
                    else{
                        previousPrice=Float.parseFloat(productsPrices.get(i).getText().split(" ")[1]);
                    }

                }
                else{
                    if(previousPrice>Float.parseFloat(productsPrices.get(i).getText().split(" ")[0])){
                        validPrices=false;
                        break;
                    }
                    else{
                        previousPrice=Float.parseFloat(productsPrices.get(i).getText().split(" ")[0]);
                    }
                }

            }
            return validPrices;
        }

    public void filter(){
        List<WebElement> productsPrices = driver.findElements(actualPrice);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div/div[2]/ul/li[1]/a")).click();
            productsPrices = driver.findElements(By.className("actual-price"));
            boolean check= true ;
            for (int i=0; i< productsPrices.size();i++){
                if((Float.parseFloat(productsPrices.get(i).getText())>500)|| (Float.parseFloat(productsPrices.get(i).getText())<0)){
                    check=false ;
                    break ;

                }

            }
            System.out.println(check);
        }



}
