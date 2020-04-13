package com.imooc.handle;


import com.imooc.page.SureSubmitPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class SureSubmitHandle  {
    public SureSubmitPage submitPage;
    public WebDriver driver;
    public Logger logger=Logger.getLogger(CourseHandle.class);
    public SureSubmitHandle(WebDriver driver){
        this.driver=driver;
        submitPage=new SureSubmitPage(driver);
    }

    public void ClickSureSubmitElement(){
//        点击提交订单按钮
        submitPage.GetSureSubmitElement().click();
    }


    //    注入cookie
    public void SetCookie(){
        String apsid="UwZjMzNTZkNDk1YzM3YjBiYjliY2U4MDg3OWQ4MzUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANzE5MDQxNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA2MjU3MDcxMjdAcXEuY29tAAAAAAAAAAAAAAAAAAAAADU2YWI3ZDZlM2E2YjI3NTY1NjUwN2I4NGRjZDc2NTczvL%2BKXjmlgF4%3DYm";
        driver.manage().deleteAllCookies();
        Cookie cookie1=new Cookie("apsid",apsid,".imooc.com","/",null);
        driver.manage().addCookie(cookie1);
    }
//        获取title
    public String GetSubmitTitle(){
        return driver.getTitle();
    }
}
