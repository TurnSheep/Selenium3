package com.imooc.runcase;

import com.imooc.handle.LoginHandle;
import com.imooc.web.TestngListenerScrenn;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestngListenerScrenn.class})
public class LoginCase extends BaseCase{
    public WebDriver driver;
    public LoginHandle loginHandle;
    @Parameters({"url","browser"})
//    当test方法加上group时，不会执行beforeclass操作，二种操作方式可避免
//    1.@BeforeClass和@AfterClass注解的方法加上属性(alwaysRun = true)，即可正常执行。
//    2.@BeforeGroups @AfterGroups 作用于初始化操作
    @BeforeClass
    public void beforeClass(String url,String browser){
        driver =GetDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginHandle=new LoginHandle(driver);
        loginHandle.ClickSigninButon();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @AfterClass
    public void afterClass(){
        System.out.println("This is afterClass");
        driver.close();
    }

//    默认如果没有在xml中取到Parameters的值 测试方法将接受在@optional注解中指定的默认值
    @Parameters({"username","password"})
//    @Test(groups = "sucess",dependsOnMethods = {"beforeClass"})--dependsOnMethods依赖于某个方法执行,
//    dependsOnGroups依赖于某个组
    @Test
    public void TestLoginSucess(String username,String password){
        loginHandle.SendEmail(username);
        loginHandle.SendPassword(password);
//        loginHandle.ClickSenvenBox();
        loginHandle.ClickLogin();
        String userName=loginHandle.GetUserText();
        Assert.assertEquals(userName,"Y_zzzzz");
    }

    @Parameters({"username","password"})
    @Test(groups = "error")
    public void TestLoginEmailError(String username,String password){
        loginHandle.SendEmail(username);
        loginHandle.SendPassword(password);
//        loginHandle.ClickSenvenBox();
        loginHandle.ClickLogin();
        String userName=loginHandle.GetUserText();
        Assert.assertEquals(userName,username);
    }
}
