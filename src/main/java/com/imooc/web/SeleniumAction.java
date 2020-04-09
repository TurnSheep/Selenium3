package com.imooc.web;

import org.omg.SendingContext.RunTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumAction {
    public static WebDriver driver;

    public void lnitDrier(){
        driver =new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005/");
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//    登陆
    public void InputElement(){
//        输入框
        WebElement EmailElement=driver.findElement(By.name("email"));
//        String UserInfo=EmailElement.getAttribute("placeholder");//获取属性值
        EmailElement.sendKeys("625707127@qq.com");//输入用户名
        driver.findElement(By.className("js-loginPassword")).sendKeys("5211314hzy....");//输入密码
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        EmailElement.clear();//清除当前输入框信息
        driver.findElement(By.className("moco-btn-red")).click();//点击登录
//        System.out.println(UserInfo);
//        String Mobile=EmailElement.getAttribute("value");//获取当前输入框值
//        System.out.println(Mobile);
//        boolean info=EmailElement.isEnabled();//让不可编辑输入框变可编辑，js控制
//        System.out.println(info);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        driver.close();
    }

//    单选框选中
    public void Radio(){
        driver.get("https://www.imooc.com/user/setprofile");//跳转至个人信息页面
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("js-edit-info")).click();//点击编辑
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement UserFrom=driver.findElement(By.id("profile"));//定位最外层的元素，在外层的元素下寻找最终元素
        List<WebElement> SexList=UserFrom.findElements(By.name("sex"));//寻找sex list集合

        for (WebElement sex:SexList) {//遍历sex所有元素
            if(sex.isSelected()){//判断该元素是否被选中，选择则跳过，否则直接点击
                break;
            }else {
                sex.click();//没有被选中的直接点击
            }
        }
//        List<WebElement> SexList=driver.findElements(By.name("sex"));//单选框进行list取值
//        SexList.get(1).click();//index定位点击

    }
//    判断元素是否可用或选中
    public void CheckBox(){
        WebElement Box=driver.findElement(By.id("auto-signin"));
        System.out.println(Box.isEnabled());//判断是否可用
        System.out.println(Box.isSelected());//判断是否被选中
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Box.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

//    登陆界面修改属性
    public void Button(){

        WebElement ButtonElement=driver.findElement(By.className("moco-btn-red"));//点击登录
        System.out.println(ButtonElement.isDisplayed());//是否显示
        System.out.println(ButtonElement.isEnabled());//是否可用
        String JsString="document.getElementsByClassName(\'moco-btn-red\')[0].style.disploy=\'None\';";//清除页面button的js语句，变成不显示isDisplayed
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript(JsString);
        WebElement ButtonElement1=driver.findElement(By.className("moco-btn-red"));//点击登录
        System.out.println(ButtonElement.isDisplayed());//是否显示
        System.out.println(ButtonElement1.isEnabled());//是否可用
        driver.close();
    }

//    上传头像

    public void UpFile(){
        driver.get("https://www.imooc.com/user/setbindsns");
        WebElement HeadPng=driver.findElement(By.className("avator-img"));//定位到头像框属性
        Actions actions=new Actions(driver);//new一个Actions对象，应用于调用类中的方法
        actions.moveToElement(HeadPng).perform();//鼠标移动到头像，进行提交操作
        driver.findElement(By.className("update-avator")).click();
        driver.findElement(By.id("upload")).sendKeys("C:\\Users\\Administrator\\Desktop\\1.png");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();

    }


//    使用AutoIt上传图片
    public void UpFile_01(){
        driver.get("https://www.imooc.com/user/setbindsns");
        WebElement HeadPng=driver.findElement(By.className("avator-img"));//定位到头像框属性
        Actions actions=new Actions(driver);//new一个Actions对象，应用于调用类中的方法
        actions.moveToElement(HeadPng).perform();//鼠标移动到头像，进行提交操作
        driver.findElement(By.className("update-avator")).click();//更改头像
        driver.findElement(By.className("avator-btn-fake")).click();//点击上传头像
        try {
            Runtime.getRuntime().exec("E:\\IdeaWork\\Java\\UIAutomation\\Imooc.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //    使用Robot上传图片
    public void UpFileOne() throws AWTException {
        driver.get("https://www.imooc.com/user/setbindsns");
        WebElement HeadPng=driver.findElement(By.className("avator-img"));//定位到头像框属性
        Actions actions=new Actions(driver);//new一个Actions对象，应用于调用类中的方法
        actions.moveToElement(HeadPng).perform();//鼠标移动到头像，进行提交操作
        driver.findElement(By.className("update-avator")).click();//更改头像
        driver.findElement(By.className("avator-btn-fake")).click();//点击上传头像
//        driver.findElement(By.id("upload")).sendKeys("C:\\Users\\Administrator\\Desktop\\1.png");
        StringSelection selectpng=new StringSelection("C:\\Users\\Administrator\\Desktop\\1.png");
        Clipboard syc=Toolkit.getDefaultToolkit().getSystemClipboard();
        syc.setContents(selectpng,null);
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        //按下ctrl+V
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
//        释放ctrl+V
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        robot.keyPress(KeyEvent.VK_ENTER);
        //按下Enter键
        robot.keyRelease(KeyEvent.VK_ENTER);
        //释放Enter键
    }

//    提交From表单,通过submit方式
    public void WebFrom(){
        WebElement EmailElement=driver.findElement(By.name("email"));
        EmailElement.sendKeys("625707127@qq.com");//输入用户名
        driver.findElement(By.className("js-loginPassword")).sendKeys("5211314hzy....");//输入密码
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("signup-form")).submit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

//    选择下拉列表-下拉框定位
    public void SelectOptions(){
        driver.get("https://www.imooc.com/user/setprofile");//跳转至个人信息页面
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("js-edit-info")).click();//点击编辑
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement UserFrom=driver.findElement(By.id("profile"));//定位最外层的元素，在外层的元素下寻找最终元素
        UserFrom.findElement(By.id("job")).click();
        List<WebElement> JobList=UserFrom.findElements(By.tagName("option"));
        JobList.get(5).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();


    }

//    selenium自带选择方法，选取下拉列表
    public void SelectOptionsSelenium() throws InterruptedException {
        driver.get("https://www.imooc.com/user/setprofile");//跳转至个人信息页面
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("js-edit-info")).click();//点击编辑
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement UserFrom=driver.findElement(By.id("profile"));//定位最外层的元素，在外层的元素下寻找最终元素
        WebElement job=UserFrom.findElement(By.id("job"));
        Select DowmList=new Select(job);
        DowmList.selectByIndex(5);//通过index选取
        Thread.sleep(5000);
        DowmList.selectByValue("1");//通过Value
        Thread.sleep(5000);
        DowmList.selectByVisibleText("JS工程师");//通过属性值
        Thread.sleep(2000);
        System.out.println(DowmList.isMultiple());//判断下拉列表是否是多选
//        DowmList.deselectByVisibleText("JS工程师");//不选择这个属性值---针对多选下拉列表
        Thread.sleep(2000);
        List<WebElement> SelectOptionsOne=DowmList.getAllSelectedOptions();
        for (WebElement option:SelectOptionsOne) {
            System.out.println(option.getText());
        }

        driver.close();
    }


//    鼠标事件
    public void MoseAction() throws InterruptedException {
//        driver.get("https://www.imooc.com/");
//        WebElement LoginElement=driver.findElement(By.id("js-signin-btn"));
        Actions MoseActions=new Actions(driver);
//        MoseActions.click(LoginElement).perform();//鼠标左击
        Thread.sleep(2000);
        driver.get("https://www.imooc.com/");
        List<WebElement> MenElementList=driver.findElements(By.className("item"));
        WebElement MobileElement=MenElementList.get(1);
        MoseActions.moveToElement(MobileElement).perform();//鼠标移动
        driver.findElement(By.linkText("小程序")).click();
        Thread.sleep(2000);
//        driver.close();

//        MoseActions.contextClick(LoginElement).perform();//鼠标右击
//        MoseActions.doubleClick(LoginElement).perform();//鼠标双击
//        MoseActions.moveToElement(LoginElement).perform();
    }

    public void SwitchIframe() throws InterruptedException {
        driver.get("https://www.imooc.com/article/publish#");
        try {
            driver.findElement(By.id("ueditor_0")).sendKeys("625707127@qq.com");
        }catch (Exception e){
            System.out.println("定位错误");
        }

        WebElement IframeElement=driver.findElement(By.id("ueditor_0"));
        driver.switchTo().frame(IframeElement);
        WebElement Ueditor=driver.findElement(By.tagName("p"));
        Actions MoseActions=new Actions(driver);
//        MoseActions.moveToElement(Ueditor).click().sendKeys("This is Test1").perform();//iframe嵌套，获取焦点进行输入
        MoseActions.moveToElement(Ueditor).perform();//鼠标移动
        Ueditor.click();//点击获取焦点
        Ueditor.sendKeys("Test2");//进行输入

        Thread.sleep(2000);
        driver.close();
    }

    public void WindowsHandle() throws InterruptedException {

        Set<String> Handles=driver.getWindowHandles();
        String CurlHandle=driver.getWindowHandle();
        for (String s:Handles) {
            if (s.equals(CurlHandle)){
                continue;
            }else {
                driver.switchTo().window(s);
            }
        }
        List<WebElement> szList=driver.findElements(By.className("shizan-name"));
        szList.get(1).click();
        Thread.sleep(2000);
        driver.close();
    }

    public void AlertWindows(){
//        处理只有一个确定的弹框
        driver.findElement(By.id("弹窗")).click();
        driver.switchTo().alert().accept();
//        处理确认或取消的弹窗
        driver.findElement(By.id("确定或取消")).click();
        driver.switchTo().alert().accept();//确定
//        处理确认或取消的弹窗
        driver.navigate().refresh();//刷新当前页面
        driver.findElement(By.id("确定或取消")).click();
        driver.switchTo().alert().dismiss();//取消
//        带输入框的弹窗
        driver.navigate().refresh();//刷新当前页面
        driver.findElement(By.id("输入框弹窗")).click();
        driver.switchTo().alert().sendKeys("直接输入内容");
        driver.switchTo().alert().accept();//输入完内容后，点击确认
    }

    public void Wait() throws InterruptedException {
//        强制等待
        Thread.sleep(2000);
//        隐式等待-全局等待20S,等待页面加载完成后才去点击元素
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        显示等待
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement ts=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));//找到返回是一个webElement对象，可操作
    }
    public static void main(String[]args) throws AWTException, InterruptedException {
        SeleniumAction seleniumAction=new SeleniumAction();
        seleniumAction.lnitDrier();
//        seleniumAction.InputElement();
//        seleniumAction.Radio();
//        seleniumAction.CheckBox();
//        seleniumAction.Button();
//        seleniumAction.UpFile();
//        seleniumAction.UpFile_01();
//        seleniumAction.WebFrom();
//        seleniumAction.SelectOptions();
//        seleniumAction.UpFileOne();
//        seleniumAction.SelectOptionsSelenium();
        seleniumAction.MoseAction();
//        seleniumAction.SwitchIframe();
//        seleniumAction.WindowsHandle();
        seleniumAction.WindowsHandle();

    }
}
