package com.junesoon.search.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.junesoon.search.util.LoggerMessage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author NDNW.
 * 
 */
@Scope("prototype")
@Controller("failAction")
@Namespace("/")
public class failAction extends ActionSupport {

	/**
	 * ���кš�
	 */
	private static final long serialVersionUID = 246566192593466683L;
	// ��־�ļ�
	private static Logger logger = Logger.getLogger(loginAction.class);

	/**
	 * ��ת����ʾҳ��
	 * 
	 * @return ��ʾҳ��
	 */
	@Action("fail")
	public String success() {
		logger.info(LoggerMessage.REGTION_PROMPT_VIEW);
		return "fail.jsp";
	}
}
