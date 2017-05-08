package com.junesoon.search.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ַ��������ࡣ
 * 
 * @author NDNW��
 * 
 */
public class StringUtil {

	/**
	 * ��֤�ַ����Ƿ�Ϊ�ա�
	 * 
	 * @param str
	 *            ��У���ַ���
	 * @return �� ����true��
	 */
	public static boolean IfstrNull(String str) {

		if ("".equals(str) || str == null) {
			return true;
		}

		return false;

	}

	/**
	 * ��֤�����ʽ��
	 * @param mailString
	 * @return ��֤��� ��ȷ��true,����false��
	 */
	public static boolean IfmatchMail(String mailString) {

		boolean result = false;

		try {
			//"^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"
			String matchString = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

			Pattern regex = Pattern.compile(matchString);

			Matcher matcher = regex.matcher(mailString);

			result = matcher.matches();

		} catch (Exception e) {

			e.printStackTrace();

			result = false;
		}

		return result;
	}

	/**
	 * 
	 * ��֤�ֻ�����
	 * 
	 * @param mobiles
	 * 
	 * @return ��֤�����
	 */

	public static boolean checkMobileNumber(String mobileNumber) {

		boolean flag = false;

		try {

			Pattern regex = Pattern
					.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");

			Matcher matcher = regex.matcher(mobileNumber);

			flag = matcher.matches();

		} catch (Exception e) {

			flag = false;

		}

		return flag;

	}

}
