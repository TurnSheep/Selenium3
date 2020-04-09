package com.imooc.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public WebElement GetEmailElement(){
        return GetElement("username");
    }
    public WebElement GetPasswordElement(){
        return GetElement("password");
    }
    public WebElement GetSenvenElement(){
        return GetElement("senven");
    }
    public WebElement GetLoginElement(){
        return GetElement("login");
    }
    public WebElement GetUserPngElement(){
        return GetElement("UserPng");
    }
    public WebElement GetUserInfoElement(){
        return GetElement("UserInfo");
    }
    public WebElement GetSigninElement(){
        return GetElement("signin_button");
    }

}
