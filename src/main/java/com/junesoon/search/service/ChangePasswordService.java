package com.junesoon.search.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.junesoon.search.entity.TabNewpassMail;
import com.junesoon.search.entity.TabNewpassMailDAO;
import com.junesoon.search.entity.TabUserinfoBase;
import com.junesoon.search.entity.TabUserinfoBaseDAO;

@Transactional
public class ChangePasswordService extends HibernateDaoSupport {

	@Resource
	SessionFactory sessionFactory;
	
	private static final Logger log = LoggerFactory
			.getLogger(ChangePasswordService.class);

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	TabUserinfoBaseDAO userinfoBaseDAO = TabUserinfoBaseDAO
			.getFromApplicationContext(context);
	TabNewpassMailDAO newpassMailDAO= TabNewpassMailDAO.getFromApplicationContext(context);
	/**
	 * ͨ���ʼ���ַ��ȡ�û���Ϣ
	 * @param mailString
	 * @return �û���Ϣ��
	 */
	public Object findByMail(String mailString){
		@SuppressWarnings("unchecked")
		List<Object> list=userinfoBaseDAO.findByEmail(mailString);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * ���������Ϣ��
	 * @param newpassMail
	 * @throws Exception 
	 */
	public void inser(TabNewpassMail newpassMail) throws Exception{
		try {
			newpassMailDAO.save(newpassMail);
		} catch (Exception e) {
			log.error("save failed", e);
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * ��ȡ������Ϣ��
	 * @return ��Ϣ�������
	 * @throws Exception 
	 */
	public TabNewpassMail readInfo(String idString) throws Exception{
		try {
			return newpassMailDAO.findById(idString);
		} catch (Exception e) {
			log.error("read failed", e);
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * ͨ��ID��ȡ�û���Ϣ
	 * @param IDString
	 * @return �û���Ϣ��
	 * @throws Exception 
	 */
	public TabUserinfoBase findByID(String idString) throws Exception{
		
		try {
			return userinfoBaseDAO.findById(idString);
		} catch (Exception e) {
			log.error("read failed", e);
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * ��������
	 * @param tabUserinfoBase
	 * @return �ɹ���true,ʧ�ܣ�false
	 * @throws Exception 
	 */
	public boolean uodateUserInfo(TabUserinfoBase tabUserinfoBase) throws Exception{
		try {
			userinfoBaseDAO.save(tabUserinfoBase);
			return true;
		} catch (Exception e) {
			log.error("update failed", e);
			e.printStackTrace();
			throw e;
		}
	}
}
