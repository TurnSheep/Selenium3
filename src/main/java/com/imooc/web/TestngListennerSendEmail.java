package com.imooc.web;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.testng.IExecutionListener;

public class TestngListennerSendEmail implements IExecutionListener {
    public void onExecutionStart() {

    }

//    监听等待所有case执行完毕后，发送邮件
    public void onExecutionFinish() {
        HtmlEmail htmlEmail=new HtmlEmail();
        htmlEmail.setHostName("smtp.163.com");
        htmlEmail.setAuthentication("zhongyang_he@163.com","ZEYWASIHMAJBSQBH");
        try {
            htmlEmail.setFrom("zhongyang_he@163.com");
            htmlEmail.addTo("625707127@qq.com");
            htmlEmail.setSubject("Selenium sub jet");
            htmlEmail.setCharset("UTF-8");
            htmlEmail.setMsg("<a href=\"\"");
            EmailAttachment emailAttachment=new EmailAttachment();
            emailAttachment.setPath("");
            emailAttachment.setName("UI自动化测试报告.html");
            emailAttachment.setDescription(EmailAttachment.ATTACHMENT);
            htmlEmail.attach(emailAttachment);
            htmlEmail.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
