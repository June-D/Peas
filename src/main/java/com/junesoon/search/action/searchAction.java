package com.junesoon.search.action;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.junesoon.search.util.LoggerMessage;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ��������
 * @author NDNW
 *
 */
@Scope("prototype")
@Controller("searchAction")
public class searchAction extends ActionSupport{

	/**
	 * ���л�ID
	 */
	private static final long serialVersionUID = 8528018371253699703L;
	
	//��־�ļ�
	private static Logger logger = Logger.getLogger(searchAction.class);
	 
	//���ʻ�
	private Locale request_locale;
	
	public Locale getRequest_locale() {
		return request_locale;
	}

	public void setRequest_locale(Locale request_locale) {
		this.request_locale = request_locale;
	}

	@Action("search")
	public String search() throws Exception {
		
		logger.info(LoggerMessage.SEARCH_METHOD_START);
		
		ActionContext actionContext=ActionContext.getContext();

		Integer integer=(Integer) actionContext.getApplication().get("counter");
	
		if(integer==null)
		{
			integer=1;
		}
		else {
			integer=integer+1;
		}
		System.out.println("���ʴ�����"+integer);
		HttpServletRequest request=ServletActionContext.getRequest();
		String adressipString=request.getRemoteAddr();
		System.out.println(adressipString);
		logger.info(LoggerMessage.SEARCH_PEOPLE_NUMS);
		actionContext.getApplication().put("counter", integer);
		logger.info(LoggerMessage.SEARCH_COUNTER_NUMS+integer+LoggerMessage.SEARCH_BIAOJI_DUXIAN+LoggerMessage.SEARCH_VISITER_IP);
		logger.info(LoggerMessage.SEARCH_RETURN_PAGES);	
		return "search.jsp";		
	}
	
	@Action("langLocale")
	public String langLocale() throws Exception {
		if ((Locale.US).equals(request_locale)) {
			ResourceBundle bundle = ResourceBundle.getBundle("globalMessages",
					Locale.US);

		} else if ((Locale.CHINA).equals(request_locale)) {
			ResourceBundle bundle = ResourceBundle.getBundle("globalMessages",
					Locale.CHINA);
		}
		
		return "search";
	}

}
