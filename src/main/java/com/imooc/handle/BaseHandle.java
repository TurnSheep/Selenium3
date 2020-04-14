package com.imooc.handle;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHandle {
    public WebDriver driver;
    public BaseHandle(WebDriver driver){
        this.driver=driver;
    }
    //    注入cookie
    public void SetCookie(){
        String apsid="UwZjMzNTZkNDk1YzM3YjBiYjliY2U4MDg3OWQ4MzUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANzE5MDQxNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA2MjU3MDcxMjdAcXEuY29tAAAAAAAAAAAAAAAAAAAAADU2YWI3ZDZlM2E2YjI3NTY1NjUwN2I4NGRjZDc2NTczvL%2BKXjmlgF4%3DYm";
        driver.manage().deleteAllCookies();
        Cookie cookie1=new Cookie("apsid",apsid,".imooc.com","/",null);
        driver.manage().addCookie(cookie1);
    }
    //        获取title
    public String GetTitle(){
        return driver.getTitle();
    }
    public void ClickElement(WebElement webElement){
        webElement.click();
    }
}
