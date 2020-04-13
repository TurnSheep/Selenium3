package com.imooc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage extends BasePage{

    public CoursePage(WebDriver driver) {
        super(driver);
    }

//    添加购物车按钮
    public WebElement GetAddCartElement(){
        return GetElement("add_cart");
    }
//    立即购买按钮
    public WebElement GetBuyElement(){
        return GetElement("buy_Now");
    }
//    购物车数量
    public WebElement GetCartNumElement(){
        return GetElement("cart_num");
    }
//    右上角购物车按钮
    public WebElement GetCartElement(){
        return GetElement("cart");
    }
//    模态框商品重复继续逛逛按钮
    public WebElement GetCartSureElement(){
        return GetElement("cart_already");
    }

//    获取登录状态信息
    public boolean GetUserlsLogin(){
        return GetCookie("apsid");
    }


}
