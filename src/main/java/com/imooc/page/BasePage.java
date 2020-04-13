package com.imooc.page;

import com.imooc.util.ProUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;


public class BasePage {
    public  WebDriver driver;
    public Logger logger=Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    //    封装定位
    public By GetByLocal(String Key)  {
        String path1= ProUtil.class.getClassLoader()
                .getResource("Element.properties").getPath();//ClassLoader.getResource()的资源获取不能以 / 开头，统一从根路径开始搜索资源
        ProUtil pro=new ProUtil(path1);
        logger.debug("你的定位信息为"+Key);
        String LocatorBy=pro.GetPro(Key).split(">")[0];
        String LocatorValue=pro.GetPro(Key).split(">")[1];
        logger.debug("你的定位方式为"+LocatorBy);
        logger.debug("你的定位值为"+LocatorValue);
        if (LocatorBy.equals("id")){
            return By.id(LocatorValue);
        }
        else if(LocatorBy.equals("name")){
            return By.name(LocatorValue);
        }
        else if(LocatorBy.equals("className")){
            return By.className(LocatorValue);
        }else {
            return By.xpath(LocatorValue);
        }
    }

//    封装移动鼠标操作
    public void MoveToElement(WebElement ToElement){
        Actions MoseActions=new Actions(driver);
        MoseActions.moveToElement(ToElement).perform();
    }
//    封装Element
    public WebElement GetElement(String Key)  {
        WebElement Element=driver.findElement(this.GetByLocal(Key));
        return Element;
    }
//    封装获取cookle操作
    public boolean GetCookie(String key){
        boolean flag=false;
        Set<Cookie> cookies=driver.manage().getCookies();
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals(key)){
                flag=true;
            }
        }
        return flag;
    }
}
