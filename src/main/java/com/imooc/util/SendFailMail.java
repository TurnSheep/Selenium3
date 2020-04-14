package com.imooc.util;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendFailMail {
    public void SendMail(){
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
            emailAttachment.setName("测试报告.html");
            emailAttachment.setDescription(EmailAttachment.ATTACHMENT);
            htmlEmail.attach(emailAttachment);
            htmlEmail.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SendFailMail sendFailMail=new SendFailMail();
        sendFailMail.SendMail();
    }
}
