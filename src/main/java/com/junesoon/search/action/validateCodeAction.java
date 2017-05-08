package com.junesoon.search.action;

import java.io.ByteArrayInputStream;

import org.apache.struts2.convention.annotation.Action;

import com.junesoon.search.util.ValidateCodeUtil;
import com.opensymphony.xwork2.ActionSupport;

public class validateCodeAction extends ActionSupport{

	/**
	 * ���л�ID��
	 */
	private static final long serialVersionUID = -8863748058208874257L;

	 //ͼƬ��
	private ByteArrayInputStream imageStream;
	
	public ByteArrayInputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(ByteArrayInputStream imageStream) {
		this.imageStream = imageStream;
	}

	@Override
	@Action("validateCode")
	public String execute() throws Exception {

		this.setImageStream(this.getValidateImage());
		
		return SUCCESS;
	}
	
	public ByteArrayInputStream getValidateImage() {
		
		ValidateCodeUtil validateCodeUtil = new ValidateCodeUtil();
		    try {
		    	return validateCodeUtil.getRandcode();//���ͼƬ����
		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
			
	}

}
