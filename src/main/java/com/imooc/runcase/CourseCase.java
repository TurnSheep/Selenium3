package com.imooc.runcase;

import com.imooc.handle.CourseHandle;
import com.imooc.web.TestngListenerScrenn;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners({TestngListenerScrenn.class})
public class CourseCase extends BaseCase{
    public WebDriver driver;
    public Logger logger=Logger.getLogger(CourseCase.class);
    public CourseHandle courseHandle;
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
        courseHandle=new CourseHandle(driver);

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

//    enabled = false  可跳过执行改case
    @Parameters({"coursename"})
    @Test(groups = "sucess")
    public void TestAleradyAdd(String coursename) throws InterruptedException {
        int  a=0;
        String course_title=courseHandle.GetTitle();
        boolean flag=course_title.contains(coursename);
        Assert.assertEquals(true,flag);
        courseHandle.SetCookie();
        driver.navigate().refresh();
        Thread.sleep(2000);
        int before_number=courseHandle.GetCatrNum();
        System.out.println(before_number);
        courseHandle.ClickAddCart();
        Thread.sleep(2000);
        int after_number=courseHandle.GetCatrNum();
        System.out.println(after_number);
        a=after_number-before_number;
        System.out.println("打印a:"+a);
        Assert.assertEquals(a,1);
    }

    @Test(groups = "error")
    public void TestAleradyBuy() throws InterruptedException {
        courseHandle.ClickAddCart();
        Thread.sleep(2000);
        courseHandle.ClickCartSure();
        Thread.sleep(2000);
    }

    @Test(groups = "error")
    public void TestAleradyLogin() throws InterruptedException {
        courseHandle.ClickBuyNow();
        Thread.sleep(2000);
    }

}
