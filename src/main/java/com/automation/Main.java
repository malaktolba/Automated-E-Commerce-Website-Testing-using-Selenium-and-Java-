package com.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demowebshop.tricentis.com");

        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"products-orderby\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"products-orderby\"]/option[4]")).click();
        List<WebElement> productsPrices = driver.findElements(By.className("actual-price"));
        System.out.println(productsPrices.get(0).getText());
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
        System.out.println(validPrices);


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