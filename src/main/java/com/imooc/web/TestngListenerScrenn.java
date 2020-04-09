package com.imooc.web;

import com.google.common.io.Files;
import com.imooc.runcase.LoginCase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestngListenerScrenn extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult var1) {
        super.onTestSuccess(var1);
    }

    @Override
    public void onTestFailure(ITestResult var1) {
        LoginCase tc=(LoginCase)var1.getInstance();
        WebDriver driver=tc.driver;
        this.TakeScreenShot(driver);
        super.onTestFailure(var1);
    }

    //        保存图片
    public void TakeScreenShot(WebDriver driver){
//        图片名字
//        图片保存的路径
//        获取当前的时间
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String CurTime=simpleDateFormat.format(new Date());
//       获取当前类名
        String curClassName=this.getClass().getName();
        System.out.println(curClassName);
        String pngPath=curClassName+"_"+CurTime+".png";
//        保存路径
        String curPath=System.getProperty("user.dir");
        File ScrFile=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(ScrFile,new File(curPath+"\\"+pngPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


