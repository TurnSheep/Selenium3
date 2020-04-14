package com.imooc.handle;

import com.imooc.page.CoursePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CourseHandle extends BaseHandle{
    public CoursePage coursePage;
    public Logger logger=Logger.getLogger(CourseHandle.class);
    public CourseHandle(WebDriver driver){
        super(driver);
        coursePage=new CoursePage(driver);
    }


//    点击添加购物车
    public void ClickAddCart(){
        ClickElement(coursePage.GetAddCartElement());
    }
//    点击立即购买
    public void ClickBuyNow(){
        ClickElement(coursePage.GetBuyElement());
    }

//    点击模态框继续逛逛按钮
    public void ClickCartSure(){
        ClickElement(coursePage.GetCartSureElement());
    }
//    点击右上角购物车按钮
    public void ClickCart(){
        ClickElement(coursePage.GetCartElement());
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

}
