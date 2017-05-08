package com.junesoon.search.logic;

import javax.annotation.Resource;

import com.junesoon.search.entity.TabUserinfoBase;
import com.junesoon.search.service.LoginService;
import com.junesoon.search.util.EncryptUtil;
/**
 * ��¼�߼��㡣
 * @author NDNW��
 *
 */
public class LoginLogic {
	
	@Resource
	LoginService loginService;
	
	//�û���ϢУ��
	public TabUserinfoBase loginCheck(String userName,String password) {
		LoginService loginService=new LoginService();
		//��װ��������bean
		TabUserinfoBase userinfoBase=new TabUserinfoBase();
		userinfoBase.setUserName(userName);
		password=EncryptUtil.MD5Encode(password);
		userinfoBase.setPassword(password);
		userinfoBase.setUserFlag("1");
		userinfoBase=(TabUserinfoBase) loginService.getByParma(userinfoBase);
		
		System.out.println("logic");
		return userinfoBase;
		
	}
	
}
