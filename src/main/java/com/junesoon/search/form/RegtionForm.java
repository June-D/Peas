package com.junesoon.search.form;

import javax.faces.bean.SessionScoped;

import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * ��½����
 * 
 * @author NDNW��
 * 
 */
@SessionScoped
@SessionAttributes
public class RegtionForm {

	// �û���
	private String userName;

	// ����
	private String password;

	// ȷ������
	private String repassword;

	// �����ַ
	private String email;

	// ��֤��
	private String validatorCode;

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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getValidatorCode() {
		return validatorCode;
	}

	public void setValidatorCode(String validatorCode) {
		this.validatorCode = validatorCode;
	}

}
