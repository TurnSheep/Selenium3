package com.imooc.runcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseCase {

    public WebDriver GetDriver(String browser){
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            driver=new ChromeDriver();
        }else{
            System.setProperty("webdriver.gecko.driver", "D:\\Firefox\\geckodriver.exe");
            driver=new FirefoxDriver();
        }
        return driver;
    }
}
