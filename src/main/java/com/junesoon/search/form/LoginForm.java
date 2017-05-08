package com.junesoon.search.form;

import javax.annotation.Resource;

/**
 * ��½����
 * @author NDNW��
 *
 */
@Resource
public class LoginForm{

		//�û���
	private String userName;
		
		//����
		private String password;
		
		//��ס��
		private String remberMe;
		
		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRemberMe() {
			return remberMe;
		}

		public void setRemberMe(String remberMe) {
			this.remberMe = remberMe;
		}
}
