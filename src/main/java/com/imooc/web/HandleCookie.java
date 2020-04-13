package com.imooc.web;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Set;

public class HandleCookie {
    public WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    public void afterClass(){
        System.out.println("This is afterClass");
        driver.close();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get("https://coding.imooc.com/class/303.html");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod执行");
    }

    @Test
    public void test1(){
        String apsid="UwZjMzNTZkNDk1YzM3YjBiYjliY2U4MDg3OWQ4MzUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANzE5MDQxNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA2MjU3MDcxMjdAcXEuY29tAAAAAAAAAAAAAAAAAAAAADU2YWI3ZDZlM2E2YjI3NTY1NjUwN2I4NGRjZDc2NTczvL%2BKXjmlgF4%3DYm";
       Set<Cookie> cookies=driver.manage().getCookies();
        for (Cookie cookie:cookies) {
            System.out.println("获取未登录到的cookie---1"+cookie);
            if(cookie.getName().equals("apsid")){
                System.out.println("获取未登录到的cookie---2"+cookie);
            }
        }
        driver.manage().deleteAllCookies();
        System.out.println("删除所有cookie");
        Cookie cookie1=new Cookie("apsid",apsid,".imooc.com","/",null);
        driver.manage().addCookie(cookie1);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("注入cookile");
        driver.navigate().refresh();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
