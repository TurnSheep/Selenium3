package com.imooc.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CourseList {
    public WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        driver =new ChromeDriver();
        driver.get("https://coding.imooc.com/");
        driver.manage().window().maximize();
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

//    获取的String title有空格
//    @Test
//    public void test01(){
//        List<String> listString=ListCourseTitle();
//        for (String courseName:listString) {
//            driver.findElement(By.xpath("//p[@title='"+courseName+"']")).click();
//            driver.navigate().back();//返回上一页
//        }
//    }

//    如果不在for循环中重新获取页面元素的话，页面后退，之前获取的元素不可用，所以需要重新获取元素，通过下标自增方式点击链接
    @Test
    public void test02() {
        List<Integer> numList=GetPageNum();
        for (int j=1;j<numList.size();j++){
            List<WebElement> courseList = driver.findElements(By.className("shizan-name"));
            for (int i = 0; i < courseList.size(); i++) {
                courseList.get(i).click();
                driver.navigate().back();
                driver.findElement(By.className("js-close")).click();
                courseList = driver.findElements(By.className("shizan-name"));
                System.out.println("元素:" + courseList.get(i).getText());
            }
            driver.findElement(By.partialLinkText("下一页")).click();
        }

    }

//    获取总页数
    public List<Integer> GetPageNum(){
        List<Integer> pageNumList=new ArrayList<Integer>();
        List<WebElement> aElementList=driver.findElement(By.className("page")).findElements(By.tagName("a"));
        for (WebElement aElement:aElementList) {
            String pageNum=aElement.getText();
            if(isNumber(pageNum)==true){
                pageNumList.add(Integer.valueOf(pageNum).intValue());
            }
        }
        return pageNumList;
    }


    public boolean isNumber(String pageNum){
        Pattern pattern=Pattern.compile("[0-9]");
        return pattern.matcher(pageNum).matches();
    }

    public List<String> ListCourseTitle(){
        List<String>  listCourseTitle=new ArrayList<String>();
        List<WebElement> courseList=driver.findElements(By.className("shizan-name"));
        for (WebElement courseName:courseList) {
            listCourseTitle.add(courseName.getText());
            System.out.println();
        }
        return  listCourseTitle;
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("执行beforeMethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("执行afterMethod");
    }

}
