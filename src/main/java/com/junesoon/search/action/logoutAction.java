package com.junesoon.search.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.junesoon.search.util.LoggerMessage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("logoutAction")
public class logoutAction extends ActionSupport {

	/**
	 * ���л�ID.
	 */
	private static final long serialVersionUID = 8852376939486839483L;
	// ��־�ļ�
	private static Logger logger = Logger.getLogger(logoutAction.class);
	
	@Action
	public String logout(){
		logger.info(LoggerMessage.LOGOUT_USER_START);
		//��ȡsession
		ActionContext.getContext().getSession().clear();
		return "search";
	}
}
