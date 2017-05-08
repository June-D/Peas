package com.junesoon.search.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * ��̬��ȡsrc·���µ�properties�ļ�
 * @author NDNW
 *
 */
public class ReadPropertiesUtil {

	/**
	 * ��̬��ȡsrc·���µ�properties�ļ�
	 * @param string
	 * @return properties����
	 */
	public  Properties getProperties(String string) {
		Properties properties=new Properties();
		InputStream inputStream = this.getClass().getResourceAsStream(string);
		try {
			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
