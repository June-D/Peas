package com.junesoon.search.logic;

import java.sql.Timestamp;
import java.util.Properties;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.junesoon.search.entity.TabNewuserMail;
import com.junesoon.search.entity.TabUserinfoBase;
import com.junesoon.search.form.RegtionForm;
import com.junesoon.search.service.RegtionService;
import com.junesoon.search.util.EncryptUtil;
import com.junesoon.search.util.ReadPropertiesUtil;

/**
 * ע���߼���
 * 
 * @author NDNW
 * 
 */
public class RegtionLogic {

	private static final Logger log = LoggerFactory
			.getLogger(RegtionLogic.class);
	@Resource
	RegtionService regtionService = new RegtionService();
	@Resource
	ReadPropertiesUtil propertiesUtil = new ReadPropertiesUtil();
	Properties properties = propertiesUtil
			.getProperties("/application.properties");

	/**
	 * ��֤�û��Ƿ���ڣ�
	 * 
	 * @param regtionForm
	 * @return ���ڣ�true �����ڣ�false
	 * @throws Exception 
	 */
	public boolean existUser(RegtionForm regtionForm) throws Exception {
		String userName = regtionForm.getUserName();
		// У���û��Ƿ����
		boolean b;
		try {
			b = regtionService.getUser(userName);
			return b;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * �û���Ϣ������ʱ��
	 * 
	 * @param regtionForm
	 * @return ID
	 * @throws Exception 
	 */
	public String remberUserInfo(RegtionForm regtionForm) throws Exception {
		// �û���
		String userNameString = regtionForm.getUserName();
		// ����ʱ��
		Timestamp createTime = new Timestamp(System.currentTimeMillis());
		// �������ļ��ж�ȡ����ʱ��
		String pastkey = properties.getProperty("PASTTIME");
		Integer outTimeInteger = Integer.parseInt(pastkey);
		// ʧЧʱ��
		Timestamp pastTime = new Timestamp(System.currentTimeMillis() + 1000
				* 60 * 60 * outTimeInteger);
		// ����ID
		String userIDString = userNameString + System.currentTimeMillis();
		String idString = EncryptUtil.MD5Encode(userIDString);
		// ������ʱ��
		TabNewuserMail newuserMail = new TabNewuserMail(idString,
				userNameString, createTime, pastTime);
		try {
			regtionService.remberUser(newuserMail);
			// ������ʱID
			return idString;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * ��֤�ʼ��Ƿ����
	 * 
	 * @param idString
	 * @return �û���
	 * @throws Exception 
	 */
	public String getOutUserInfo(String idString) throws Exception {
		TabNewuserMail newuserMail = null;
		try {
			newuserMail = regtionService.getOutUserInfo(idString);
			if (newuserMail == null) {
				return null;
			} else {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				if (timestamp.before(newuserMail.getPasttime())) {
					return newuserMail.getUserName();
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * ���û���Ϣ������ʽ��
	 * 
	 * @param regtionForm
	 * @return �û���Ϣ
	 * @throws Exception 
	 */
	public TabUserinfoBase regtion(RegtionForm regtionForm, String flag) throws Exception {

		String userName = regtionForm.getUserName();

		String password = regtionForm.getPassword();
		// ���������
		password = EncryptUtil.MD5Encode(password);
		// ��ȡ�����ļ���ȡ�ü�����Կ
		String key = properties.getProperty("DESKEY");
		// ���������
		String email = regtionForm.getEmail();
		email = EncryptUtil.encrypt(email, key);
		// д��ע��ʱ��͵�¼ʱ��
		Timestamp createTime = new Timestamp(System.currentTimeMillis());
		Timestamp lastLoginTime = new Timestamp(System.currentTimeMillis());
		TabUserinfoBase userinfoBase = new TabUserinfoBase(userName, password,
				email, createTime, lastLoginTime, flag);
		// ���÷����
		try {
			regtionService.inserUser(userinfoBase);
			return userinfoBase;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * �����û���Ϣ
	 * 
	 * @param userName
	 * @return �û���Ϣ
	 * @throws Exception 
	 */
	public TabUserinfoBase updateUserInfo(String userName) throws Exception {
		TabUserinfoBase userinfoBase = regtionService
				.getUserInfoByName(userName);
		userinfoBase.setUserFlag("1");
		try {
			regtionService.updateUserName(userinfoBase);
			return userinfoBase;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * ����ʼ���ַ�Ƿ��Ѿ�����
	 * 
	 * @param mailString
	 * @return ���ڣ� true �����ڣ�false
	 * @throws Exception 
	 */
	public boolean checkMailAddress(String mailString) throws Exception {
		// ��ȡ�����ļ���ȡ�ü�����Կ
		String key = properties.getProperty("DESKEY");
		mailString = EncryptUtil.encrypt(mailString, key);
		TabUserinfoBase userinfoBase = null;
		try {
			userinfoBase = regtionService.getByMail(mailString);
			if (userinfoBase == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}
}
