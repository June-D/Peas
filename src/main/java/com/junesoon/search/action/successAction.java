package com.junesoon.search.action;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.junesoon.search.util.LoggerMessage;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ��ת���ɹ�ҳ�档
 * 
 * @author NDNW��
 * 
 */
@Scope("prototype")
@Controller("successAction")
@Namespace("/")
public class successAction extends ActionSupport {

	/**
	 * ���кš�
	 */
	private static final long serialVersionUID = 8302379625065125715L;
	// ��־�ļ�
	private static Logger logger = Logger.getLogger(loginAction.class);

	/**
	 * ��ת����ʾҳ��
	 * 
	 * @return ��ʾҳ��
	 */
	@Action("success")
	public String success() {
		logger.info(LoggerMessage.REGTION_PROMPT_VIEW);
		return "success.jsp";
	}
}
