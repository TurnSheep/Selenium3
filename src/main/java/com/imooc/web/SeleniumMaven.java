package com.imooc.web;

import com.imooc.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumMaven {
    public static WebDriver driver;

    public void lnitDrier(){
        driver =new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //    登陆

    public void UserLogin()  {
        lnitDrier();
        String path1=ProUtil.class.getClassLoader()
                .getResource("User.properties").getPath();//ClassLoader.getResource()的资源获取不能以 / 开头，统一从根路径开始搜索资源
        ProUtil pro=new ProUtil(path1);
        String username=pro.GetPro("user").split(">")[0];
        String password=pro.GetPro("user").split(">")[1];
        WebElement EmailElement_01=GetElement("username");
        EmailElement_01.sendKeys(username);//输入用户名
        WebElement PassWordElement_01=GetElement("password");
        PassWordElement_01.sendKeys(password);//输入密码
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement LoginElment_01=GetElement("login");
        LoginElment_01.click();//点击登录
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Actions Moseactions=new Actions(driver);
            WebElement UserPng=GetElement("UserPng");
            Moseactions.moveToElement(UserPng).perform();
            String UserName=GetElement("UserName").getText();
            if (UserName.equals("Y_zzzzz")){
                System.out.println("登陆成功");
            }else {
                System.out.println("用户信息不匹配"+UserName);
            }

        }catch (Exception e){
            System.out.println("登陆失败");
        }

        driver.close();
    }

//    LoginTest

    @Test
    public void UserLoginTest()  {
        String username;
        String password;
        String path1=ProUtil.class.getClassLoader()
                .getResource("User.properties").getPath();//ClassLoader.getResource()的资源获取不能以 / 开头，统一从根路径开始搜索资源
        ProUtil pro=new ProUtil(path1);
        for(int i=0;i<pro.GetLines();i++){
            lnitDrier();
            username=pro.GetPro("user"+i).split(">")[0];
            password=pro.GetPro("user"+i).split(">")[1];
            WebElement EmailElement_01=GetElement("username");
            EmailElement_01.sendKeys(username);//输入用户名
            WebElement PassWordElement_01=GetElement("password");
            PassWordElement_01.sendKeys(password);//输入密码
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement LoginElment_01=GetElement("login");
            LoginElment_01.click();//点击登录
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Actions Moseactions=new Actions(driver);
                WebElement UserPng=GetElement("UserPng");
                Moseactions.moveToElement(UserPng).perform();
                String UserName=GetElement("UserName").getText();
                if (UserName.equals("Y_zzzzz")){
                    System.out.println("登陆成功");
                }else {
                    System.out.println("用户信息不匹配"+UserName);
                }

            }catch (Exception e){
                System.out.println("登陆失败");
            }

            driver.close();
        }
        }


//    封装定位
    public By GetByLocal(String Key)  {
        String path1=ProUtil.class.getClassLoader()
                .getResource("Element.properties").getPath();//ClassLoader.getResource()的资源获取不能以 / 开头，统一从根路径开始搜索资源
        ProUtil pro=new ProUtil(path1);
        String LocatorBy=pro.GetPro(Key).split(">")[0];
        String LocatorValue=pro.GetPro(Key).split(">")[1];
        if (LocatorBy.equals("id")){
           return By.id(LocatorValue);
        }
        else if(LocatorBy.equals("name")){
            return By.name(LocatorValue);
        }
        else if(LocatorBy.equals("className")){
            return By.className(LocatorValue);
        }else {
            return By.xpath(LocatorValue);
        }
    }


//    封装Element
    public WebElement GetElement(String Key)  {
        WebElement Element=driver.findElement(this.GetByLocal(Key));
        return Element;
    }

}
