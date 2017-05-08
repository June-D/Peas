package com.junesoon.search.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.junesoon.search.entity.TabNewuserMail;
import com.junesoon.search.entity.TabNewuserMailDAO;
import com.junesoon.search.entity.TabUserinfoBase;
import com.junesoon.search.entity.TabUserinfoBaseDAO;

@Transactional
public class RegtionService extends HibernateDaoSupport {

	private static final Logger log = LoggerFactory
			.getLogger(RegtionService.class);
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	TabUserinfoBaseDAO userinfoBaseDAO = TabUserinfoBaseDAO
			.getFromApplicationContext(context);
	TabNewuserMailDAO newuserMailDAO = TabNewuserMailDAO
			.getFromApplicationContext(context);

	/**
	 * �ж��û��Ƿ����
	 * 
	 * @param username
	 * @return ���ڣ�true �����ڣ�false
	 * @throws Exception 
	 */
	public boolean getUser(String username) throws Exception {

		TabUserinfoBase userinfoBase=null;
		try {
			userinfoBase= userinfoBaseDAO.findById(username);
			if (userinfoBase != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * ��ȡ�û���Ϣ
	 * 
	 * @param username
	 * @return �û���Ϣ
	 * @throws Exception 
	 */
	public TabUserinfoBase getUserInfoByName(String username) throws Exception {

		TabUserinfoBase userinfoBase=null;
		try {
			userinfoBase= userinfoBaseDAO.findById(username);
			return userinfoBase;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * �洢�û���ʱ��Ϣ
	 * 
	 * @param newuserMail
	 * @throws Exception 
	 */
	public void remberUser(TabNewuserMail newuserMail) throws Exception {
		try {
			newuserMailDAO.save(newuserMail);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * ȡ���û���ʱ��Ϣ
	 * 
	 * @param idString
	 * @return �û���ʱ��Ϣ
	 * @throws Exception 
	 */
	public TabNewuserMail getOutUserInfo(String idString) throws Exception {
		TabNewuserMail newuserMail=null;
		try {
			newuserMail=newuserMailDAO.findById(idString);
			return newuserMail;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * ¼���û���Ϣ
	 * 
	 * @param userinfoBase
	 * @return �û���Ϣ
	 * @throws Exception 
	 */
	public void inserUser(TabUserinfoBase userinfoBase) throws Exception {
		try {
			userinfoBaseDAO.save(userinfoBase);
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * �����û���Ϣ
	 * 
	 * @param userinfoBase
	 * @return �û���Ϣ
	 * @throws Exception 
	 */
	public Object updateUserName(TabUserinfoBase userinfoBase) throws Exception {
		try {
			userinfoBaseDAO.save(userinfoBase);
			return userinfoBase;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * ��ȡ�ʼ���ַ
	 * @param mailString
	 * @return ʹ�ø��ʼ���ַ���û���Ϣ
	 * @throws Exception 
	 */
	public TabUserinfoBase getByMail(String mailString) throws Exception{
		TabUserinfoBase userinfoBase=null;
		try {
			
			List list=userinfoBaseDAO.findByProperty("email", mailString);
			if(list!=null&&list.size()>0){
				userinfoBase=(TabUserinfoBase) list.get(0);
			}
			return userinfoBase;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
}
