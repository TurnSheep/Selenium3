package com.imooc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SureSubmitPage extends BasePage{

    public SureSubmitPage(WebDriver driver) {
        super(driver);
    }

    public WebElement GetSureSubmitElement(){
        return GetElement("submit_order");
    }


}
