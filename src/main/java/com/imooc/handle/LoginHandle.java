package com.imooc.handle;

import com.imooc.page.BasePage;
import com.imooc.page.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginHandle extends BaseHandle{
    public LoginPage loginPage;
    public Logger logger=Logger.getLogger(LoginHandle.class);
    public LoginHandle(WebDriver driver){
        super(driver);
        loginPage=new LoginPage(driver);
    }

    public void SendEmail(String email){
        logger.debug("你输入的账号为："+email);
        loginPage.GetEmailElement().sendKeys(email);
    }

    public void SendPassword(String password){
        logger.debug("你输入的密码为："+password);
        loginPage.GetPasswordElement().sendKeys(password);
    }

    public void ClickSenvenBox(){
        ClickElement(loginPage.GetSenvenElement());
    }

    public void ClickLogin(){
        logger.debug("你开始点击登录");
        ClickElement(loginPage.GetLoginElement());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String GetUserText(){
        loginPage.MoveToElement(loginPage.GetUserPngElement());
        return loginPage.GetUserInfoElement().getText();
    }

    public void ClickSigninButon(){
        ClickElement(loginPage.GetSigninElement());
    }
}
