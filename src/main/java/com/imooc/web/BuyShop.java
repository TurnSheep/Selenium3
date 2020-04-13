package com.imooc.web;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BuyShop {
    public Logger logger=Logger.getLogger(TestngCase.class);
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
        SendToEmail();
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
    public void test01(){
        int a=0;
        int beforeNumber=0;
        String CourseTitle=driver.getTitle();
        if (CourseTitle.contains("剑指Java面试-Offer直通车")){
            System.out.println("获取title正确");
        }
        try{
            beforeNumber=Integer.parseInt(driver.findElement(By.className("js-cart-num")).getText());
        }catch (Exception e){
            System.out.println("购物车数量为空");
        }

        driver.findElement(By.className("js-addcart")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int afterNumber=Integer.parseInt(driver.findElement(By.className("js-cart-num")).getText());
        a=afterNumber-beforeNumber;
        if (a==1){
            System.out.println("添加购物车成功");
        }

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
