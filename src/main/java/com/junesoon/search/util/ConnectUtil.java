package com.junesoon.search.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectUtil {
	
	private static List<Connection> pools=new ArrayList<Connection>();

	private static Connection DBconnection = null;

	static {
		
		//��ȡ�����ļ�
		Properties properties=new Properties();
		
		try {
			properties.load(ConnectUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e1) {
			System.out.println("δ�ҵ�jdbc�����ļ���");
			e1.printStackTrace();
		}
		
		String driverString=properties.getProperty("jdbc.driver");
		String urlString=properties.getProperty("jdbc.url");
		String nameString=properties.getProperty("jdbc.username");
		String passwordString=properties.getProperty("jdbc.password");
		String numString=properties.getProperty("nums");
		int nums=Integer.parseInt(numString);
		try {
			Class.forName(driverString);
		} catch (ClassNotFoundException e) {
			System.err.println("�������ݿ���������ʱ����");
			e.printStackTrace();
		}
		try {
			for(int i=0;i<nums;i++ ){
				DBconnection = DriverManager.getConnection(urlString, nameString,
						passwordString);
				pools.add(DBconnection);
			}
			
		} catch (SQLException e) {
			System.out.println("�û������������");
			e.printStackTrace();
		}
	}
	public static Connection getDBConnect(){
		if(pools.size()==0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return getDBConnect();
		}
		else {
			Connection connection=pools.remove(0);
			return connection;
		}		
	}
	public static void addCon(Connection con) {
		pools.add(con);
	}
}