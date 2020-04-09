package com.imooc.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {
    public Properties pro;
    public ProUtil(){}
    public ProUtil(String FilePath) {
        pro=this.ReadProperties( FilePath);
    }
    private Properties ReadProperties(String FilePath)  {
        Properties properties=new Properties();
//        String path1=ProUtil.class.getClassLoader().getResource("Element.properties").getPath();//ClassLoader.getResource()的资源获取不能以 / 开头，统一从根路径开始搜索资源
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(FilePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        try {
            properties.load(bufferedInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String GetPro(String key){
        if (pro.containsKey(key)){
            return pro.getProperty(key);
        }else {
            return "未找到对应的Key值";
        }

    }

//    获取配置文件行数
    public int GetLines(){
        return pro.size();
    }

//    public String SplitString(String s,int index) throws IOException {
//        String path1=ProUtil.class.getClassLoader().getResource("Element.properties").getPath();//ClassLoader.getResource()的资源获取不能以 / 开头，统一从根路径开始搜索资源
//        ProUtil proUtil=new ProUtil(path1);
//        String str=proUtil.GetPro(s);
//        String[] strArr = str.split(">");
//        return strArr[index];
//    }

    public static void main(String[] args) throws IOException {
        ProUtil proUtil=new ProUtil();
//        System.out.println(proUtil.SplitString("username",1));
    }
}
