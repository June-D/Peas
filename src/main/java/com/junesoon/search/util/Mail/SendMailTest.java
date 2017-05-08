package com.junesoon.search.util.Mail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ws.rs.core.Application;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SendMailTest {

	public static void main(String[] args) throws IOException {
		 //�������Ҫ�������ʼ�  
	      MailSenderInfo mailInfo = new MailSenderInfo();
	      mailInfo.setMailServerHost("smtp.163.com");
	      mailInfo.setMailServerPort("25");
	      mailInfo.setValidate(true);
	      mailInfo.setUserName("15040031258@163.com");
	      mailInfo.setPassword("ZHD1258");//������������   
	      mailInfo.setFromAddress("15040031258@163.com");
	      mailInfo.setToAddress("1642510433@qq.com");
	      mailInfo.setSubject("�����ʼ�");
	      BufferedReader reader=new  BufferedReader(new InputStreamReader(new FileInputStream("WebRoot/template_mail.html"),"utf-8"));
	      StringBuffer b = new StringBuffer();
	      int len;
	         while((len =reader.read()) != -1) {
	             b.append((char)len);
	         }
	      String string= b.toString();
	      System.out.println(string);
	      mailInfo.setContent(string);
	      //�������Ҫ�������ʼ�  
	      SimpleMailSender sms = new SimpleMailSender();  
	          //sms.sendTextMail(mailInfo);//���������ʽ   
	      sms.sendHtmlMail(mailInfo);//����html��ʽ  

	}

}
