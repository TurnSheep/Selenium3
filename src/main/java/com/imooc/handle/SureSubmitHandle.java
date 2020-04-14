package com.imooc.handle;


import com.imooc.page.BasePage;
import com.imooc.page.SureSubmitPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SureSubmitHandle extends BaseHandle {
    public SureSubmitPage submitPage;
    public Logger logger=Logger.getLogger(CourseHandle.class);
    public SureSubmitHandle(WebDriver driver){
        super(driver);
        submitPage=new SureSubmitPage(driver);
    }

    public void ClickSureSubmitElement(){
//        点击提交订单按钮
        ClickElement(submitPage.GetSureSubmitElement());
    }

}
