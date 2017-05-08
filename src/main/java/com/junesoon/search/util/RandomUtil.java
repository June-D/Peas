package com.junesoon.search.util;

import java.util.Date;
import java.util.Random;

/**
 * �������������
 * @author NDNW��
 *
 */
public class RandomUtil {
	
	
	/**
	 * ���������������
	 * @param num ��ֵ��
	 * @return �������������
	 */
	public static int randomInt(int num) {
		
		Date date=new Date();
		
		long sysTime=date.getTime()*2-9;
		
		Random random= new Random();
		
		random.setSeed(sysTime);
		
		int result=random.nextInt(num);
		
		return  result;
	}
	
}
