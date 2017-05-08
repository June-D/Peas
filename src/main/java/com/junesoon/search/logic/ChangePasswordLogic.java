package com.junesoon.search.logic;

import java.sql.Timestamp;
import java.util.Properties;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.junesoon.search.entity.TabNewpassMail;
import com.junesoon.search.entity.TabUserinfoBase;
import com.junesoon.search.service.ChangePasswordService;
import com.junesoon.search.util.EncryptUtil;
import com.junesoon.search.util.ReadPropertiesUtil;

/**
 * 
 * @author NDNW.
 * 
 */
public class ChangePasswordLogic {

	@Resource
	ChangePasswordService changePasswordService=new ChangePasswordService();
	@Resource
	ReadPropertiesUtil propertiesUtil = new ReadPropertiesUtil();
	Properties properties = propertiesUtil
			.getProperties("/application.properties");

	private static final Logger log = LoggerFactory
			.getLogger(ChangePasswordLogic.class);

	/**
	 * ͨ��mail��ַ��֤�û��������Ϣ�Ƿ���ȷ��
	 * 
	 * @param userName
	 * @param mail
	 * @return ��ȷ��true,����false
	 */
	public boolean checkUserInfo(String userName, String mail) {
		// ��ȡ�����ļ���ȡ�ü�����Կ
		String key = properties.getProperty("DESKEY");
		// ���ʼ���ַ���м���
		mail = EncryptUtil.encrypt(mail, key);
		// ͨ���ʼ���ַ��ȡ�û���Ϣ
		TabUserinfoBase userinfoBase = (TabUserinfoBase) changePasswordService
				.findByMail(mail);
		if (userinfoBase == null) {
			return false;
		} else {
			String username = userinfoBase.getUserName();
			if (username.equals(userName)) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * �����޸�������ʱ��.
	 * 
	 * @param userName
	 * @param mail
	 * @throws Exception 
	 */
	public String insertPassInfo(String userName, String mail) throws Exception {
		TabNewpassMail newpassMail = new TabNewpassMail();
		// ����ID
		String idString = EncryptUtil.MD5Encode(userName
				+ System.currentTimeMillis());
		// ����ʱ��
		Timestamp createTime = new Timestamp(System.currentTimeMillis());
		// �������ļ��ж�ȡ����ʱ��
		String pastkey = properties.getProperty("PASTTIME");
		Integer outTimeInteger = Integer.parseInt(pastkey);
		// ʧЧʱ��
		Timestamp pastTime = new Timestamp(System.currentTimeMillis() + 1000
				* 60 * 60 * outTimeInteger);
		newpassMail.setId(idString);
		newpassMail.setUsername(userName);
		newpassMail.setCreatedate(createTime);
		newpassMail.setPastdate(pastTime);
		try {
			changePasswordService.inser(newpassMail);
			return idString;
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * ��ȡ�޸�������ʱ��
	 * @param idString
	 * @return out:��ʱ,others ����:�û���
	 * @throws Exception 
	 */
	public String readPassInfo(String idString) throws Exception{
		TabNewpassMail newpassMail= changePasswordService.readInfo(idString);
		if(newpassMail==null){
			return null;
		}else{
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			if (timestamp.before(newpassMail.getPastdate())) {
				//�����û���
				return newpassMail.getUsername();
			} else {
				//��ʱ
				return "out";
			}
		}
	}
	
	/**
	 * �޸����롣
	 * @param userName
	 * @param newPassword
	 * @return �ɹ���true,ʧ�ܣ�fasle
	 * @throws Exception 
	 */
	public boolean updateUserInfo(String userName,String newPassword) throws Exception{
	    String passString=EncryptUtil.MD5Encode(newPassword);
	    TabUserinfoBase userinfoBase= changePasswordService.findByID(userName);
	    userinfoBase.setPassword(passString);
	    return changePasswordService.uodateUserInfo(userinfoBase);
	    
	}
}
