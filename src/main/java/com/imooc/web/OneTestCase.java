package com.imooc.web;

import com.google.common.io.Files;
import com.imooc.util.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OneTestCase {

    public static WebDriver driver;

    @Test
    public void f1(){
        System.out.println("This is Tets1");
    }

    @Test
    public void f2() {
        String username;
        String password;
        String path1 = ProUtil.class.getClassLoader()
                .getResource("User.properties").getPath();//ClassLoader.getResource()的资源获取不能以 / 开头，统一从根路径开始搜索资源
        ProUtil pro = new ProUtil(path1);
        for (int i = 0; i < pro.GetLines(); i++) {
            username = pro.GetPro("user" + i).split(">")[0];
            password = pro.GetPro("user" + i).split(">")[1];
            WebElement EmailElement_01 = GetElement("username");
            EmailElement_01.sendKeys(username);//输入用户名
            WebElement PassWordElement_01 = GetElement("password");
            PassWordElement_01.sendKeys(password);//输入密码
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement LoginElment_01 = GetElement("login");
            LoginElment_01.click();//点击登录
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Actions Moseactions = new Actions(driver);
                WebElement UserPng = GetElement("UserPng");
                Moseactions.moveToElement(UserPng).perform();
                String UserName = GetElement("UserName").getText();
                if (UserName.equals("Y_zzzzz")) {
                    System.out.println("登陆成功");
                } else {
                    System.out.println("用户信息不匹配" + UserName);
                }

            } catch (Exception e) {
                TakeScreenShot();
                System.out.println("登陆失败");
            }
            EmailElement_01.clear();
            PassWordElement_01.clear();

        }
    }

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
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("This is beforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("This is afterTest");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("This is beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("This is afterMethod");
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

//        保存图片
    public void TakeScreenShot(){
//        图片名字
//        图片保存的路径
//        获取当前的时间
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String CurTime=simpleDateFormat.format(new Date());
//       获取当前类名
        String curClassName=this.getClass().getName();
        String pngPath=curClassName+"_"+CurTime+".png";
//        保存路径
        String curPath=System.getProperty("user.dir");
        File ScrFile=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(ScrFile,new File(curPath+"\\"+pngPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
