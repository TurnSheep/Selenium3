package com.imooc.runcase;

import com.imooc.handle.CourseHandle;
import com.imooc.handle.SureSubmitHandle;
import com.imooc.web.TestngListenerScrenn;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @ClassName SureSubmitCase
 * @Description 提交订单页
 * @Author zhongyang.he
 * @Date 2020/4/13 22:07
 **/

@Listeners({TestngListenerScrenn.class})
public class SureSubmitCase extends BaseCase{
    public WebDriver driver;
    public Logger logger=Logger.getLogger(CourseCase.class);
    public SureSubmitHandle submitHandle;
    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String url,String browser){
        logger.debug("初始化浏览器");
        logger.debug("打开浏览器");
        driver =GetDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitHandle=new SureSubmitHandle(driver);

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

    @Parameters({"url"})
    @Test
    public void LoginSureSubmit(String url){
        String submitTitle;
        submitHandle.SetCookie();
        driver.get(url);
        submitTitle=submitHandle.GetTitle();
        boolean flag=submitTitle.contains("确认订单");
        Assert.assertEquals(flag,true);
        submitHandle.ClickSureSubmitElement();
    }

    @Parameters({"url"})
    @Test
    public void aSureSubmit(String url){
        String submitTitle;
        driver.get(url);
        submitTitle=submitHandle.GetTitle();
        System.out.println("打印：aSureSubmit"+submitTitle);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean flag=submitTitle.contains("登陆");
        System.out.println("打印：aSureSubmit"+flag);
        Assert.assertEquals(flag,true);
    }
}
