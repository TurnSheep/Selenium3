package com.imooc.web;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.apache.log4j.Logger;

@Listeners({TestngListenerScrenn.class})
public class TestngCase {
    public Logger logger=Logger.getLogger(TestngCase.class);
    public  WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver =new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");
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
        SendToEmail();
    }

    @Test
    public void test01(){
        logger.debug("邮箱信息");
        driver.findElement(By.name("email")).sendKeys("111111@qq.com");
        System.out.println("第一个Case");
    }

    @Test
    public void test02(){
        logger.error("错误的邮箱信息");
        driver.findElement(By.name("email1")).sendKeys("111111@qq.com");
        System.out.println("第二个Case");
    }
    @Test
    public void test03(){
        driver.findElement(By.name("password")).sendKeys("111111@qq.com");
        System.out.println("第三个Case");

    }
    @Test
    public void test04(){
        driver.findElement(By.name("password1")).sendKeys("111111@qq.com");
        System.out.println("第四个Case");

    }
    @Test
    public void test05(){
        driver.findElement(By.className("moco-btn-red")).click();
        System.out.println("第五个Case");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("执行beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("执行afterMethod");
    }

//    发送邮件方法
    public void SendToEmail(){
        SimpleEmail email=new SimpleEmail();
        email.setHostName("smtp.163.com");
        email.setAuthentication("zhongyang_he@163.com","ZEYWASIHMAJBSQBH");
        try {
            email.setFrom("zhongyang_he@163.com");
            email.addTo("625707127@qq.com");
            email.setSubject("Selenium sub jet");
            email.setMsg("This is test");
            email.send();
            logger.debug("发送成功");
        } catch (EmailException e) {
            e.printStackTrace();
        }

    }
}
