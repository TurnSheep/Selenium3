package com.imooc.handle;

import com.imooc.page.CoursePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CourseHandle {
    public CoursePage coursePage;
    public WebDriver driver;
    public Logger logger=Logger.getLogger(CourseHandle.class);
    public CourseHandle(WebDriver driver){
        this.driver=driver;
        coursePage=new CoursePage(driver);
    }

//    点击添加购物车
    public void ClickAddCart(){
        coursePage.GetAddCartElement().click();
    }
//    点击立即购买
    public void ClickBuyNow(){
        coursePage.GetBuyElement().click();
    }

//    点击模态框继续逛逛按钮
    public void ClickCartSure(){
        coursePage.GetCartSureElement().click();
    }
//    点击右上角购物车按钮
    public void ClickCart(){
        coursePage.GetCartElement().click();
    }
//    获取购物车商品数量
    public int GetCatrNum(){
        int CartNum;
        try {
            CartNum=Integer.parseInt(coursePage.GetCartNumElement().getText());
        }catch (Exception e){
            CartNum=0;
        }
        return CartNum;

    }
//    注入cookie
    public void SetCookie(){
        String apsid="UwZjMzNTZkNDk1YzM3YjBiYjliY2U4MDg3OWQ4MzUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANzE5MDQxNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA2MjU3MDcxMjdAcXEuY29tAAAAAAAAAAAAAAAAAAAAADU2YWI3ZDZlM2E2YjI3NTY1NjUwN2I4NGRjZDc2NTczvL%2BKXjmlgF4%3DYm";
        driver.manage().deleteAllCookies();
        Cookie cookie1=new Cookie("apsid",apsid,".imooc.com","/",null);
        driver.manage().addCookie(cookie1);
    }
//    获取title
    public String GetCourseTitle(){
        return driver.getTitle();
    }

}
