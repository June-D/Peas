package com.junesoon.search.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil {

	private static ApplicationContext context;

	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context);
	}

	public static Session getSession() {

		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");
		if (sessionFactory != null) {
			return sessionFactory.openSession();
		} else {
			return null;
		}
	}

}
