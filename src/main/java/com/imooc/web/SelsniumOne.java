package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SelsniumOne {
    public static WebDriver driver;

    public void lnitDrier(){
        driver =new ChromeDriver();
        driver.get("http://www.imooc.com");
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.close();
    }

    public void GetElement(){
        driver.findElement(By.id("js-signin-btn")).click();//id定位
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("email")).sendKeys("625707127@qq.com");//name定位
        driver.findElement(By.className("js-loginPassword")).sendKeys("5211314hzy....");//className定位
        WebElement NodeElement=driver.findElement(By.className("rlf-autoin"));//寻找父节点，至父节点下寻找新的属性进行定位
        NodeElement.findElement(By.tagName("input")).click();
        List<WebElement> ButtonElement=driver.findElements(By.className("rlf-group"));//进行list数组，在数组中寻找需要的数据
        ButtonElement.get(4).click();
        driver.findElement(By.linkText("找回密码")).click();//全文字链接
        driver.findElement(By.partialLinkText("无法")).click();//部分文字链接
        driver.findElement(By.xpath("//*[@id=\"signin\"]/div[3]/div[1]/span")).click();//Xpath定位
        driver.findElement(By.cssSelector("#signup-form > div.rlf-group.pr.phoneVerityBox > p.reSend.pa.active.js-phonecode-box > span")).click();//Css定位
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }
    public static void main(String[]args){
        SelsniumOne selsniumOne=new SelsniumOne();
        selsniumOne.lnitDrier();
        selsniumOne.GetElement();

    }
}
