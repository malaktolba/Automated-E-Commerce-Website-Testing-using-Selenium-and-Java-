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
        driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]")).sendKeys("gift card");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[3]/form/input[2]")).click();
        List<WebElement> productNames = driver.findElements(By.className("product-title"));
        boolean valid = true;
        for (int i=0; i< productNames.size();i++) {
            System.out.println(productNames.get(i).getText());
            if(!productNames.get(i).getText().toLowerCase().contains("gift card")){
                valid=false;
                break;
            }
        }
        System.out.println(valid);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[6]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"products-orderby\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"products-orderby\"]/option[4]")).click();
        List<WebElement> productsPrices = driver.findElements(By.className("actual-price"));
        System.out.println(productsPrices.getFirst().getText());
        boolean validPrices  = true;
        for (int i=0; i< productsPrices.size();i++) {
            System.out.println(productsPrices.get(i).getText().split(" ")[0]);
            if(Arrays.stream(productsPrices.get(i).getText().split(" ")).count()>1){
                System.out.println(productsPrices.get(i).getText().split(" ")[1]);

            }
        }



        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div/div[2]/ul/li[2]/a/span[1]")).click();



    }
}