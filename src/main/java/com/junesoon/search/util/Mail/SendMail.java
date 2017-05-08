package com.junesoon.search.util.Mail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import com.junesoon.search.util.ReadPropertiesUtil;

public class SendMail {

	/**
	 * �����ʼ���������
	 * @param toAddress ���͵�ַ
	 * @param subject �ʼ�����
	 * @param mailTemplate �ʼ�ģ��
	 * @return true:���ͳɹ� false:����ʧ��
	 */
	@SuppressWarnings({ "resource", "static-access" })
	public static boolean send(String toAddress, String subject,
			String mailTemplate) {
		// ��ȡ�����ļ�
		ReadPropertiesUtil propertiesUtil = new ReadPropertiesUtil();
		Properties properties = propertiesUtil
				.getProperties("/application.properties");
		// �ʼ�������IP
		String MailServerHost = properties.getProperty("MailServerHost");
		// �ʼ���������ַ
		String MailServerPort = properties.getProperty("MailServerPort");
		// �ʼ��Ƿ���Ҫ��֤
		boolean MailValidate = false;
		if ("true".equals(properties.getProperty("MailValidate"))) {
			MailValidate = true;
		}
		// �û���
		String MailUserName = properties.getProperty("MailUserName");
		// ����
		String MailPassword = properties.getProperty("MailPassword");
		// ���͵�ַ
		String FromAddress = properties.getProperty("FromAddress");
		// �������Ҫ�������ʼ�
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(MailServerHost);
		mailInfo.setMailServerPort(MailServerPort);
		mailInfo.setValidate(MailValidate);
		mailInfo.setUserName(MailUserName);
		mailInfo.setPassword(MailPassword);// ������������
		mailInfo.setFromAddress(FromAddress);
		mailInfo.setToAddress(toAddress);
		mailInfo.setSubject(subject);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(mailTemplate), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			System.err.println("�ʼ�ģ���ȡʧ��");
			e.printStackTrace();
			return false;
		} catch (FileNotFoundException e) {
			System.err.println("û���ҵ��ʼ�ģ��");
			e.printStackTrace();
			return false;
		}
		StringBuffer b = new StringBuffer();
		int len;
		try {
			while ((len = reader.read()) != -1) {
				b.append((char) len);
			}
		} catch (IOException e) {
			System.err.println("StringBuffer��ȡʧ��");
			e.printStackTrace();
			return false;
		}
		String string = b.toString();
		mailInfo.setContent(string);
		// �������Ҫ�������ʼ�
		SimpleMailSender sms = new SimpleMailSender();
		// sms.sendTextMail(mailInfo);//���������ʽ
		return sms.sendHtmlMail(mailInfo);// ����html��ʽ

	}
}
